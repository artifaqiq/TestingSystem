/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import com.netcracker.dev3.lomako.beans.Role;
import com.netcracker.dev3.lomako.controllers.commands.CommandName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lomako
 * @version 1.0
 */
public final class AccessControl {

    private static final Map<Role, CommandName[]> roleToCommand;

    static {
        roleToCommand = new HashMap<>();

        roleToCommand.put(Role.GUEST, new CommandName[] {
                CommandName.LOGIN,
                CommandName.REGISTER
        });

        roleToCommand.put(Role.USER, new CommandName[] {
                CommandName.LOGIN,
                CommandName.REGISTER,
                CommandName.LOGOUT,
                CommandName.MAIN,
                CommandName.EDIT_TEST,
                CommandName.MY_TESTS,
                CommandName.CREATE_TEST,
                CommandName.READ_TEST,
                CommandName.DELETE_TEST,
                CommandName.READ_TEST_FOR_SOLVE,
                CommandName.SEND_SOLVED_TEST,
                CommandName.SOLVE_TEST,
                CommandName.TAG_CLOUD
        });

        roleToCommand.put(Role.ADMIN, new CommandName[] {
                CommandName.LOGIN,
                CommandName.REGISTER,
                CommandName.LOGOUT,
                CommandName.MAIN,
                CommandName.EDIT_TEST,
                CommandName.MY_TESTS,
                CommandName.CREATE_TEST,
                CommandName.READ_TEST,
                CommandName.DELETE_TEST,
                CommandName.READ_TEST_FOR_SOLVE,
                CommandName.SEND_SOLVED_TEST,
                CommandName.SOLVE_TEST,
                CommandName.TAG_CLOUD
        });
    }

    public static boolean hasAccess(Role role, CommandName commandName) {
        return Arrays.asList(roleToCommand.get(role)).contains(commandName);
    }
}
