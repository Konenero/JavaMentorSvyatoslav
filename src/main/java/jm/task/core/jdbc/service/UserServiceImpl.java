package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private String myTableName = "CREATE TABLE users (" +
            "id INT NOT NULL AUTO_INCREMENT," +
            " name VARCHAR(20)," +
            "lastName VARCHAR(20)," +
            " age INT," +
            " PRIMARY KEY(id));";

    public void createUsersTable() {
        try {
            Util.setConnection().createStatement().executeUpdate(myTableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Util.setConnection().createStatement().executeUpdate(String.format("INSERT INTO users (" +
                            "name, lastName, age) " +
                            "VALUES ('%s', '%s1', '%s2');",
                    name, lastName, age));
            System.out.println(String.format("User с именем %s добавлен в базу данных", name));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            Util.setConnection()
                    .prepareStatement(String.format("delete from users where id = %s", id))
                    .execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();
        try {
            ResultSet res = Util.setConnection()
                    .createStatement()
                    .executeQuery("SELECT * FROM users");
            while (res.next()) {
                User user = new User(res.getString("name"),
                        res.getString("lastName"),
                        res.getByte("age"));
                listUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUsers;
    }

    public void cleanUsersTable() {

    }
}
