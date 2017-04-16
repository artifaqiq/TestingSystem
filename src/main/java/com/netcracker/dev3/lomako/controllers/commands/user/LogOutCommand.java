/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.user;

import com.netcracker.dev3.lomako.controllers.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public final class LogOutCommand extends Command {

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getSession().invalidate();
        resp.sendRedirect("/");
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getSession().invalidate();
        resp.sendRedirect("/");
    }
}
