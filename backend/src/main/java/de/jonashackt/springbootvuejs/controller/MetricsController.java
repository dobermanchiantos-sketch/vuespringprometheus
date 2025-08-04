package de.jonashackt.springbootvuejs.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    private final Counter customCounter;

    public MetricsController(MeterRegistry meterRegistry) {
        this.customCounter = meterRegistry.counter("custom_metric_counter_total", "description", "A custom counter for demonstration");
    }

    @GetMapping("/metrics")
    public String incrementCustomCounter() {
        customCounter.increment();
        return "Custom metric counter incremented!";
    }
}