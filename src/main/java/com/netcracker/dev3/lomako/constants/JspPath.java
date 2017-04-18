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

    /* Results */
    public static final String TEST_RESULTS_BY_TEST = BASE_PATH + "/results/by-test.jsp";
    public static final String TEST_RESULTS_BY_USER = BASE_PATH + "/results/by-user.jsp";

    /* Tags */
    public static final String TAG_CLOUD = BASE_PATH + "/tags/cloud.jsp";

    /* Users */
    public static final String LOGIN = BASE_PATH + "/users/login.jsp";
    public static final String REGISTER = BASE_PATH + "/users/register.jsp";
    public static final String ALL_USERS = BASE_PATH + "/users/index.jsp";

    /* Tests */
    public static final String TESTS_INDEX = BASE_PATH + "/tests/index.jsp";
    public static final String EDIT_TEST = BASE_PATH + "/tests/edit.jsp";
    public static final String SOLVE_TEST = BASE_PATH + "/tests/solve.jsp";

    /* Errors */
    public static final String ERROR_500 = BASE_PATH + "/errors/500.jsp";
    public static final String ERROR_403 = BASE_PATH + "/errors/403.jsp";


}
