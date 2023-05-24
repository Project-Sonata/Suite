package com.odeyalo.sonata.common.authentication.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Contains the confirmation code that used to activate the account
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ConfirmationCodeRequestDto {
    @JsonProperty("code")
    protected String codeValue;
}
