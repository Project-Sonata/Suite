package com.odeyalo.sonata.common.authentication.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.common.authentication.dto.AuthenticationProcessType;
import com.odeyalo.sonata.common.authentication.dto.UserInfo;
import com.odeyalo.sonata.common.shared.ErrorDetails;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuperBuilder
public class AuthenticationResultResponse {
    protected boolean success;
    @JsonProperty("user_info")
    protected UserInfo userInfo;
    protected AuthenticationProcessType type;
    @JsonProperty("available_methods")
    protected Set<MfaTypeMethodInfo> supportedMfaTypes;
    // Used if the application cannot perform authentication
    @JsonProperty("error_details")
    protected ErrorDetails errorDetails;

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    public static class MfaTypeMethodInfo {
        private String name;
        // URL to start MFA process by specific MFA method.
        private String url;

        public static MfaTypeMethodInfo of(String name, String url) {
            return new MfaTypeMethodInfo(name, url);
        }
    }
}
