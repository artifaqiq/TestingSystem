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
        final Translator translator1 = new Translator(I10nResource.USER, null);
        final Translator translator2 = new Translator(I10nResource.USER, Language.RU);

        assertEquals(translator1.translate("login"), "sign in");
        assertEquals(translator2.translate("login"), "войти");


    }
}
