package com.example.cinemacontrolersystem.model;

public class Film extends Entity<Long> {
    private byte[] poster;
    private String title;
    private String genre;
    private String description;

    public Film(long id, byte[] poster, String title, String genre, String description){
        super(id);
        this.poster = poster;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }

    public Film( byte[] poster, String title, String genre, String description){

        this.poster = poster;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }
    public Film(long id, String title){
        super(id);
        this.title =title;
    }

    public String getTitle() {
        return title;
    }

    public Film(){}

}
