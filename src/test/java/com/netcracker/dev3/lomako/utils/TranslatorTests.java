/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import com.netcracker.dev3.lomako.constants.I10nResource;
import com.netcracker.dev3.lomako.constants.Language;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * @author Lomako
 * @version 1.0
 */
public class TranslatorTests {

    @Test
    public void translate() {
        final Translator translator = Translator.getInstance();

        assertEquals(translator.translate(I10nResource.USER, "login", new Locale(Language.EN)),
                "sign in");
        assertEquals(translator.translate(I10nResource.USER, "logout", new Locale(Language.EN)),
                "log out");
        assertEquals(translator.translate(I10nResource.USER, "login", new Locale(Language.RU)),
                "войти");
        assertEquals(translator.translate(I10nResource.USER, "logout", new Locale(Language.RU)),
                "выйти");


    }
}
