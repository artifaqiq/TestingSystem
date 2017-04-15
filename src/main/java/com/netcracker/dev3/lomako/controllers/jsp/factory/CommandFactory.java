/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.jsp.factory;

import com.netcracker.dev3.lomako.controllers.jsp.commands.Command;
import com.netcracker.dev3.lomako.controllers.jsp.commands.dashboard.MainCommand;
import com.netcracker.dev3.lomako.controllers.jsp.commands.dashboard.MyTestsCommand;
import com.netcracker.dev3.lomako.controllers.jsp.commands.test.EditingTest;
import com.netcracker.dev3.lomako.controllers.jsp.commands.user.LoginCommand;
import com.netcracker.dev3.lomako.controllers.jsp.commands.user.RegisterCommand;
import com.netcracker.dev3.lomako.controllers.jsp.commands.user.LogOutCommand;
import com.netcracker.dev3.lomako.controllers.jsp.enums.CommandName;

/**
 * @author Lomako
 * @version 1.0
 */
public enum CommandFactory  {

    INSTANCE;

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public Command getCommand(CommandName name) {
        Command command;

        switch (name) {
            case LOGIN:
                command = new LoginCommand();
                break;
            case REGISTER:
                command = new RegisterCommand();
                break;
            case LOGOUT:
                command = new LogOutCommand();
                break;
            case MAIN:
                command = new MainCommand();
                break;
            case EDIT_TEST:
                command = new EditingTest();
                break;
            case MY_TESTS:
                command = new MyTestsCommand();
                break;
            default:
                throw new IllegalArgumentException();

        }

        return command;
    }
}
