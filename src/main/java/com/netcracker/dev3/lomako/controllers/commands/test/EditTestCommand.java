/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.test;

import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public final class EditTestCommand extends Command {

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setAttribute("tr", translator);
        req.getRequestDispatcher(JspPath.EDIT_TEST).forward(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/").forward(req, resp);
    }


}