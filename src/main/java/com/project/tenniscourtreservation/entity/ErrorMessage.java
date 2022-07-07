package com.project.tenniscourtreservation.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


/**
 * This is a spring Entity representing ErrorMessage.
 *
 * @author Filip Fábry.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}

