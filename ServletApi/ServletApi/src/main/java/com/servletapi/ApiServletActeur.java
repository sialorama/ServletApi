package com.servletapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servletapi.controller.ActeurController;
import com.servletapi.model.Acteur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;


@WebServlet("/ApiServletActeur")
public class ApiServletActeur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ActeurController ac = new ActeurController();
        List<Acteur> acteurs = ac.getActeurs();

        Map<String, Object> map = new HashMap<>();
        map.put("acteurs", acteurs);

        // Convert Map to JSON
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert user object to JSON string
            String dataJson = objectMapper.writeValueAsString(acteurs);
            // Write JSON string to response
            response.getWriter().write(dataJson);

        } catch (IOException e) {
            // Handle JSON conversion and output errors
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Error generating JSON\"}");
        }

    }
}
