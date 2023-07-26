package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.business.service.CinemaService;
import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.Principal;

public class GoIncomeCommand implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        CinemaService cinemaService = (CinemaService) httpServletRequest.getServletContext().getAttribute("CinemaService");
        Principal principal = httpServletRequest.getUserPrincipal();
        boolean who = httpServletRequest.isUserInRole("boss");
        if (who == false) {
            return configManager.getProperties("roles");
        }
        httpServletRequest.setAttribute("cinemas",cinemaService.findAll());

        return configManager.getProperties("statisticCinema");
    }
}
