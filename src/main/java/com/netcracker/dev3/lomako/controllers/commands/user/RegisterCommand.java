/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.user;

import com.netcracker.dev3.lomako.beans.user.Role;
import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.exceptions.dao.UserEmailUniqueConflictException;
import com.netcracker.dev3.lomako.utils.PasswordCryptography;
import com.netcracker.dev3.lomako.utils.Translator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


/**
 * @author Lomako
 * @version 1.0
 */
public class RegisterCommand implements Command {

    private static final UserDao userDao = UserDaoImpl.getInstance();

    private Translator translator;

    @Override
    public String execute(HttpServletRequest req) throws Exception {
        final String locale = (String) req.getSession().getAttribute("locale");
        translator = new Translator(I10nResource.USER, locale);
        req.setAttribute("tr", translator);

        if(req.getMethod().equals("GET")) {
            return executeGet(req);
        } else if (req.getMethod().equals("POST")) {
            return executePost(req);
        } else {
            return "/";
        }

    }

    private String executeGet(HttpServletRequest req) {
        return JspPath.REGISTER;
    }

    private String executePost(HttpServletRequest req) throws Exception {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");

        User user = new User(
                0,
                email,
                PasswordCryptography.crypt(password),
                firstName,
                lastName,
                Role.USER,
                null,
                null
        );

        try {
            userDao.save(user);
            user = userDao.findByEmail(email);

            setSessionUserAttributes(user, req.getSession());

        }

        catch (UserEmailUniqueConflictException e) {
            req.setAttribute("notice", translator.translate("user_with_some_email_already_exists"));
            return JspPath.REGISTER;
        }
        return JspPath.MAIN;
    }

    private static void setSessionUserAttributes(User user, HttpSession session) {
        session.setAttribute("id", user.getId());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("firstName", user.getFirstName());
        session.setAttribute("lastName", user.getLastName());
        session.setAttribute("role", user.getRole().toString());
    }
}
