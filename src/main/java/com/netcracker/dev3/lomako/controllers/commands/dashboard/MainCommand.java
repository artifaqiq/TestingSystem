/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.dashboard;

import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lomako
 * @version 1.0
 */
public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return JspPath.MAIN;
    }
}
