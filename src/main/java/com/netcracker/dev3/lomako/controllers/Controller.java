/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers;

import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.controllers.commands.CommandName;
import com.netcracker.dev3.lomako.controllers.commands.CommandFactory;
import com.netcracker.dev3.lomako.utils.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

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

        System.out.println();
        Enumeration<String> names = req.getSession().getAttributeNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            System.out.print(key + " -> ");
            System.out.println(req.getSession().getAttribute(key));
        }

        CommandName commandName = CommandName.valueOf(req.getParameter("command").toUpperCase());
        Command command = CommandFactory.getInstance().getCommand(commandName);

        try {
            command.execute(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getInstance().fatal(this.getClass(), e.getMessage());

        }

    }
}
