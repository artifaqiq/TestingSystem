/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import com.netcracker.dev3.lomako.constants.Language;
import com.sun.istack.internal.Nullable;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Lomako
 * @version 1.0
 */
public final class Translator {

    private final ResourceBundle bundle;

    public Translator(String resourceBundlePath, @Nullable String localeName) {
        final Locale locale;
        if (localeName == null) {
            locale = new Locale(Language.RU);
        } else {
            locale = new Locale(localeName);
        }

        this.bundle = ResourceBundle.getBundle(resourceBundlePath, locale, new Utf8Control());
    }

    public String translate(String key) {
        return bundle.getString(key);
    }

}
