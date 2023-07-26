package com.example.cinemacontrolersystem.storage.dao.impl;

import com.example.cinemacontrolersystem.model.Cinema;
import com.example.cinemacontrolersystem.model.Film;
import com.example.cinemacontrolersystem.model.Schedule;
import com.example.cinemacontrolersystem.storage.dao.CinemaDAO;
import com.example.cinemacontrolersystem.util.CinemaStatisticDataTransfer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySQLCinemaDAO implements CinemaDAO {
    private Connection connection;

    public MySQLCinemaDAO() {
    }

    @Override
    public Cinema find(Long aLong) {
        return null;
    }

    @Override
    public Cinema delete(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema create(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema update(Cinema cinema) {
        return null;
    }

    public List<Cinema> findAll(){
        List<Cinema> cinemas = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cinemas;");

            while (resultSet.next()){
                cinemas.add(new Cinema(resultSet.getLong(1),resultSet.getString(2)));
                System.out.println("cineID "+ resultSet.getLong(1) + resultSet.getString(2));
            }
            return cinemas;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return cinemas;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Schedule> schedule(String email) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select schedule.*, filmes.title  from user_cinema left join cinemas on user_cinema.idCinema = cinemas.id" +
                    " left join schedule on cinemas.id = schedule.id_cinema left join filmes on schedule.id_film = filmes.id where user_cinema.mail = '" + email + "' and  datediff(curdate(), schedule.date) <8 ;");
            List<Schedule> scheduleList = new ArrayList<>();
            while (resultSet.next()) {
                scheduleList.add(new Schedule(resultSet.getLong(3), resultSet.getDate(4),
                        resultSet.getDouble(5), resultSet.getInt(6), resultSet.getInt(8), new Film(resultSet.getLong(1), resultSet.getString(9)), resultSet.getTime(7).toString()));

            }
            return scheduleList;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public boolean addTickets(long idShedule) {
        try (Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement("update schedule set schedule.bay_place = schedule.bay_place + 1 where schedule.id =" + idShedule + "; ")) {
            ResultSet resultSet = statement.executeQuery("select schedule.bay_place, schedule.place_amount from schedule where schedule.id =" + idShedule + ";");
            System.out.println("ticket go");
            if (resultSet.next()) {
                if (resultSet.getInt(1) < resultSet.getInt(2)) {
                    System.out.println("ticket add");
                    int a = preparedStatement.executeUpdate();
                    if (a != 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

//    public CinemaStatisticDataTransfer income(List<Integer> cinemas, int day) {
//        try (Statement statement = connection.createStatement()) {
//
//            ResultSet resultSet = statement.executeQuery("select filmec.title, sum(price * bay_place) as sumeDay\n" +
//                    " from user_cinema left join cinemas on user_cinema.idCinema = cinemas.id " +
//                    "left join schedule on cinemas.id = schedule.id_cinema left join filmes on schedule.id_film = filmes.id where user_cinema.id_cinema = " + cinema + " and datediff(curdate(), schedule.date) <" + day + "  group by filmec.title;");
//
//
//            HashMap<String,Double> titlesSum = new HashMap<>();
//            while (resultSet.next()) {
//                titlesSum.put(resultSet.getString(1),resultSet.getDouble(2));
//            }
//            CinemaStatisticDataTransfer cinemaStatisticDataTransfer = new CinemaStatisticDataTransfer(titlesSum);
//
//            return cinemaStatisticDataTransfer;
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return null;
//    }

    public CinemaStatisticDataTransfer income(List<Integer> cinemas, int day) {
        try (Statement statement = connection.createStatement()) {
            HashMap<String, Double> titlesSum = new HashMap<>();

            for (Integer cinema : cinemas) {
                ResultSet resultSet = statement.executeQuery("select cinemas.title, sum(price * bay_place) as sumeDay" +
                        " from cinemas left join cinema_control_system.schedule on cinemas.id = schedule.id_cinema where cinemas.id = " + cinema + " and datediff(curdate(), schedule.date) <" + day + " group by cinemas.title;");
                while (resultSet.next()) {
                    titlesSum.put(resultSet.getString(1), resultSet.getDouble(2));

                }
            }

            CinemaStatisticDataTransfer cinemaStatisticDataTransfer = new CinemaStatisticDataTransfer(titlesSum);
            return cinemaStatisticDataTransfer;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
