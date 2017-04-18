/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.results;

import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestResultService;
import com.netcracker.dev3.lomako.services.impl.TestResultServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestResultsByTestCommand extends Command {

    private static final TestResultService testResultService = TestResultServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String testIdString = req.getParameter("id");
        if (testIdString == null) {
            resp.sendRedirect(CommandPath.MY_TESTS);
            return;
        }

        try {
            long testId = Long.valueOf(testIdString);
            List<TestResult> testResults = testResultService.findByTestId(testId);
            req.setAttribute("test_results", testResults);
            req.getRequestDispatcher(JspPath.TEST_RESULTS_BY_TEST).forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect(CommandPath.MY_TESTS);
        }
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }
}
