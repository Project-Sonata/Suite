package com.odeyalo.sonata.sonata.common.authentication.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * Data class contains the info that was provided by user in registration form.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRegistrationInfo {
    protected String email;
    protected String password;
    protected String gender;
    protected LocalDate birthdate;
    @JsonProperty("notification_enabled")
    protected boolean notificationEnabled;
}


