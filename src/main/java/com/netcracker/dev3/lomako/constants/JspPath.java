/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.constants;

/**
 * @author Lomako
 * @version 1.0
 */
public final class JspPath {
    private static final String BASE_PATH = "/WEB-INF/jsp";

    /* Dashboard */
    public static final String MAIN = BASE_PATH + "/dashboard/main.jsp";
    public static final String MY_TESTS = BASE_PATH + "/dashboard/my-tests.jsp";

    /* User */
    public static final String LOGIN = BASE_PATH + "/user/login.jsp";
    public static final String REGISTER = BASE_PATH + "/user/register.jsp";

    /* Test */
    public static final String EDIT_TEST = BASE_PATH + "/test/edit.jsp";

    /* Error */
    public static final String ERROR_500 = BASE_PATH + "/error/500.jsp";
    public static final String ERROR_403 = BASE_PATH + "/error/403.jsp";

}
