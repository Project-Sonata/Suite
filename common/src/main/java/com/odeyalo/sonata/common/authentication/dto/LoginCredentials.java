package com.odeyalo.sonata.common.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent the user credentials
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginCredentials {
    @JsonProperty(required = true)
    protected String email;
    @JsonProperty(required = true)
    protected String password;

    public static LoginCredentials of(String email, String password) {
        return new LoginCredentials(email, password);
    }
}
