package com.example.servlet;

import com.example.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private static final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightId = Long.valueOf(req.getParameter("flightId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Купленные билеты</h1>");
            printWriter.write("<ul>");
            ticketService.findAllByFlightId(flightId).forEach(ticketDTO -> printWriter.write("""
                    <li>
                            %s
                    </li>
                    """.formatted(ticketDTO.getSeatNo())));
            printWriter.write("</ul>");
        }
    }
}