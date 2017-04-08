/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Lomako
 * @version 1.0
 */
public class PasswordCryptography {

    private static final String SALT = "KJTIYi7gvygxui7t3423";

    public static String crypt(String password) {
        return DigestUtils.md5Hex(password + SALT);
    }

    public static boolean check(String password, String encryptedPassword) {
        return DigestUtils.md5Hex(password + SALT).equals(encryptedPassword);
    }
}
