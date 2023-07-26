package com.example.cinemacontrolersystem.business;

import jakarta.servlet.http.HttpServletRequest;

public class CommandFactory {
    public static Command getCommand(HttpServletRequest httpServletRequest){
        System.out.println("v command");
        String commandString =  httpServletRequest.getParameter("command");
        System.out.println(commandString + " myCommand");
        return CommandEnum.valueOf(commandString.toUpperCase()).getCommand();
    }
}
