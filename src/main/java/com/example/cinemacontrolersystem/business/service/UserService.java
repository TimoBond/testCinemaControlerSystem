package com.example.cinemacontrolersystem.business.service;

import com.example.cinemacontrolersystem.model.Cinema;
import com.example.cinemacontrolersystem.model.User;
import com.example.cinemacontrolersystem.storage.DAOFactory;
import com.example.cinemacontrolersystem.storage.dao.UserDAO;
import com.example.cinemacontrolersystem.storage.DAOFactory.MySqlDAOFactory;
import com.example.cinemacontrolersystem.storage.dao.impl.MySQLCinemaDAO;
import com.example.cinemacontrolersystem.storage.dao.impl.MySQLUserDAO;
import com.example.cinemacontrolersystem.util.CinemaSecurityException;
import com.example.cinemacontrolersystem.util.SecurityUtil;

import javax.sql.DataSource;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HexFormat;

public class UserService implements Serializable {
    private DAOFactory.MySqlDAOFactory daoFactory;

    public UserService(DAOFactory daoFactory) {
        this.daoFactory = (MySqlDAOFactory) daoFactory;
    }

    public String createUser(User user) throws CinemaSecurityException {
        DataSource dataSource = daoFactory.getDataSource();
        try ( Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            MySQLUserDAO mySQLUserDAO = (MySQLUserDAO) daoFactory.getDAO(User.class);
            mySQLUserDAO.setConnection(connection);
            byte[] salt = SecurityUtil.generateSalt();
            char[] pass = user.getPassword().toCharArray();
            String password = SecurityUtil.generatePassword(pass);
            HexFormat hexFormat = HexFormat.of();
            String saltS = hexFormat.formatHex(salt);
            user.setSalt(saltS);
           user.setPassword(password);
            User user1 = mySQLUserDAO.create(user);
            if (user1 != null) {
                connection.commit();
                return saltS;
            }
            connection.rollback();
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException sqlException) {
            sqlException.printStackTrace();
            throw new CinemaSecurityException("Проблемы с сохранением");
        }
        return null;
    }

    public boolean verification(String email, String salt){
        DataSource dataSource = daoFactory.getDataSource();
        try (Connection connection = dataSource.getConnection()){
            MySQLUserDAO mySQLUserDAO = (MySQLUserDAO) daoFactory.getDAO(User.class);
            mySQLUserDAO.setConnection(connection);
           boolean reg = mySQLUserDAO.varification(email,salt);
          return reg;
        }catch (SQLException sqlException){
sqlException.printStackTrace();
        }
        return false;
    }

}
