/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.tests;

import com.netcracker.dev3.lomako.beans.Test;
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
public class AllTestsCommand extends Command {

    private static final TestService testService = TestServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Test> tests = testService.findAll();
        req.setAttribute("tests", tests);
        req.setAttribute("testCount", tests.size());
        req.getRequestDispatcher(JspPath.TESTS_INDEX).forward(req, resp);

    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }
}
