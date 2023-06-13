package com.odeyalo.sonata.sonata.common.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contains info about error
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorDetails {
    private String code;
    private String description;
    @JsonProperty("possible_solution")
    private String possibleSolution;

    public static ErrorDetails of(String code, String description, String possibleSolution) {
        return new ErrorDetails(code, description, possibleSolution);
    }
}