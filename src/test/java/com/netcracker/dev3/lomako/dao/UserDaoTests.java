/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.user.Role;
import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.utils.PasswordCryptography;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Lomako
 * @version 1.0
 */
public class UserDaoTests {

    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Test
    public void save() throws SQLException {

        final String email = "test" + new Random().nextInt() + "@example.com";
        final String encryptedPassword = PasswordCryptography.crypt("12345678" + new Random().nextInt());
        final String firstName = "Vasya";
        final String lastName = "Pupkin";
        final Role role = Role.USER;

        User testUser = new User();
        testUser.setEmail(email);
        testUser.setEncryptedPassword(encryptedPassword);
        testUser.setFirstName(firstName);
        testUser.setLastName(lastName);
        testUser.setRole(role);

        long id = 0L;
        try {
            id = userDao.save(testUser);
        } catch (PersistException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Save user: " + testUser);
        System.out.println("id = " + id);

    }

    @Test
    public void update() throws SQLException, PersistException {

        final String email = "test" + new Random().nextInt() + "@example.com";
        final String encryptedPassword = PasswordCryptography.crypt("12345678");
        final String firstName = "Vasya";
        final String lastName = "Pupkin";
        final Role role = Role.USER;

        List<User> users = (List<User>)userDao.findAll();
        User user = users.get(Math.abs(new Random().nextInt()) % users.size());

        user.setEmail(email);
        user.setEncryptedPassword(encryptedPassword);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);

        userDao.update(user);

        User findedUser = userDao.findOne(user.getId());

        assertEquals(findedUser.getEmail(), email);
        assertEquals(findedUser.getEncryptedPassword(), encryptedPassword);
        assertEquals(findedUser.getFirstName(), firstName);
        assertEquals(findedUser.getLastName(), lastName);
        assertEquals(findedUser.getRole(), role);

        System.out.println("Updated user: " + findedUser);

    }

    @Test
    public void findAll() throws SQLException {
        List<User> users = (List<User>) userDao.findAll();

        assertNotNull(users);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findOne() throws SQLException {
        List<User> users = (List<User>) userDao.findAll();
        int index = Math.abs(new Random().nextInt()) % (users.size() - 1);

        User user1 = userDao.findOne(users.get(index).getId());

        assertTrue(user1.toString().equals(users.get(index).toString()));

        User user2 = userDao.findOne(2145245235L);
        assertNull(user2);

        System.out.println("Id = "+ users.get(index).getId());
        System.out.println(user1);
    }

    @Test
    public void count() throws SQLException {
        List<User> users = (List<User>) userDao.findAll();
        long count = userDao.count();
        assertEquals(users.size(), count);

        System.out.println("count = " + count);

    }

    @Test
    public void delete() throws SQLException {
        List<User> users = (List<User>) userDao.findAll();
        User user = users.get(Math.abs(new Random().nextInt()) % users.size());

        user.setId(3000);
        long id = user.getId();

        userDao.delete(user);

        assertNull(userDao.findOne(id));

        System.out.println("id = " + id);
    }

    @Test
    public void exists() throws SQLException {
        List<User> users = (List<User>) userDao.findAll();
        User user = users.get(Math.abs(new Random().nextInt()) % users.size());

        assertTrue(userDao.exists(user.getId()));
        assertFalse(userDao.exists(23859741897L));

    }

    @Test
    public void findByEmail() throws SQLException {
        List<User> users = (List<User>) userDao.findAll();
        User user1 = users.get(Math.abs(new Random().nextInt()) % users.size());
        final String existsEmail = user1.getEmail();
        final String notExistsEmail = "test" + new Random().nextInt() + "@example.com";
        User user2 = userDao.findByEmail(existsEmail);

        assertEquals(user1.toString(), user2.toString());
        assertNull(userDao.findByEmail(notExistsEmail));

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);

    }

}
