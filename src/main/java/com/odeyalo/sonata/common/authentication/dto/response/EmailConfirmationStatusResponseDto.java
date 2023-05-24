package com.odeyalo.sonata.common.authentication.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.common.authentication.dto.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * Dto to return an answer about email confirmation status
 */
@Data
@AllArgsConstructor
@SuperBuilder
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailConfirmationStatusResponseDto {
    @JsonProperty("is_confirmed")
    protected final boolean isConfirmed;
    @JsonProperty("user_info")
    protected final UserInfo userInfo;
    @JsonProperty("message")
    protected final String message;

    public EmailConfirmationStatusResponseDto() {
        this.isConfirmed = false;
        this.userInfo = null;
        this.message = null;
    }

    public static final String SUCCESS_MESSAGE = "The email has been successfully confirmed";

    public static EmailConfirmationStatusResponseDto confirmationSuccess(UserInfo userInfo) {
        return new EmailConfirmationStatusResponseDto(true, userInfo, SUCCESS_MESSAGE);
    }

    public static EmailConfirmationStatusResponseDto confirmationFailed(String message) {
        return new EmailConfirmationStatusResponseDto(false, null, message);
    }
}
