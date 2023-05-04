package com.example.dto;

import java.util.Objects;

public class TicketDTO {

    private final Long id;
    private final Long flightId;
    private final String seatNo;

    public TicketDTO(Long id, Long flightId, String seatNo) {
        this.id = id;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}