package com.example.cinemacontrolersystem.storage.dao.impl;

import com.example.cinemacontrolersystem.model.User;
import com.example.cinemacontrolersystem.storage.dao.UserDAO;

import javax.sql.DataSource;
import java.sql.*;

public class MySQLUserDAO implements UserDAO {

    private Connection connection;

    private static final String CREATE = "insert into users (mail, password, name, phone, salt) values (?, ?, ?, ?, ?);";
    private static final String CREATE_ROLES = "insert into user_roles (mail, role_name) values (?,'registered');";

    public MySQLUserDAO() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User create(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
             PreparedStatement preparedStatement2 = connection.prepareStatement(CREATE_ROLES)) {
            preparedStatement.setString(1, user.getMail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getSalt());
            preparedStatement2.setString(1, user.getMail());
            int a = preparedStatement.executeUpdate();
            if (a == 0) {
                return null;
            }
            a = preparedStatement2.executeUpdate();
            if (a == 0) {
                return null;
            }
            return user;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }

    public boolean varification(String email, String salt) {
        try (Statement statement = connection.createStatement();
             Statement statement1 = connection.createStatement()) {
            System.out.println(email);
            System.out.println(salt);
            ResultSet resultSet = statement.executeQuery("select users.mail, salt from users left join user_roles on users.mail = user_roles.mail " +
                    "where role_name = 'registered' and users.mail ='" + email + "'and salt = '" + salt + "';");
            if (!resultSet.next()) {
                System.out.println("не получилось вериф");
                return false;
            }
            System.out.println("Получилось");
            int a = statement1.executeUpdate("insert  into  user_roles (mail, role_name) values ('" + email + "','verified');");
            if (a != 0) {
                System.out.println("ура, тру");
                return true;
            }
            System.out.println("no true");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }




    @Override
    public User find(Long aLong) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
