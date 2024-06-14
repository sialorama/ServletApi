package com.servletapi;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApiServlet", value = "/ApiServlet")
public class ApiServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Sample data to send back as JSON
            PrintWriter out = response.getWriter();
            String dataJson ="{\"nom\":\"Smith\",\"prenom\":\" John \"}";
        out.print(dataJson);
            }

            public void destroy(){
    }
}