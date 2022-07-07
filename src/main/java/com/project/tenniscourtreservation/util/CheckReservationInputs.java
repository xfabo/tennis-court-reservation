package com.project.tenniscourtreservation.util;

import com.project.tenniscourtreservation.entity.Court;
import com.project.tenniscourtreservation.entity.Customer;
import com.project.tenniscourtreservation.error.InvalidCustomerDetailsException;
import com.project.tenniscourtreservation.error.InvalidReservationDetailsException;
import com.project.tenniscourtreservation.repository.CustomerRepository;
import com.project.tenniscourtreservation.repository.ReservationRepository;

import java.sql.Timestamp;

/**
 * Class that checks if the given inputs for reservation are valid.
 *
 * @author Filip Fábry.
 */
public class CheckReservationInputs {
    /**
     * This method check whether given customer name and customer surname
     * matches the right format, which is only containing alphabetic characters.
     * If not it throws an exception.
     * Then it checks if the customers telephone number starts with + and then contains only digits.
     * After all these checks it tries to find customer by telephone number.
     * If it succeeds, this method checks if the given name and surname matches the one in the database.
     * If it does not match, then the method throws an exception.
     * if there is no customer with this telephone number,then the method adds the customer to the database.
     *
     * @param customerName       customers name.
     * @param customerSurname    customers surname.
     * @param phoneNumber        customers telephone number.
     * @param customerRepository customer repository.
     * @throws InvalidCustomerDetailsException thrown when  some detail is invalid.
     */
    public static void checkCustomer(String customerName, String customerSurname,
                                     String phoneNumber, CustomerRepository customerRepository)
            throws InvalidCustomerDetailsException {

        if (!customerName.matches("[a-zA-Z].[a-zA-Z]*") ||
                !customerSurname.matches("[a-zA-Z].[a-zA-Z]*")) {
            throw new InvalidCustomerDetailsException("Name is in invalid format");
        }
        if (phoneNumber.charAt(0) != '+' || !phoneNumber.substring(1).matches("\\d*")) {
            throw new InvalidCustomerDetailsException("Number is in invalid format");
        }
        Customer customer = customerRepository.findByCustomerTelephoneNumber(phoneNumber);
        if (customer == null) {
            customer = Customer.builder()
                    .customerName(customerName)
                    .customerSurname(customerSurname)
                    .customerTelephoneNumber(phoneNumber)
                    .build();
            customerRepository.save(customer);
            return;
        }
        if (!customer.getCustomerName().equals(customerName)
                || !customer.getCustomerSurname().equals(customerSurname)) {
            throw new InvalidCustomerDetailsException
                    ("Name or surname connected to this number " +
                            "does not match with inputted name or surname");
        }
    }

    /**
     * This method checks if the reservation start time is not after the reservation end time or
     * if given start time and end time does not interrupt with an already existing reservation period.
     * If the given times are not valid it throws an exception.
     *
     * @param court                 court object.
     * @param startTime             start of the reservation.
     * @param endTime               end of the reservation.
     * @param reservationRepository reservation repository.
     * @throws InvalidReservationDetailsException thrown when the times are invalid.
     */
    public static void checkReservation
    (Court court, Timestamp startTime,
     Timestamp endTime,
     ReservationRepository reservationRepository) throws InvalidReservationDetailsException {
        if (endTime.before(startTime)) {
            throw new InvalidReservationDetailsException("End time is before start time.");
        }
        if (reservationRepository
                .existsByStartTimeIsBeforeAndEndTimeIsAfterAndCourtIdEquals
                        (startTime, startTime, court.getCourtId()) ||
                reservationRepository
                        .existsByStartTimeIsBeforeAndEndTimeIsAfterAndCourtIdEquals
                                (endTime, endTime, court.getCourtId())) {
            throw new InvalidReservationDetailsException
                    ("There is already a reservation at this time.");
        }
        if (reservationRepository.existsByStartTimeAndCourtId(startTime, court.getCourtId()) ||
                reservationRepository.existsByEndTimeAndCourtId(endTime, court.getCourtId())) {
            throw new InvalidReservationDetailsException
                    ("There is already a reservation at this time.");
        }
    }
}
