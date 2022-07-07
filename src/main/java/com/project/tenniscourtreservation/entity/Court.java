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

/**
 * This is a Spring Entity representing Court.
 *
 * @author Filip Fábry.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "court"
)

public class Court {

    @Id
    @SequenceGenerator(
            name = "court_sequence",
            sequenceName = "court_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "court_sequence"
    )
    @Column(name = "court_id")
    private Long courtId;

    @Column(name = "court_surface", nullable = false)
    private String courtSurface;

}
