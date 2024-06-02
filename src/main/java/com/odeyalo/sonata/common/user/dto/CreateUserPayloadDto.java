package com.odeyalo.sonata.common.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Value
@AllArgsConstructor(onConstructor_ = @JsonCreator)
@Builder
public class CreateUserPayloadDto {
    @NotNull
    @JsonProperty("sonata_id")
    String id;
    @NotNull
    String username;
    @NotNull
    LocalDate birthdate;
    @NotNull
    String email;
    @NotNull
    Gender gender;
    @JsonProperty("country")
    String countryCode;

    public enum Gender {
        MALE,
        FEMALE,
        NONE
    }
}
