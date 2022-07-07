package com.project.tenniscourtreservation.service;

import com.project.tenniscourtreservation.entity.Reservation;
import com.project.tenniscourtreservation.error.InvalidCustomerDetailsException;
import com.project.tenniscourtreservation.error.InvalidReservationDetailsException;

import java.util.List;

/**
 * This is a Spring Service to work with reservations.
 *
 * @author Filip Fábry.
 */

public interface ReservartionService {

    /**
     * Method to save reservation into the database by using service layer
     * or throw exception when an error occurs.
     *
     * @param courtId         court id in long format.
     * @param customerName    customer name in string format using only alphabetic characters.
     * @param customerSurname customer surname in string format using only alphabetic characters.
     * @param telephoneNumber telephone number starting with + and then containing only digits.
     * @param startTime       start of the reservation in string format as "yyyy-mm-dd hh:mm:ss".
     * @param endTime         end of the reservation in string format as "yyyy-mm-dd hh:mm:ss".
     * @param doubles         boolean value, true if the game type is doubles false otherwise.
     * @return price of the reservation.
     * @throws InvalidReservationDetailsException thrown when reservation details inputted are invalid.
     * @throws InvalidCustomerDetailsException    thrown when customer details inputted are invalid.
     */
    double saveReservation(Long courtId,
                           String customerName, String customerSurname, String telephoneNumber,
                           String startTime, String endTime, boolean doubles)
            throws InvalidReservationDetailsException, InvalidCustomerDetailsException;

    /**
     * Method to find all reservations by given court id.
     *
     * @param courtId given court id.
     * @return list of reservations by given court id.
     */
    List<Reservation> getReservationsById(Long courtId);

    /**
     * Method to find all reservation by given telephone number.
     *
     * @param telephoneNumber given telephone number.
     * @return list of all reservations by given telephone number.
     */
    List<Reservation> getReservationsByTelephoneNumber(String telephoneNumber);
}
