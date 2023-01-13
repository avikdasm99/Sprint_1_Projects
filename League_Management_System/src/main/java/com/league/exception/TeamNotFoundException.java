package com.league.exception;

@SuppressWarnings("serial")

public class TeamNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public TeamNotFoundException(String str){
		super(str);
	}
}
