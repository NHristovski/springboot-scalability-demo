package scalability.demo.springboot.util;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class MetricsHelperService {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final MeterRegistry meterRegistry;

    @PostConstruct
    public void init() {
        Gauge.builder("custom.http.active.requests", () -> counter)
                .description("Active http requests")
                .register(meterRegistry);
    }

    public void increaseCounter() {
        this.counter.incrementAndGet();
    }

    public void decreaseCounter() {
        this.counter.decrementAndGet();
    }

}
