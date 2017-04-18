/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.results;

import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestResultService;
import com.netcracker.dev3.lomako.services.UserService;
import com.netcracker.dev3.lomako.services.impl.TestResultServiceImpl;
import com.netcracker.dev3.lomako.services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestResultsByUserCommand extends Command {

    private static final TestResultService testResultService = TestResultServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userIdString = req.getParameter("id");
        if (userIdString == null) {
            resp.sendRedirect(CommandPath.MY_TESTS);
            return;
        }

        try {
            long userId = Long.valueOf(userIdString);
            List<TestResult> testResults = testResultService.findByUserId(userId);
            req.setAttribute("test_results", testResults);
            req.getRequestDispatcher(JspPath.TEST_RESULTS_BY_USER).forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect(CommandPath.MY_TESTS);
        }

    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }
}
