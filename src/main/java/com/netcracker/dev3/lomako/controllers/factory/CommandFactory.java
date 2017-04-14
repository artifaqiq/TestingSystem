/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.factory;

import com.netcracker.dev3.lomako.controllers.commands.Command;
import com.netcracker.dev3.lomako.controllers.commands.dashboard.MainCommand;
import com.netcracker.dev3.lomako.controllers.commands.user.LoginCommand;
import com.netcracker.dev3.lomako.controllers.commands.user.RegisterCommand;
import com.netcracker.dev3.lomako.controllers.commands.user.LogOutCommand;
import com.netcracker.dev3.lomako.controllers.commands.welcome.WelcomeCommand;
import com.netcracker.dev3.lomako.controllers.enums.CommandName;

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
        Command command = null;

        switch (name) {
            case WELCOME:
                command = new WelcomeCommand();
                break;
            case LOGIN:
                command = new LoginCommand();
                break;
            case REGISTER:
                command = new RegisterCommand();
                break;
            case LOGOUT:
                command = new LogOutCommand();
                break;
            case NEWS:
                command = new MainCommand();
                break;
            default:
                throw new IllegalArgumentException();

        }

        return command;
    }
}
