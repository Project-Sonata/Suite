package com.odeyalo.sonata.suite.brokers.events.user.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class UserRegisteredEventData {
    private String id;
    private String email;
    private String countryCode;
    private String gender;
    private LocalDate birthdate;
    private boolean enableNotification;

    public String id() {
        return id;
    }

    public String email() {
        return email;
    }
}
