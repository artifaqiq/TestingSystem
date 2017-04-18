/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.users;

import com.netcracker.dev3.lomako.beans.User;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.UserService;
import com.netcracker.dev3.lomako.services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class AllUsersCommand extends Command {

    private static final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<User> users = userService.findAll();

        req.setAttribute("users", users);
        req.getRequestDispatcher(JspPath.ALL_USERS).forward(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }
}
