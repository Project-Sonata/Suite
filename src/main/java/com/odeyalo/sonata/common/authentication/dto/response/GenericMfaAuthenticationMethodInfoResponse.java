package com.odeyalo.sonata.sonata.common.authentication.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.sonata.common.authentication.dto.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
public class GenericMfaAuthenticationMethodInfoResponse extends RepresentationModel<GenericMfaAuthenticationMethodInfoResponse> {
    @JsonProperty("require_websocket")
    protected final boolean requireWs;
    protected final String type;
    @JsonProperty("user_info")
    protected final UserInfo userInfo;
    protected final String content;

    public static GenericMfaAuthenticationMethodInfoResponse of(UserInfo userInfo, String type, String content, boolean requireWs) {
        return new GenericMfaAuthenticationMethodInfoResponse(requireWs, type, userInfo, content);
    }
}
