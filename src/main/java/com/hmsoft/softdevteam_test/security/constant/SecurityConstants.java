package com.hmsoft.softdevteam_test.security.constant;

/**
 * @author hasson_medrano
 */
public class SecurityConstants {

    // Spring Security
    public static final String LOGIN_URL = "/login";
    public static final String CREATE_USER = "/userController/create";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer";
    public static final Integer STRING = 12;

    // JWT
    public static final String ISSUER_INFO = "";
    public static final String API_SECRET_KEY = "Test12345.";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
}
