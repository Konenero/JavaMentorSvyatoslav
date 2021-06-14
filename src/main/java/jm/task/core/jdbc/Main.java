package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Dima", "Ivanov", (byte) 27);
        userService.saveUser("Ivan", "Umnov", (byte) 56);
        userService.saveUser("Koly", "Kolov", (byte) 74);
        userService.saveUser("Oly", "Nuda", (byte) 31);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
