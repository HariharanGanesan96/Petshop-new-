package com.exception;

public class QtyNotAvalilable extends Exception {
	
	String message;
    public QtyNotAvalilable(String errorMessage) {  
        message=errorMessage;
}
	@Override
	public String toString() {
		return "QtyNotAvalilable [message=" + message + "]";
	}

}
