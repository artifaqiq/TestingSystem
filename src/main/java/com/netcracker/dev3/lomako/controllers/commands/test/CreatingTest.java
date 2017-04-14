/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.test;

import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.utils.Translator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lomako
 * @version 1.0
 */
public final class CreatingTest extends Command {

    @Override
    protected String executeGet(HttpServletRequest req) {
        return JspPath.CREATE_TEST;
    }

    @Override
    protected String executePost(HttpServletRequest req) {
        return null;
    }


}
