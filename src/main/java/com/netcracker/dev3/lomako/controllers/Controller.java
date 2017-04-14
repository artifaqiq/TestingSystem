/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers;

import com.netcracker.dev3.lomako.constants.JspPath;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.controllers.enums.CommandName;
import com.netcracker.dev3.lomako.controllers.factory.CommandFactory;
import com.netcracker.dev3.lomako.utils.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processing(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processing(req, resp);
    }

    private void processing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println(req.getMethod() + ": ");
        for (String key : req.getParameterMap().keySet()) {
            System.out.print(key + " -> ");
            System.out.println(req.getParameterMap().get(key)[0]);
        }

        CommandName commandName = CommandName.valueOf(req.getParameter("command").toUpperCase());
        Command command = CommandFactory.getInstance().getCommand(commandName);

        String path;
        try {
            path = command.execute(req);
        } catch (Exception e) {
            Logger.getInstance().fatal(this.getClass(), e.getMessage());
            path = JspPath.ERROR_500;
        }

        req.getRequestDispatcher(path).forward(req, resp);


    }
}
