package com.example.cinemacontrolersystem.model;

import java.util.Date;

public class Schedule extends Entity<Long>{
    private Date date;
    private double price;
    private  int place_amount;
    private Film film;
    private  int bay_place;
    private String time;


    public Schedule(){}

    public Schedule(long id, Date date, double price,int place_amount, int bay_place, Film film, String time){
        super(id);
        this.date = date;
        this.film = film;
        this.price = price;
        this.place_amount = place_amount;
        this.bay_place = bay_place;
        this.time = time;
    }


    public Date getDate() {
        return date;
    }

    public int getBay_place() {
        return bay_place;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getPlace_amount() {
        return place_amount;
    }

    public Film getFilm() {
        return film;
    }

    public String getTime() {
        return time;
    }
}
