/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands.test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.services.TestService;
import com.netcracker.dev3.lomako.services.impl.TestServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lomako
 * @version 1.0
 */
public class UpdateTestCommand extends Command {

    private static final TestService testService = TestServiceImpl.getInstance();

    @Override
    protected void executeGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/").forward(req, resp);
    }

    @Override
    protected void executePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Gson gson = new Gson();
        try {
            Test test = gson.fromJson(req.getReader(), Test.class);
            testService.update(test);

            String successMessage = gson.toJson(new Success200Model(), Success200Model.class);
            resp.getWriter().print(successMessage);
            resp.getWriter().flush();


        } catch (JsonSyntaxException e) {
            String errorMessage = gson.toJson(new Error422Model("Bad json syntax"), Error422Model.class);
            resp.setStatus(422);
            resp.getWriter().print(errorMessage);
            resp.getWriter().flush();
        }

    }

    private class Error422Model {
        private String message;
        private final int status = 422;

        public Error422Model(String message) {
            this.message = message;
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
    }

    private class Success200Model {
        private final int status = 200;
        private final String message = "OK";
    }
}
