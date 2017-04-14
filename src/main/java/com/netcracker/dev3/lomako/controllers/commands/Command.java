/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lomako
 * @version 1.0
 */
public interface Command {
    String execute(HttpServletRequest req) throws Exception;
}
