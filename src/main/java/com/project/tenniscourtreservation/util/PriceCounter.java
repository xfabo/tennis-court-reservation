package com.project.tenniscourtreservation.util;

import com.project.tenniscourtreservation.entity.Court;
import com.project.tenniscourtreservation.entity.Reservation;
import com.project.tenniscourtreservation.enums.CourtSurfacePrices;


/**
 * Class to calculate reservation price.
 *
 * @author Filip Fábry.
 */
public class PriceCounter {

    /**
     * Method to calculate the price of the reservation by time, surface and type of game.
     * First it calculates the difference between end time and start time and then divide it by 60000,
     * because the method returns milliseconds so to get minutes it has to be divided by 60000.
     * Then it finds the surface price in enum CourtSurfacePrices and multiply it by its price.
     * If the game is not doubles it multiply the price by 1.5.
     *
     * @param reservation reservation object.
     * @param court       court object.
     * @return price of the reservation.
     */
    public static double countPrice(Reservation reservation, Court court) {
        long difference = (reservation.getEndTime().getTime() - reservation.getStartTime().getTime()) / 60000;
        if (!reservation.isDoubles()) {
            return difference * CourtSurfacePrices.valueOf(court.getCourtSurface()).getPrice() * 1.5;
        }
        return difference * CourtSurfacePrices.valueOf(court.getCourtSurface()).getPrice();

    }
}
