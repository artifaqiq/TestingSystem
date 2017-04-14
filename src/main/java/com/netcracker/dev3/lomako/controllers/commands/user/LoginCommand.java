/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.user;

import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.utils.PasswordCryptography;
import com.netcracker.dev3.lomako.utils.Translator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Lomako
 * @version 1.0
 */
public final class LoginCommand extends Command {
    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected String executeGet(HttpServletRequest req) {
        return JspPath.LOGIN;
    }

    @Override
    protected String executePost(HttpServletRequest req) throws Exception {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        User user = userDao.findByEmail(email);

        if (user == null || !PasswordCryptography.check(password, user.getEncryptedPassword())) {
            req.setAttribute("notice", translator.translate("incorrect_login_or_password"));
            return JspPath.LOGIN;

        } else {
            setSessionUserAttributes(user, req.getSession());
            return JspPath.MAIN;
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
