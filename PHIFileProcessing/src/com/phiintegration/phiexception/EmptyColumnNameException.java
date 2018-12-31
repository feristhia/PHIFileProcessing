package com.phiintegration.phiexception;

public class EmptyColumnNameException extends Exception {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyColumnNameException(String message) {
        super(message);
    }
}