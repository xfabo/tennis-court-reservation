package com.project.tenniscourtreservation;

import com.project.tenniscourtreservation.entity.Court;
import com.project.tenniscourtreservation.repository.CourtRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TennisCourtReservationApplicationTests {
    @Autowired
    private CourtRepository courtRepository;

    @Test
    void contextLoads() {
        Court grassCourt = Court
                .builder()
                .courtSurface("GRASS")
                .build();
        Court clayCourt = Court
                .builder()
                .courtSurface("CLAY")
                .build();
        Court artificialGrassCourt = Court
                .builder()
                .courtSurface("ARTIFICIAL_GRASS")
                .build();
        Court hardCourt = Court
                .builder()
                .courtSurface("HARD")
                .build();
        Court grassCourt2 = Court
                .builder()
                .courtSurface("GRASS")
                .build();
        courtRepository.save(grassCourt);
        courtRepository.save(clayCourt);
        courtRepository.save(artificialGrassCourt);
        courtRepository.save(hardCourt);
        courtRepository.save(grassCourt2);
    }

}
