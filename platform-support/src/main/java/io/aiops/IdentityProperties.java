package io.aiops;

import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "security")
@Validated
public record IdentityProperties(
        @NotBlank String issuer,
        @NotBlank String jwkUri
) {
}