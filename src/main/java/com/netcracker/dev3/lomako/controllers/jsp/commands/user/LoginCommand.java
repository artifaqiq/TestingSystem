/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.jsp.commands.user;

import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.jsp.commands.Command;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.utils.PasswordCryptography;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Lomako
 * @version 1.0
 */
public final class LoginCommand extends Command {
    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        req.getRequestDispatcher(JspPath.LOGIN).forward(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        User user = userDao.findByEmail(email);

        if (user == null || !PasswordCryptography.check(password, user.getEncryptedPassword())) {
            req.setAttribute("notice", translator.translate("incorrect_login_or_password"));
            req.getRequestDispatcher(JspPath.LOGIN).forward(req, resp);

        } else {
            setSessionUserAttributes(user, req.getSession());
            resp.sendRedirect(CommandPath.MAIN);
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
