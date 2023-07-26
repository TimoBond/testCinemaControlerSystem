package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.business.service.CinemaService;
import com.example.cinemacontrolersystem.model.Schedule;
import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public class Schedule_Command implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        Principal principal = httpServletRequest.getUserPrincipal();
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
       boolean who = httpServletRequest.isUserInRole("employee");
       if(who == false){
           return configManager.getProperties("roles");
       }
        System.out.println(principal.getName());

        CinemaService cinemaService = (CinemaService) httpServletRequest.getServletContext().getAttribute("CinemaService");
        List<Schedule> schedules = cinemaService.schedule(principal.getName());
        httpServletRequest.setAttribute("schedules", schedules);
        return configManager.getProperties("schedules");

    }
}
