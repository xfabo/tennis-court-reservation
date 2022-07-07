package com.project.tenniscourtreservation.error;

public class InvalidCustomerDetailsException extends Exception{
    public InvalidCustomerDetailsException() {
        super();
    }

    public InvalidCustomerDetailsException(String message) {
        super(message);
    }

    public InvalidCustomerDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCustomerDetailsException(Throwable cause) {
        super(cause);
    }
}
