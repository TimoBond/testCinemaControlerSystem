package com.example.cinemacontrolersystem.model;

import java.util.ArrayList;
import java.util.List;

public class Cinema extends Entity<Long> {
    private String title;
    private String address;
    private long phone;
    private List<Schedule> schedules = new ArrayList<>();

    public Cinema(long id, String title) {
        super(id);
        this.title = title;
    }

    public Cinema() {
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public String getTitle() {
        return title;
    }
}
