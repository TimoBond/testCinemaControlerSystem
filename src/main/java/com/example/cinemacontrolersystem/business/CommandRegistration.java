package com.example.cinemacontrolersystem.business;

import com.example.cinemacontrolersystem.business.Command;
import com.example.cinemacontrolersystem.business.service.UserService;
import com.example.cinemacontrolersystem.model.User;
import com.example.cinemacontrolersystem.util.EmailSend;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import javax.mail.internet.MimeMessage;
import java.io.IOException;

public class CommandRegistration implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");
        String name = httpServletRequest.getParameter("name");
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        String phone = httpServletRequest.getParameter("phone");
        User user = new User(name, password, email, phone);
        String salt = userService.createUser(user);
//        String link = "http://localhost:8080/cinemaControlerSystem_war_exploded/FrontController?command=COMMAND_VERIFICATION&amp;email="+email+"&amp;salt="+salt;
        String link = httpServletRequest.getRequestURL() + "?command=COMMAND_VERIFICATION&email=" + email + "&salt=" + salt;
        System.out.println(httpServletRequest.getContextPath() + "/FrontController?command=COMMAND_VERIFICATION&amp;email=" + email + "&amp;salt=" + salt);
        EmailSend.send(link, email);

        return null;
    }
}
