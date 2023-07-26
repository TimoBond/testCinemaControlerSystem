package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CommandLogin implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
       String role = httpServletRequest.getParameter("roles");
        System.out.println(role);
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        return configManager.getProperties(role + "MainPaige");
    }
}
