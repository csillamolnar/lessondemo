package com.myspring.lessondemo.security;

public class SecurityConstants {
    public static final long EXPIRATIONTIME = 864_000_000; // 10 days
    public static final String TOCEN_SECRET = "ThisIsASecret";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
}
