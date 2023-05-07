package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/flights")
//                .forward(req, resp);

//        req.getRequestDispatcher("/flights")
//                .include(req, resp);

        resp.sendRedirect("/flights");

//        for print "Hello 2" don't close printWriter in flightServlet
//        var writer = resp.getWriter();
//        writer.write("Hello 2");
//        System.out.println();

//        getServletContext().getRequestDispatcher()

//        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);
    }
}