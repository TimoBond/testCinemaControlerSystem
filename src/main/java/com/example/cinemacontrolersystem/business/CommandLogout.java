package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.Principal;

public class CommandLogout implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        Principal principal = httpServletRequest.getUserPrincipal();
        System.out.println(principal.getName() +" principal");

        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.invalidate();
        System.out.println("v roles command");

        return configManager.getProperties("roles");
    }
}
