package restapi.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class BahnPriceController {

    /**
     * Schnittstelle zum Erhalten der Preise für Bahnstrecken
     *
     * @return ResponseEntity<Double>
     */
    @GetMapping("/price")
    public ResponseEntity getPrice(
            @RequestParam("distance") String distanceLong,
            @RequestParam("type") String type
    ) {
        long distance = 0;
        try {
            distance = Long.parseLong(distanceLong);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }

        if (distance < 1) {
            return ResponseEntity.status(400).build();
        }
        if (!Objects.equals(type, "ICE") && !Objects.equals(type, "RX") && !Objects.equals(type, "IC")) {
            return ResponseEntity.status(400).build();
        }

        if (Objects.equals(type, "ICE")) {
            double ICE = 0.3 * 2;
            return ResponseEntity.ok(distance * ICE);
        }
        if (Objects.equals(type, "IC")) {
            double IC = 0.3 * 1.5;
            return ResponseEntity.ok(distance * IC);
        }
        if (Objects.equals(type, "RX")) {
            double RX = 0.3 * 1;
            return ResponseEntity.ok(distance * RX);
        }

        return ResponseEntity.status(500).build();
    }
}
