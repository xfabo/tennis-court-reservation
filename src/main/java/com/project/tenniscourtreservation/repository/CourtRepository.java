package com.project.tenniscourtreservation.repository;

import com.project.tenniscourtreservation.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is a JPA repository used to communicate with database regarding court entity.
 *
 * @author Filip Fábry.
 */
public interface CourtRepository extends JpaRepository<Court, Long> {

    /**
     * Method to find certain Court by courtId.
     * @param courtId given court id to find court.
     * @return Court object.
     */
    Court findByCourtId(Long courtId);
}
