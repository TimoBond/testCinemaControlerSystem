package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.business.service.CinemaService;
import com.example.cinemacontrolersystem.util.CinemaStatisticDataTransfer;
import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class IncomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        CinemaService cinemaService = (CinemaService) httpServletRequest.getServletContext().getAttribute("CinemaService");
        Principal principal = httpServletRequest.getUserPrincipal();
        boolean who = httpServletRequest.isUserInRole("boss");
        if (who == false) {
            return configManager.getProperties("roles");
        }
        String[] cinemas = httpServletRequest.getParameterValues("cinemas");
        String day = httpServletRequest.getParameter("days");
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < cinemas.length; i++) {
            integers.add(Integer.parseInt(cinemas[i]));
            System.out.println(integers.get(i) + " id CINEMA");
        }
        CinemaStatisticDataTransfer cinemaStatisticDataTransfer = cinemaService.income(integers, Integer.parseInt(day));
        httpServletRequest.setAttribute("statistic", cinemaStatisticDataTransfer);

        return configManager.getProperties("income");
    }
}
