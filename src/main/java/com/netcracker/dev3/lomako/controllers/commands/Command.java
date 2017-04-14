/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands;

import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.utils.Translator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lomako
 * @version 1.0
 */
public abstract class Command {

    protected Translator translator;

    public String execute(HttpServletRequest req) throws Exception {
        final String locale = (String) req.getSession().getAttribute("locale");
        translator = new Translator(I10nResource.USER, locale);
        req.setAttribute("tr", translator);

        if ("POST".equals(req.getMethod())) {
            return executePost(req);
        } else if ("GET".equals(req.getMethod())) {
            return executeGet(req);
        } else {
            return "/";
        }
    }

    protected abstract String executeGet(HttpServletRequest request) throws Exception;

    protected abstract String executePost(HttpServletRequest request) throws Exception;


}
