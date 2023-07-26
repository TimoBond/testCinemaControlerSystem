package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.business.service.CinemaService;
import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.Principal;

public class TicketsCommand implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        Principal principal = httpServletRequest.getUserPrincipal();
        System.out.println(principal.getName());
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        CinemaService cinemaService = (CinemaService) httpServletRequest.getServletContext().getAttribute("CinemaService");
        boolean who = httpServletRequest.isUserInRole("employee");
        System.out.println("employee is " + who);
       if (who == false){
           return configManager.getProperties("roles");
       }
      String id = httpServletRequest.getParameter("idSchedule");
        System.out.println(id + " idSch!");
       cinemaService.addTickets(Long.parseLong(id));
        return configManager.getProperties("employeeMainPaige");
    }
}
