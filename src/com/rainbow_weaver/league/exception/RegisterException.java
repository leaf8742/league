package com.rainbow_weaver.league.exception;

public class RegisterException extends Exception {
	private static final long serialVersionUID = 1195784844409269335L;
	public RegisterException(Exception e) {
        super(e);
    }
    public RegisterException(String msg) {
        super(msg);
    }
}
