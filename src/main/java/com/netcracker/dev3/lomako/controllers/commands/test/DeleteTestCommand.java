/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.test;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestService;
import com.netcracker.dev3.lomako.services.impl.TestServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public class DeleteTestCommand extends Command {

    private static final TestService testService = TestServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        exec(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        exec(req, resp);
    }

    private void exec(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = Long.valueOf(req.getParameter("id"));
        testService.delete(testService.findById(id));
        resp.sendRedirect(CommandPath.MY_TESTS);
    }
}
