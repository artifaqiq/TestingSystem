/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.user;

import java.io.Serializable;

/**
 * @author Lomako
 * @version 1.0
 */
public enum Role implements Serializable {

    USER, ADMIN, GUEST;

    public int getIdInRolesTable() {
        switch (this) {
            case USER:
                return 1;
            case ADMIN:
                return 2;

            default:
                return 0;
        }

    }

    public static Role getRoleByIdInRoleTable(int id) {
        switch (id) {
            case 1:
                return Role.USER;
            case 2:
                return Role.ADMIN;

            default:
                return null;
        }
    }
}
