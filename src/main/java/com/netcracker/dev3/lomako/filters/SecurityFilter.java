/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.filters;

import com.netcracker.dev3.lomako.beans.user.Role;
import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.jsp.enums.CommandName;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.utils.AccessControl;
import com.netcracker.dev3.lomako.utils.Translator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Lomako
 * @version 1.0
 */
public class SecurityFilter implements Filter {

    private static final UserDao userDao = UserDaoImpl.getInstance();

    protected Translator translator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        final String locale = (String) request.getSession().getAttribute("locale");
        translator = new Translator(I10nResource.USER, locale);
        request.setAttribute("tr", translator);

        String commandString = request.getParameter("command");
        CommandName commandName = null;
        if (commandString == null) {
            filterChain.doFilter(req, resp);
        } else {
            commandName = CommandName.valueOf(commandString.toUpperCase());
        }

        String roleString = (String) ((HttpServletRequest) req).getSession().getAttribute("role");
        Role role;
        if (roleString == null) {
            role = Role.GUEST;
        } else {
            role = Role.valueOf(roleString);
        }

        if (!AccessControl.hasAccess(role, commandName)) {
            req.setAttribute("notice", translator.translate("not_access_rights"));
            req.getRequestDispatcher(JspPath.LOGIN).forward(req, resp);
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() { }

}
