package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl firsUserService = new UserServiceImpl();
        //firsUserService.createUsersTable();
        //firsUserService.saveUser("Dima2", "Ivanov", (byte) 4);
        //firsUserService.saveUser("Dima2", "Ivanov", (byte) 4);
        //firsUserService.saveUser("Dima2", "Ivanov", (byte) 4);
        //firsUserService.saveUser("Dima2", "Ivanov", (byte) 4);
        System.out.println(firsUserService.getAllUsers());
        firsUserService.removeUserById(3);
        System.out.println(firsUserService.getAllUsers());

    }
}
