package com.txn.exception;

@SuppressWarnings("serial")
public class InvalidTxnAmountException extends RuntimeException {

	public InvalidTxnAmountException(String message) {
		super(message);
	}

}
