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
public class LoginCommand implements Command {
    private static final UserDao userDao = UserDaoImpl.getInstance();

    private Translator translator;

    @Override
    public String execute(HttpServletRequest req) throws Exception {

        final String locale = (String) req.getSession().getAttribute("locale");
        translator = new Translator(I10nResource.USER, locale);
        req.setAttribute("tr", translator);

        if ("POST".equals(req.getMethod())) {
            return executePost(req);
        } else if ("GET".equals(req.getMethod())) {
            return executeGet(req);
        } else {
            return JspPath.LOGIN;
        }
    }

    private String executeGet(HttpServletRequest req) {
        return JspPath.LOGIN;
    }

    private String executePost(HttpServletRequest req) throws Exception {
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
