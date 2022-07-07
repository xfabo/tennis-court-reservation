package com.project.tenniscourtreservation.service;

import com.project.tenniscourtreservation.entity.Court;
import com.project.tenniscourtreservation.entity.Reservation;
import com.project.tenniscourtreservation.error.InvalidCustomerDetailsException;
import com.project.tenniscourtreservation.error.InvalidReservationDetailsException;
import com.project.tenniscourtreservation.repository.CourtRepository;
import com.project.tenniscourtreservation.repository.CustomerRepository;
import com.project.tenniscourtreservation.repository.ReservationRepository;
import com.project.tenniscourtreservation.util.CheckReservationInputs;
import com.project.tenniscourtreservation.util.PriceCounter;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Service class implementation that works with reservations.
 *
 * @author Filip Fábry.
 */


@Service
public class ReservationServiceImpl implements ReservartionService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    private final CourtRepository courtRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  CustomerRepository customerRepository,
                                  CourtRepository courtRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.courtRepository = courtRepository;
    }

    /**
     * This method check all the inputs given from user and determines whether they are correct or incorrect.
     * If they are correct this method save the reservation and returns price of the reservation.
     * Otherwise, it fails with exception.
     */
    @Override
    public double saveReservation
    (Long courtId,
     String customerName, String customerSurname, String telephoneNumber,
     String startTime, String endTime, boolean doubles)
            throws InvalidReservationDetailsException, InvalidCustomerDetailsException {

        Timestamp stampStart = Timestamp.valueOf(startTime);
        Timestamp stampEnd = Timestamp.valueOf(endTime);

        Court court = courtRepository.findByCourtId(courtId);
        if (court == null) {
            throw new InvalidReservationDetailsException("Court id does not exist");
        }

        CheckReservationInputs.checkReservation(court, stampStart,
                stampEnd, reservationRepository);
        CheckReservationInputs.checkCustomer(customerName, customerSurname,
                telephoneNumber, customerRepository);
        Reservation reservation = Reservation
                .builder()
                .customerName(customerName)
                .customerSurname(customerSurname)
                .startTime(stampStart)
                .endTime(stampEnd)
                .courtId(courtId)
                .doubles(doubles)
                .telephoneNumber(telephoneNumber)
                .build();
        reservationRepository.save(reservation);
        return PriceCounter.countPrice(reservation, court);

    }

    @Override
    public List<Reservation> getReservationsById(Long courtId) {
        return reservationRepository.findAllByCourtId(courtId);
    }

    @Override
    public List<Reservation> getReservationsByTelephoneNumber(String phoneNumber) {
        return reservationRepository.findAllByTelephoneNumber(phoneNumber);
    }

}
