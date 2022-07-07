package com.project.tenniscourtreservation.repository;

import com.project.tenniscourtreservation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This is a JPA repository used to communicate with database regarding customer   entity.
 *
 * @author Filip Fábry.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Method to find customer by telephone number.
     * @param telephoneNumber given telephone number.
     * @return Customer object with given telephone number.
     */
    Customer findByCustomerTelephoneNumber(String telephoneNumber);

}
