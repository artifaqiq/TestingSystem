/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.constants;

/**
 * @author Lomako
 * @version 1.0
 */
public final class CommandPath {

    /* Tags */
    public static final String TAG_CLOUD = "/Controller?command=tag_cloud";
    public static final String TESTS_BY_TAG = "/Controller?command=tests_by_tag";

    /* Users */
    public static final String LOGIN = "/Controller?command=login";
    public static final String REGISTER = "/Controller?command=register";
    public static final String LOGOUT = "/Controller?command=logout";
    public static final String ALL_USERS = "/Controller?command=all_users";

    /* Test (REST) */
    public static final String READ_TEST = "/Controller?command=read_test";
    public static final String UPDATE_TEST = "/Controller?command=update_test";
    public static final String READ_TEST_FOR_SOLVE = "/Controller?command=read_test_for_solve";
    public static final String SEND_SOLVED_TEST = "/Controller?command=send_solved_test";

    /* Test */
    public static final String EDIT_TEST = "/Controller?command=edit_test";
    public static final String CREATE_TEST = "/Controller?command=create_test";
    public static final String DELETE_TEST = "/Controller?command=delete_test";
    public static final String ALL_TESTS = "/Controller?command=all_tests";
    public static final String MY_TESTS = "/Controller?command=my_tests";
    public static final String SOLVE_TEST = "/Controller?command=solve_test";

    /* Test results */
    public static final String TEST_RESULTS_BY_USER = "/Controller?command=test_results_by_user";
    public static final String TEST_RESULTS_BY_TEST = "/Controller?command=test_results_by_test";

    /* Locale */
    public static final String SET_LOCALE = "/Controller?command=set_locale";
}
