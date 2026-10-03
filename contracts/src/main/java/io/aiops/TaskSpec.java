package io.aiops;

import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Map;

public record TaskSpec(
        @NotBlank
        @Pattern(regexp = "[a-zA-Z0-9_-]{1,64}")
        String id,

        @NotBlank
        String kind,

        @NotNull
        Map<String, Object> input,

        @NotNull
        List<String> dependsOn,

        @Min(1)
        @Max(600)
        int timeoutSeconds,

        @Min(1)
        @Max(5)
        int maxAttempts
) {
}
