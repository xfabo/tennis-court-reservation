package com.project.tenniscourtreservation.controller;

import com.project.tenniscourtreservation.entity.Reservation;
import com.project.tenniscourtreservation.error.InvalidCustomerDetailsException;
import com.project.tenniscourtreservation.error.InvalidReservationDetailsException;
import com.project.tenniscourtreservation.service.ReservartionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is a Spring Controller for Reservation.
 *
 * @author Filip Fábry.
 */
@RestController
public class ReservationController {
    private final ReservartionService reservartionService;

    public ReservationController(ReservartionService reservartionService) {
        this.reservartionService = reservartionService;
    }

    /**
     * This is a PostMapping method to save reservation into the database by using service layer
     * or throw exception when an error occurs.
     */
    @PostMapping("/reservations")
    public double saveReservation
            (Long courtId,
             String customerName, String customerSurname, String telephoneNumber,
             String startTime, String endTime, boolean doubles)
            throws InvalidReservationDetailsException, InvalidCustomerDetailsException {
        return reservartionService.saveReservation(courtId, customerName.strip(),
                customerSurname.strip(),
                telephoneNumber.strip(),
                startTime.strip(), endTime.strip(), doubles);
    }

    /**
     * This is a GetMapping method to find all reservations with telephone number given as parameter.
     * Number is parsed as an url format for example "http://localhost:8082/reservations/number/+421902462".
     * @param telephoneNumber given telephone number to find reservations.
     * @return List of reservations created with this telephone number.
     */
    @GetMapping("/reservations/number/{number}")
    public List<Reservation> getReservationsByTelephoneNumber(@PathVariable("number") String telephoneNumber) {
        return reservartionService.getReservationsByTelephoneNumber(telephoneNumber);
    }

    /**
     * This is a GetMapping method to find all reservations with specific court id.
     * Court id is parsed as an url format for example "http://localhost:8082/reservations/1"
     * @param courtId given court id to find reservations.
     * @return List of reservations created with this court id.
     */
    @GetMapping("/reservations/{id}")
    public List<Reservation> getReservationsById(@PathVariable("id") Long courtId) {
        return reservartionService.getReservationsById(courtId);
    }

}
