package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.business.service.UserService;
import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CommandVerification implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        System.out.println("zashlo v ver");
        String email = httpServletRequest.getParameter("email");
        String salt = httpServletRequest.getParameter("salt");
        System.out.println(email + "is email");
        System.out.println(salt + "is salt");
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
      boolean verification = userService.verification(email,salt);
        System.out.println(verification +" вышло тру или нет?");
      if(verification == true){
         return configManager.getProperties("roles");
      }
        return null;
    }
}
