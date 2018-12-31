package com.phiintegration.phiexception;

public class DuplicateColumnCustomIndexException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public DuplicateColumnCustomIndexException(String message) {
        super(message);
    }
}