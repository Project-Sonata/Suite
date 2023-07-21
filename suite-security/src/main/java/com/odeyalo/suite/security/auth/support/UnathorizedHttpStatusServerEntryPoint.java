package com.odeyalo.suite.security.auth.support;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;

/**
 * Just return 401 error status
 */
public class UnathorizedHttpStatusServerEntryPoint extends HttpStatusServerEntryPoint {

    public UnathorizedHttpStatusServerEntryPoint() {
        super(HttpStatus.UNAUTHORIZED);
    }
}
