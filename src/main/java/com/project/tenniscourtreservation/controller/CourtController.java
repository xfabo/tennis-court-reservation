package com.project.tenniscourtreservation.controller;


import com.project.tenniscourtreservation.entity.Court;
import com.project.tenniscourtreservation.repository.CourtRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * This is a Spring Controller for Court.
 *
 * @author Filip Fábry.
 */

@RestController
public class CourtController {

    private final CourtRepository courtRepository;

    public CourtController(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    /**
     * This is a PostMapping method to save court in the database.
     * @param court - court object created from API parameters.
     * @return Court object.
     */
    @PostMapping("/courts")
    public Court saveCourt(@Valid @RequestBody Court court) {
        return courtRepository.save(court);
    }

    /**
     * This is a GetMapping method to get all courts in the database.
     * @return List of courts.
     */
    @GetMapping("/courts")
    public List<Court> getCourts() {
        return courtRepository.findAll();
    }
}
