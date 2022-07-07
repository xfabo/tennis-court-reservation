package com.project.tenniscourtreservation.enums;

/**
 * Enum representing court surfaces and its prices.
 *
 * @author Filip Fábry.
 */

public enum CourtSurfacePrices {
    CLAY(0.3),
    GRASS(0.4),
    HARD(0.2),
    ARTIFICIAL_GRASS(0.5);
    private final double pricePerMinute;

    CourtSurfacePrices(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public double getPrice() {
        return pricePerMinute;
    }


}
