/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import com.netcracker.dev3.lomako.beans.user.Role;
import com.netcracker.dev3.lomako.controllers.jsp.enums.CommandName;

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
                CommandName.CREATE_TEST,
                CommandName.MY_TESTS,
        });

        roleToCommand.put(Role.ADMIN, new CommandName[] {
                CommandName.LOGIN,
                CommandName.REGISTER,
                CommandName.LOGOUT,
                CommandName.MAIN,
                CommandName.CREATE_TEST,
                CommandName.MY_TESTS,
        });
    }

    public static boolean hasAccess(Role role, CommandName commandName) {
        return Arrays.asList(roleToCommand.get(role)).contains(commandName);
    }
}
