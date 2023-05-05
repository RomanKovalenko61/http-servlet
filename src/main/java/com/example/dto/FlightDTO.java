package com.example.dto;

import lombok.*;

@Value
@Builder
public class FlightDTO {

    Long id;
    String description;
}