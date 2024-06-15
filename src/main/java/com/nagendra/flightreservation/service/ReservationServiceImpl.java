package com.nagendra.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagendra.flightreservation.dtos.ReservationRequest;
import com.nagendra.flightreservation.entities.Flight;
import com.nagendra.flightreservation.entities.Passenger;
import com.nagendra.flightreservation.entities.Reservation;
import com.nagendra.flightreservation.repos.FlightRepository;
import com.nagendra.flightreservation.repos.PassengerRepository;
import com.nagendra.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
   
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;;

    @Override
    public Reservation bookFlight(ReservationRequest request) {
        Flight flight = flightRepository.findById(request.getFlightId()).get();

        Passenger passanger = new Passenger();
        passanger.setFirstName(request.getFirstName());
        passanger.setLastName(request.getLastName());
        passanger.setEmail(request.getEmail());
        passanger.setPhone(request.getPhone());
        Passenger savedPassenger = passengerRepository.save(passanger);

        Reservation reservation = new Reservation(); 
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);

        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation;
    }
}
