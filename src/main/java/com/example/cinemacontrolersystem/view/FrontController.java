package com.example.cinemacontrolersystem.view;

import com.example.cinemacontrolersystem.business.Command;
import com.example.cinemacontrolersystem.business.CommandFactory;
import com.example.cinemacontrolersystem.business.service.CinemaService;
import com.example.cinemacontrolersystem.business.service.UserService;
import com.example.cinemacontrolersystem.storage.DAOFactory;
import com.example.cinemacontrolersystem.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebServlet(name = "FrontController", value = "/FrontController")

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }


    @Override
    public void init() {
        DAOFactory daoFactory = DAOFactory.getDaoFactory();
        getServletContext().setAttribute("Factory", daoFactory);
        ConfigManager configManager = ConfigManager.getConfigManager();
        getServletContext().setAttribute("ConfigManager", configManager);
        UserService userService = new UserService(daoFactory);
        getServletContext().setAttribute("UserService", userService);
        CinemaService cinemaService = new CinemaService(daoFactory);
        getServletContext().setAttribute("CinemaService",cinemaService);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

//    principal

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandFactory.getCommand(request);
        String page = command.execute(request);
        System.out.println(page + " front ");
        if (page != null) {
//            response.sendRedirect(page);
//            System.out.println(new StringBuilder(request.getRequestURL()).delete()replace("FrontController",page));
//            response.sendRedirect("http://localhost:8080/cinemaControlerSystem_war_exploded/"+page);
            request.getRequestDispatcher(page).forward(request, response);
//            String rawData = "id=10";
//            String type = "application/x-www-form-urlencoded";
//            String encodedData = URLEncoder.encode( rawData, "UTF-8" );
//            System.out.println("http://localhost:8080/cinemaControlerSystem_war_exploded/"+page +" URL");
//            URL url = new URL("http://localhost:8080/cinemaControlerSystem_war_exploded/"+page);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setDoOutput(true);
//            urlConnection.setRequestMethod("GET");
//            OutputStream os = urlConnection.getOutputStream();
//            os.write(encodedData.getBytes());
//            os.flush();
//            urlConnection.disconnect();
//            try {
//
//                var uri = URI.create("http://localhost:8080/cinemaControlerSystem_war_exploded/" + page);
//                var client = HttpClient.newHttpClient();
//                var request1 = HttpRequest
//                        .newBuilder()
//                        .uri(uri)
////                        .header("accept", "application/")
//                        .GET()
//                        .build();
//                var response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
////                System.out.println(response1.statusCode());
////                System.out.println(response1.body());
//            }catch (InterruptedException interruptedException){
//                interruptedException.printStackTrace();
//            }
        }
    }
}
