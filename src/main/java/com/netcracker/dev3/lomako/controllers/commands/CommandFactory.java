/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands;

import com.netcracker.dev3.lomako.controllers.commands.dashboard.MainCommand;
import com.netcracker.dev3.lomako.controllers.commands.dashboard.MyTestsCommand;
import com.netcracker.dev3.lomako.controllers.commands.dashboard.TagCloudCommand;
import com.netcracker.dev3.lomako.controllers.commands.rest.test.crud.CreateTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.rest.test.crud.DeleteTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.rest.test.crud.ReadTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.rest.test.crud.UpdateTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.rest.test.solve.ReadTestForSolveCommand;
import com.netcracker.dev3.lomako.controllers.commands.rest.test.solve.SendSolvedTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.test.EditTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.test.SolveTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.user.LogOutCommand;
import com.netcracker.dev3.lomako.controllers.commands.user.LoginCommand;
import com.netcracker.dev3.lomako.controllers.commands.user.RegisterCommand;

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
                command = new EditTestCommand();
                break;
            case MY_TESTS:
                command = new MyTestsCommand();
                break;
            case CREATE_TEST:
                command = new CreateTestCommand();
                break;
            case READ_TEST:
                command = new ReadTestCommand();
                break;
            case UPDATE_TEST:
                command = new UpdateTestCommand();
                break;
            case DELETE_TEST:
                command = new DeleteTestCommand();
                break;
            case SEND_SOLVED_TEST:
                command = new SendSolvedTestCommand();
                break;
            case READ_TEST_FOR_SOLVE:
                command = new ReadTestForSolveCommand();
                break;
            case SOLVE_TEST:
                command = new SolveTestCommand();
                break;
            case TAG_CLOUD:
                command = new TagCloudCommand();
                break;
            default:
                throw new IllegalArgumentException();

        }

        return command;
    }
}
