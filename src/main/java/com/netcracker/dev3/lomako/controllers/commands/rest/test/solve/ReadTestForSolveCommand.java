/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.rest.test.solve;

import com.google.gson.Gson;
import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestService;
import com.netcracker.dev3.lomako.services.impl.TestServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Lomako
 * @version 1.0
 */
@SuppressWarnings("Duplicates")
public class ReadTestForSolveCommand extends Command {
    private static final TestService testService = TestServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long testId = 0;
        PrintWriter writer = resp.getWriter();

        if (req.getParameter("id") == null) {
            send404(resp);
            return;
        } else {
            testId = Long.valueOf(req.getParameter("id"));
        }

        Test test = testService.findById(testId);

        if (test == null) {
            send404(resp);
            return;
        }

        Gson gson = new Gson();

        writer.print(gson.toJson(test, Test.class));
        writer.flush();
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }

    private void send404(HttpServletResponse resp) throws Exception {
        PrintWriter writer = resp.getWriter();

        Gson gson = new Gson();

        writer.print(gson.toJson(new Error404Model("Not found test", 404)));
        writer.flush();
        resp.setStatus(404);
    }

    private class Error404Model {
        private String message;
        private int status;

        Error404Model(String message, int status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
