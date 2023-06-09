package com.example.service;

import com.example.dao.TicketDao;
import com.example.dto.TicketDTO;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private static final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDTO> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> TicketDTO.builder()
                        .id(ticket.getId())
                        .flightId(ticket.getFlightId())
                        .seatNo(ticket.getSeatNo())
                        .build()
                ).collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}