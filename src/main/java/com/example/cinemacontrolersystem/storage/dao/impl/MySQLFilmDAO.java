package com.example.cinemacontrolersystem.storage.dao.impl;

import com.example.cinemacontrolersystem.model.Cinema;
import com.example.cinemacontrolersystem.storage.dao.FilmDAO;

import javax.sql.DataSource;
import java.sql.Connection;

public class MySQLFilmDAO implements FilmDAO {

    private Connection connection;

    public MySQLFilmDAO() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cinema create(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema update(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema find(Long aLong) {
        return null;
    }

    @Override
    public Cinema delete(Cinema cinema) {
        return null;
    }
}
