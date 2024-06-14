package com.servletapi;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/ApiServletUser")
public class ApiServletUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");

        User user = new User(firstname, lastname, email);
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert user object to JSON string
            String dataJson = mapper.writeValueAsString(user);
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
