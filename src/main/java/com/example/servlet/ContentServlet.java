package com.example.servlet;

import com.example.dto.FlightDTO;
import com.example.service.FlightService;
import com.example.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    public static final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDTO> flightDTOS = flightService.findAll();
        req.setAttribute("flights", flightDTOS);
        req.getSession().setAttribute("flightsMap", flightDTOS.stream()
                .collect(toMap(FlightDTO::getId, FlightDTO::getDescription)));
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}