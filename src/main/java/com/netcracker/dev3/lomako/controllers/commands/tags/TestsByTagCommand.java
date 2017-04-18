/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.tags;

import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TagService;
import com.netcracker.dev3.lomako.services.impl.TagServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestsByTagCommand extends Command {

    private static final TagService tagService = TagServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String tagTitle = req.getParameter("tag");

        if(tagTitle == null) {
            resp.sendRedirect(CommandPath.MY_TESTS);
        }

        req.setAttribute("tests", tagService.findTestsByTagTitle(tagTitle));
        req.getRequestDispatcher(JspPath.TESTS_INDEX).forward(req, resp);

    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }
}
