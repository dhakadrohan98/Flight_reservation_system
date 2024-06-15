package com.nagendra.flightreservation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagendra.flightreservation.dtos.ReservationRequest;
import com.nagendra.flightreservation.entities.Flight;
import com.nagendra.flightreservation.entities.Reservation;
import com.nagendra.flightreservation.repos.FlightRepository;
import com.nagendra.flightreservation.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationService reservationService;

    public ReservationController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, Model model) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        model.addAttribute("flight", flight);
        return "completeReservation"; // Assuming "completeReservation" is the name of your Thymeleaf template
    }

    @PostMapping("/completeReservation") {
        public String completeReservation(ReservationRequest request, Model model) {
            Reservation reservation = reservationService.bookFlight(request);
            model.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
            return "reservationConfirmation"; // Assuming "reservationConfirmation" is the name of your Thymeleaf template
    }
    
}