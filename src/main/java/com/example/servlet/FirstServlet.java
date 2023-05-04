package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var paramValue = req.getParameter("param");
        var parameterMap = req.getParameterMap();
        System.out.println();

//        var headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            var header = headerNames.nextElement();
//            System.out.println(req.getHeader(header));
//        }
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12345");
//         resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var writer = resp.getWriter()) {
            writer.write("<h1>Привет с первого сервлета</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var reader = req.getReader();
             var lines = reader.lines()) {
            lines.forEach(System.out::println);
        }

//        var parameterMap = req.getParameterMap();
//        System.out.println(parameterMap);
    }
}