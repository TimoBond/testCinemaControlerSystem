package com.example.cinemacontrolersystem.business.service;

import com.example.cinemacontrolersystem.model.Cinema;
import com.example.cinemacontrolersystem.model.Schedule;
import com.example.cinemacontrolersystem.storage.DAOFactory;
import com.example.cinemacontrolersystem.storage.dao.CinemaDAO;
import com.example.cinemacontrolersystem.storage.DAOFactory.MySqlDAOFactory;
import com.example.cinemacontrolersystem.storage.dao.impl.MySQLCinemaDAO;
import com.example.cinemacontrolersystem.util.CinemaStatisticDataTransfer;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CinemaService implements Serializable {
    private MySqlDAOFactory daoFactory;

    public CinemaService(DAOFactory daoFactory) {
        this.daoFactory = (MySqlDAOFactory) daoFactory;
    }


    public List<Schedule> schedule(String email) {
        DataSource dataSource = daoFactory.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            MySQLCinemaDAO mySQLCinemaDAO = (MySQLCinemaDAO) daoFactory.getDAO(Cinema.class);
            mySQLCinemaDAO.setConnection(connection);
            return mySQLCinemaDAO.schedule(email);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public boolean addTickets(long idSchedule) {
        DataSource dataSource = daoFactory.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            MySQLCinemaDAO mySQLCinemaDAO = (MySQLCinemaDAO) daoFactory.getDAO(Cinema.class);
            mySQLCinemaDAO.setConnection(connection);
            return mySQLCinemaDAO.addTickets(idSchedule);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }


    public void createCinema(Cinema cinema) {
        DataSource dataSource = daoFactory.getDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            MySQLCinemaDAO mySQLCinemaDAO = (MySQLCinemaDAO) daoFactory.getDAO(Cinema.class);
            mySQLCinemaDAO.setConnection(connection);
            Cinema cinema1 = mySQLCinemaDAO.create(cinema);
            if (cinema1 != null) {
                connection.commit();
            }

        } catch (SQLException sqlException) {
            try {
                connection.rollback();
            } catch (SQLException sqlException1) {

            }
        }
    }

    public CinemaStatisticDataTransfer income(List<Integer> cinemas, int day) {
        DataSource dataSource = daoFactory.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            MySQLCinemaDAO mySQLCinemaDAO = (MySQLCinemaDAO) daoFactory.getDAO(Cinema.class);
            mySQLCinemaDAO.setConnection(connection);
            CinemaStatisticDataTransfer cinemaStatisticDataTransfer = mySQLCinemaDAO.income(cinemas, day);

            return cinemaStatisticDataTransfer;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public List<Cinema> findAll() {
        DataSource dataSource = daoFactory.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            MySQLCinemaDAO mySQLCinemaDAO = (MySQLCinemaDAO) daoFactory.getDAO(Cinema.class);
            mySQLCinemaDAO.setConnection(connection);
            return mySQLCinemaDAO.findAll();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }


}
