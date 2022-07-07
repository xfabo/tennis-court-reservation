package com.project.tenniscourtreservation.error;


import com.project.tenniscourtreservation.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This is error handler used to convert original spring errors into more readable errors for user.
 *
 * @author Filip Fábry.
 */

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(InvalidCustomerDetailsException.class)
    public ResponseEntity<ErrorMessage> invalidCustomerDetails(InvalidCustomerDetailsException exception,
                                                               WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(InvalidReservationDetailsException.class)
    public ResponseEntity<ErrorMessage> invalidReservationDetails(InvalidReservationDetailsException exception,
                                                                  WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }


}
