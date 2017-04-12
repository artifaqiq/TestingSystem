/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Lomako
 * @version 1.0
 */
public enum Translator {
    INSTANCE;

    public String translate(String resourceBundle, String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(resourceBundle, locale, new Utf8Control());
        return bundle.getString(key);
    }

    public static Translator getInstance() { return INSTANCE; }
}
