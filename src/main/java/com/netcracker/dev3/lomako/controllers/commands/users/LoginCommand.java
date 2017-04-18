/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.users;

import com.netcracker.dev3.lomako.beans.User;
import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.exceptions.service.UserNotFoundException;
import com.netcracker.dev3.lomako.services.UserService;
import com.netcracker.dev3.lomako.services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Lomako
 * @version 1.0
 */
public final class LoginCommand extends Command {
    private static final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        req.getRequestDispatcher(JspPath.LOGIN).forward(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        try {
            User user = userService.login(email, password);
            setSessionUserAttributes(user, req.getSession());
            resp.sendRedirect(CommandPath.TAG_CLOUD);
        } catch (UserNotFoundException e) {
            req.setAttribute("notice", translator.translate("incorrect_login_or_password"));
            req.getRequestDispatcher(JspPath.LOGIN).forward(req, resp);
        }
    }

    private static void setSessionUserAttributes(User user, HttpSession session) {
        session.setAttribute("id", user.getId());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("lastName", user.getLastName());
        session.setAttribute("firstName", user.getFirstName());
        session.setAttribute("role", user.getRole().toString());
    }
}
