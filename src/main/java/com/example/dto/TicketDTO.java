package com.example.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketDTO {

    Long id;
    Long flightId;
    String seatNo;
}