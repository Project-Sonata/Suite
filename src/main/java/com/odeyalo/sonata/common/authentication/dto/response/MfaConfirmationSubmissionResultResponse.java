package com.odeyalo.sonata.sonata.common.authentication.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.sonata.common.authentication.dto.UserInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Result response of the mfa confirmation submission
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@SuperBuilder
public class MfaConfirmationSubmissionResultResponse {
    protected boolean result;
    @JsonProperty("user_info")
    protected UserInfo info;

    public static MfaConfirmationSubmissionResultResponse success(UserInfo info) {
        return new MfaConfirmationSubmissionResultResponse(true, info);
    }

    public static MfaConfirmationSubmissionResultResponse failed() {
        return new MfaConfirmationSubmissionResultResponse(false, (UserInfo) null);
    }
}
