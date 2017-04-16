package com.zyl.exception;

public class ValidException extends Exception{
	private static final long serialVersionUID = -8438024406413681443L;
	private String key;
	public ValidException(String key,String msg){
		super(msg);
		this.key = key;
	}
	public String getKey() {
		return key;
	}
}
