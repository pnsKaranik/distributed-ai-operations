package io.aiops;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "internal")
@Validated
public record InternalProperties(
        @NotBlank
        @Size(min = 32, max = 256)
        String apiKey
) {
}