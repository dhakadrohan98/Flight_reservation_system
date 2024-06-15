package com.nagendra.flightreservation.repos;

import com.nagendra.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // Define any additional methods you need here
}