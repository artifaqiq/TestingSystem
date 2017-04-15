/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.jsp.commands;

import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.utils.Translator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public abstract class Command {

    protected Translator translator;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        final String locale = (String) req.getSession().getAttribute("locale");
        translator = new Translator(I10nResource.USER, locale);
        req.setAttribute("tr", translator);

        if ("POST".equals(req.getMethod())) {
            executePost(req, resp);
        } else if ("GET".equals(req.getMethod())) {
            executeGet(req, resp);
        } else {
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }

    protected abstract void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    protected abstract void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
