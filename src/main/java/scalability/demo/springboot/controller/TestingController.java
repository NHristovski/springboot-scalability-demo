package scalability.demo.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@Slf4j
public class TestingController {

    Logger logger = Logger.getLogger(TestingController.class.getName());

    @GetMapping("/threeSecondsRequest")
    public ResponseEntity<String> threeSecondsRequest() {
        logger.log(Level.INFO, "called threeSecondsRequest");
        try {
            Thread.sleep(3_000);
            return ResponseEntity.ok("Request finished in 3 seconds");
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "INTERRUPTED_ERROR", e);
            return ResponseEntity.internalServerError().body("INTERRUPTED_ERROR");
        }
    }

    @GetMapping("/twentySecondsRequest")
    public ResponseEntity<String> twentySecondsRequest() {
        logger.log(Level.INFO, "called twentySecondsRequest");
        try {
            Thread.sleep(20_000);
            return ResponseEntity.ok("Request finished in 20 seconds");
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "INTERRUPTED_ERROR", e);
            return ResponseEntity.internalServerError().body("INTERRUPTED_ERROR");
        }
    }

}
