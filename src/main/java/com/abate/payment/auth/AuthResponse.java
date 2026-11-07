
package com.abate.payment.auth;

public record AuthResponse(
        String accessToken,
        String tokenType
) {}
