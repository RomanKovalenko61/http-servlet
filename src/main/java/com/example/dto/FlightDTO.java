package com.example.dto;

import java.util.Objects;

public class FlightDTO {

    private final Long id;
    private final String description;

    public FlightDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDTO flightDTO = (FlightDTO) o;
        return Objects.equals(id, flightDTO.id) && Objects.equals(description, flightDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}