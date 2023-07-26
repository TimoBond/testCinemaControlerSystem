package com.example.cinemacontrolersystem.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaStatisticDataTransfer implements Serializable {

    private Map<String,Double> titleSum = new HashMap<>();

    public CinemaStatisticDataTransfer(HashMap<String,Double> titleSum ){
        this.titleSum = titleSum;
    }

    public Map<String, Double> getTitleSum() {
        return titleSum;
    }

    public void setTitleSum(Map<String, Double> titleSum) {
        this.titleSum = titleSum;
    }
}
