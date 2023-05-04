package com.example.service;

import com.example.dao.FlightDAO;
import com.example.dto.FlightDTO;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDAO flightDAO = FlightDAO.getInstance();

    private FlightService() {
    }

    public List<FlightDTO> findAll() {
        return flightDAO.findAll().stream()
                .map(flight -> new FlightDTO(
                        flight.getId(),
                        """
                                %s - %s -%s
                        """.formatted(flight.getDepartureAirportCode(),
                        flight.getArrivalAirportCode(),
                        flight.getStatus())
                ))
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}