/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.controllers.commands;

import com.netcracker.dev3.lomako.controllers.commands.locale.SetLocaleCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.rest.CreateTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.rest.DeleteTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.rest.ReadTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.rest.UpdateTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.rest.ReadTestForSolveCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.rest.SendSolvedTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.results.TestResultsByTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.results.TestResultsByUserCommand;
import com.netcracker.dev3.lomako.controllers.commands.tags.TagCloudCommand;
import com.netcracker.dev3.lomako.controllers.commands.tags.TestsByTagCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.EditTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.SolveTestCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.AllTestsCommand;
import com.netcracker.dev3.lomako.controllers.commands.tests.MyTestsCommand;
import com.netcracker.dev3.lomako.controllers.commands.users.AllUsersCommand;
import com.netcracker.dev3.lomako.controllers.commands.users.LogOutCommand;
import com.netcracker.dev3.lomako.controllers.commands.users.LoginCommand;
import com.netcracker.dev3.lomako.controllers.commands.users.RegisterCommand;

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
            case ALL_TESTS:
                command = new AllTestsCommand();
                break;
            case TESTS_BY_TAG:
                command = new TestsByTagCommand();
                break;
            case TEST_RESULTS_BY_TEST:
                command = new TestResultsByTestCommand();
                break;
            case TEST_RESULTS_BY_USER:
                command = new TestResultsByUserCommand();
                break;
            case ALL_USERS:
                command = new AllUsersCommand();
                break;
            case SET_LOCALE:
                command = new SetLocaleCommand();
                break;
            default:
                throw new IllegalArgumentException();

        }

        return command;
    }
}
