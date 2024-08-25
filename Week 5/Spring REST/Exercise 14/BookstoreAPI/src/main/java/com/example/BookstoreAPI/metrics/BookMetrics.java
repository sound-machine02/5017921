package com.example.BookstoreAPI.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMetrics {
    private final Counter bookCreatedCounter;

    @Autowired
    public BookMetrics(MeterRegistry meterRegistry) {
        this.bookCreatedCounter = meterRegistry.counter("books.created");
    }

    public void incrementBookCreated() {
        bookCreatedCounter.increment();
    }
}