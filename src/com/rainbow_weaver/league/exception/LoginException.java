package com.rainbow_weaver.league.exception;

public class LoginException extends Exception {
	private static final long serialVersionUID = -4420318780707697047L;
	public LoginException(Exception e) {
        super(e);
    }
    public LoginException(String msg) {
        super(msg);
    }
}
