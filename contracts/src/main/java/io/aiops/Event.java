package io.aiops;

import java.time.Instant;
import java.util.*;

public record Event(
        UUID id,
        String type,
        String aggregateId,
        String tenantId,
        String traceId,
        String spanId,
        Instant occurredAt,
        Map<String, Object> data
) {

    public static Event of(
            String type,
            String aggregate,
            String tenant,
            Map<String, Object> data
    ) {

        return new Event(
                UUID.randomUUID(),
                type,
                aggregate,
                tenant,
                UUID.randomUUID().toString().replace("-", ""),
                UUID.randomUUID().toString().replace("-", "").substring(0, 16),
                Instant.now(),
                data
        );
    }
}