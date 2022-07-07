package com.project.tenniscourtreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * This is a spring Entity representing Reservation.
 *
 * @author Filip Fábry
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "reservation")
public class Reservation {

    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "reservation_start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "reservation_end_time", nullable = false)
    private Timestamp endTime;

    @Column(name = "customer_phone_number", nullable = false)
    private String telephoneNumber;

    @Column(name = "court_id", nullable = false)
    private Long courtId;

    @Column(name = "doubles", nullable = false)
    private boolean doubles;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_surname", nullable = false)
    private String customerSurname;
}
