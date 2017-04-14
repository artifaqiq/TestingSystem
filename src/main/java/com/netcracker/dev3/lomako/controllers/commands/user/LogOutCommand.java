/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.user;

import com.netcracker.dev3.lomako.controllers.commands.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lomako
 * @version 1.0
 */
public final class LogOutCommand extends Command {

    @Override
    protected String executeGet(HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
        return "/";
    }

    @Override
    protected String executePost(HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
        return "/";
    }
}
