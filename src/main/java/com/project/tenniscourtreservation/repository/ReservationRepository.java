package com.project.tenniscourtreservation.repository;

import com.project.tenniscourtreservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * This is a JPA repository used to communicate with database regarding reservation entity.
 *
 * @author Filip Fábry.
 */

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * This method is used to determine whether given time(timeStart and timeEnd are the same) is
     * between start time and end time in the database and court id's are the same.
     *
     * @param timeStart     time to be checked.
     * @param timeStartSame same as timeStart.
     * @param courtId       give court id.
     * @return true if the given time is between an already created
     * reservation start time and end time and court id equals
     * false otherwise.
     */
    boolean existsByStartTimeIsBeforeAndEndTimeIsAfterAndCourtIdEquals
    (Timestamp timeStart, Timestamp timeStartSame, Long courtId);


    /**
     * This method is used to determine whether given time start and court id are already in the database
     * created as a reservation.
     *
     * @param timeStart given time.
     * @param courtId   given court id.
     * @return true if there is already a reservation in database with this start time and court id
     * false otherwise.
     */
    boolean existsByStartTimeAndCourtId(Timestamp timeStart, Long courtId);

    /**
     * Method to determine whether given time end and court id are already in the database
     * created as a reservation.
     *
     * @param timeEnd given time.
     * @param courtId given court id.
     * @return true if there is already a reservation in database with this end time and court id
     * false otherwise.
     */
    boolean existsByEndTimeAndCourtId(Timestamp timeEnd, Long courtId);

    /**
     * Method to find all reservations by given court id.
     *
     * @param courtId given court id.
     * @return list of all reservations matching given court id.
     */
    List<Reservation> findAllByCourtId(Long courtId);

    /**
     * Method to find all reservations by given telephone number.
     *
     * @param telephoneNumber given telephone number.
     * @return list of all reservations matching given telephone number.
     */
    List<Reservation> findAllByTelephoneNumber(String telephoneNumber);
}
