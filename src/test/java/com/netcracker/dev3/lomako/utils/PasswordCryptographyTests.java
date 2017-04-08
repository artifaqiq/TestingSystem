/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Lomako
 * @version 1.0
 */
public class PasswordCryptographyTests {

    @Test
    public void main() {
        String password1 = "Gh12345678";
        String password2 = "_6526x3S235";
        String password3 = "235326dsx";

        String encryptedPassword1 = PasswordCryptography.crypt(password1);
        String encryptedPassword2 = PasswordCryptography.crypt(password2);

        System.out.println(encryptedPassword1);
        System.out.println(encryptedPassword2);

        assertTrue(PasswordCryptography.check(password1, encryptedPassword1));
        assertTrue(PasswordCryptography.check(password2, encryptedPassword2));
        assertFalse(PasswordCryptography.check(password3, encryptedPassword1));
    }
}
