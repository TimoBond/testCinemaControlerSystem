package com.example.cinemacontrolersystem.storage;

import com.example.cinemacontrolersystem.model.Cinema;
import com.example.cinemacontrolersystem.model.Entity;
import com.example.cinemacontrolersystem.model.User;
import com.example.cinemacontrolersystem.storage.dao.DAO;
import com.example.cinemacontrolersystem.storage.dao.impl.MySQLCinemaDAO;
import com.example.cinemacontrolersystem.storage.dao.impl.MySQLFilmDAO;
import com.example.cinemacontrolersystem.storage.dao.impl.MySQLUserDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DAOFactory {
    private static DAOFactory daoFactory = new MySqlDAOFactory();


    public abstract <E extends Entity<K>, K> DAO<E, K> getDAO(Class<E> clazz);

    public static DAOFactory getDaoFactory() {
        return daoFactory;
    }

    public
    static class MySqlDAOFactory extends DAOFactory {
        private DataSource dataSource;

        public MySqlDAOFactory() {
            try {
                Context context = (Context) new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) context.lookup("jdbc/cinema_control_system");
            }catch (NamingException namingException){
                namingException.printStackTrace();
            }

        }

        public <E extends Entity<K>, K> DAO<E, K> getDAO(Class<E> clazz) {
            try {
                E e = clazz.newInstance();
                if (e instanceof User) {
                    return (DAO<E, K>) new MySQLUserDAO();
                } if (e instanceof Cinema) {
                    return (DAO<E, K>) new MySQLCinemaDAO();
                } else {
                    return (DAO<E, K>) new MySQLFilmDAO();
                }
            } catch (InstantiationException | IllegalAccessException exception) {
                exception.printStackTrace();
            }
            return null;
        }

        public DataSource getDataSource() {
            return dataSource;
        }
    }

}
