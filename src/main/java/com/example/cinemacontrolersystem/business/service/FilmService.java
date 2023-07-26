package com.example.cinemacontrolersystem.business.service;

import com.example.cinemacontrolersystem.model.Film;
import com.example.cinemacontrolersystem.storage.dao.FilmDAO;

import java.io.Serializable;

public class FilmService implements Serializable {
    FilmDAO filmDAO;

    public FilmService (FilmDAO filmDAO){this.filmDAO = filmDAO;}
}
