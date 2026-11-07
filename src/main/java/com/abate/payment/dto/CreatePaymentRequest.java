
package com.abate.payment.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreatePaymentRequest(

        @NotBlank(message = "Source account is required")
        String sourceAccount,

        @NotBlank(message = "Destination account is required")
        String destinationAccount,

        @NotNull(message = "Amount is required")
        @Positive(message = "Amount must be greater than zero")
        BigDecimal amount,

        @NotBlank(message = "Currency is required")
        @Pattern(
                regexp = "^[A-Z]{3}$",
                message = "Currency must be a 3-letter uppercase code"
        )
        String currency,

        @Size(max = 255, message = "Description cannot exceed 255 characters")
        String description

) {}
