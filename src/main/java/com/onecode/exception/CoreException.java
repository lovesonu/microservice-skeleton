package com.onecode.exception;

/**
 * @author :One_Code
 */
public class CoreException extends RuntimeException {

	private static final long serialVersionUID = -3754595267596974172L;

	private final String errorCode;

	public CoreException(String errorCode) {
		this.errorCode = errorCode;
	}

	public CoreException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public CoreException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public CoreException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
