package com.rainbow_weaver.league.exception;

public class LoginException extends Exception {
    public LoginException(Exception e) {
        super(e);
    }
    public LoginException(String msg) {
        super(msg);
    }
}
