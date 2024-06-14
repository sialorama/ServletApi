package com.servletapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servletapi.model.Acteur;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/ApiServletActeur")
public class ApiServletActeur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String photo = request.getParameter("photo");

        Acteur acteur = new Acteur(nom, prenom, photo);
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert user object to JSON string
            String dataJson = mapper.writeValueAsString(acteur);
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
