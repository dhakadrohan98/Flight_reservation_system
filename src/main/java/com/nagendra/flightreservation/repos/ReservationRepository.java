package com.nagendra.flightreservation.repos;

import com.nagendra.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Define any additional methods you need here
}