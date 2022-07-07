package com.project.tenniscourtreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is a Spring Entity representing Customer.
 *
 * @author Filip Fábry.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (
        name = "customer"
)
public class Customer {
    @Id
    @Column(name = "customer_telephone_number")
    private String customerTelephoneNumber;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_surname", nullable = false)
    private String customerSurname;
}
