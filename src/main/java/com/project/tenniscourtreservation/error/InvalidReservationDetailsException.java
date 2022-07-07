package com.project.tenniscourtreservation.error;

public class InvalidReservationDetailsException extends Exception{
    public InvalidReservationDetailsException() {
        super();
    }

    public InvalidReservationDetailsException(String message) {
        super(message);
    }

    public InvalidReservationDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidReservationDetailsException(Throwable cause) {
        super(cause);
    }
}
