package com.nagendra.flightreservation.service;

import com.nagendra.flightreservation.dtos.ReservationRequest;
import com.nagendra.flightreservation.entities.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequest request);
}
