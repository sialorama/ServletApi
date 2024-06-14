package com.servletapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

@WebServlet("/ApiServletTwo")
public class ApiServletTwo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Create a Map and populate it with various data
        Map<String, Object> map = new HashMap<>();
        String[] value1 = new String[] { "value11", "value12", "value13" };
        String[] value2 = new String[] { "value21", "value22", "value23" };
        map.put("key1", value1);
        map.put("key2", value2);
        map.put("key3", "string");
        map.put("key4", "string2");

        // Convert Map to JSON
        ObjectMapper objectMapper = new ObjectMapper();

        String dataJson = objectMapper.writeValueAsString(map);
        // Output JSON string
        out.println(dataJson);
        out.print(dataJson);
    }

    @Override
    public void destroy() {
        // Clean up resources if necessary
    }
}
