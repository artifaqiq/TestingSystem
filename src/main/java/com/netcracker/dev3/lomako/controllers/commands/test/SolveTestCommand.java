/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.test;

import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestService;
import com.netcracker.dev3.lomako.services.impl.TestServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public class SolveTestCommand extends Command {
    private static final TestService testService = TestServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        try {
            long id = Long.valueOf(req.getParameter("id"));
            if (testService.findById(id) == null) {
                resp.sendRedirect(CommandPath.MY_TESTS);
            } else {
                req.setAttribute("tr", translator);
                req.getRequestDispatcher(JspPath.SOLVE_TEST).forward(req, resp);
            }

        } catch (NumberFormatException e) {
            resp.sendRedirect(CommandPath.MY_TESTS);
        }
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
