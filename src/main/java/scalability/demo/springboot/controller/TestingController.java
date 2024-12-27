package scalability.demo.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scalability.demo.springboot.util.MetricsHelperService;


@RestController
@RequiredArgsConstructor
@Slf4j
public class TestingController {

    private final MetricsHelperService metricsHelperService;

    @GetMapping("/threeSecondsRequest")
    public ResponseEntity<String> threeSecondsRequest() {
        metricsHelperService.increaseCounter();

        log.info("called threeSecondsRequest");
        try {
            Thread.sleep(3_000);
            return ResponseEntity.ok("Request finished in 3 seconds");
        } catch (InterruptedException e) {
            log.error("INTERRUPTED_ERROR", e);
            return ResponseEntity.internalServerError().body("INTERRUPTED_ERROR");
        } finally {
            metricsHelperService.decreaseCounter();
        }

    }

    @GetMapping("/twentySecondsRequest")
    public ResponseEntity<String> twentySecondsRequest() {
        metricsHelperService.increaseCounter();

        log.info("called twentySecondsRequest");
        try {
            Thread.sleep(20_000);
            return ResponseEntity.ok("Request finished in 20 seconds");
        } catch (InterruptedException e) {
            log.error("INTERRUPTED_ERROR", e);
            return ResponseEntity.internalServerError().body("INTERRUPTED_ERROR");
        } finally {
            metricsHelperService.decreaseCounter();
        }
    }

}
