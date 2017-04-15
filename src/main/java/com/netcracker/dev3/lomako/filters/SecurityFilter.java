/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.filters;

import com.netcracker.dev3.lomako.beans.user.Role;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.jsp.enums.CommandName;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.utils.AccessControl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lomako
 * @version 1.0
 */
public class SecurityFilter implements Filter {

    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)req;
        String commandString = request.getParameter("command");
        CommandName commandName = null;
        if(commandString == null) {
            filterChain.doFilter(req, resp);
        } else {
            commandName = CommandName.valueOf(commandString.toUpperCase());
        }

        String roleString = (String)((HttpServletRequest) req).getSession().getAttribute("role");
        Role role;
        if (roleString == null) {
            role = Role.GUEST;
        } else {
            role = Role.valueOf(roleString);
        }

        if(!AccessControl.hasAccess(role, commandName)) {
            req.getRequestDispatcher(JspPath.ERROR_403).forward(req, resp);
        }


        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
    
}
