package com.phiintegration.phiexception;

public class DuplicateColumnNameException extends Exception {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateColumnNameException(String message) {
        super(message);
    }
}