/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.locale;

import com.netcracker.dev3.lomako.constants.CommandPath;
import com.netcracker.dev3.lomako.constants.Language;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.controllers.commands.CommandName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public class SetLocaleCommand extends Command {
    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        exec(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        exec(req, resp);
    }

    private void exec(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String localeString = req.getParameter("locale");
        String callback = req.getParameter("callback");

        if (localeString == null || callback == null) {
            resp.sendRedirect(CommandPath.TAG_CLOUD);
            return;
        }

        req.getSession().setAttribute("locale", localeString);
        resp.sendRedirect(callback);


    }
}
