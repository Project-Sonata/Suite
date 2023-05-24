package com.odeyalo.sonata.common.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Generic user info to return after the user has been successfully registered
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    protected String id;
    protected String email;

    public static UserInfo of(String id, String email) {
        return new UserInfo(id, email);
    }
}