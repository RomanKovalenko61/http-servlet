package com.example.servlet;

import com.example.dto.FlightDTO;
import com.example.service.FlightService;
import com.example.util.JspHelper;
import com.example.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@WebServlet(UrlPath.CONTENT)
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