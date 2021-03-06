/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.tests;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestService;
import com.netcracker.dev3.lomako.services.impl.TestServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class MyTestsCommand extends Command {
    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        TestService testService = TestServiceImpl.getInstance();
        String userIdString = req.getParameter("id");
        if(userIdString == null) {
            resp.sendRedirect(CommandPath.TAG_CLOUD);
            return;
        }

        try {
            long userId = Long.valueOf(userIdString);
            List<Test> tests = testService.findByUserId(userId);
            req.setAttribute("tests", tests);
            req.getRequestDispatcher(JspPath.TESTS_INDEX).forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendRedirect(CommandPath.TAG_CLOUD);
        }

    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
