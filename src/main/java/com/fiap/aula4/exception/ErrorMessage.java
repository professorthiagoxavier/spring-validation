package com.fiap.aula4.exception;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
	
	private Date currenteDate; 
	private String message;
	public ErrorMessage() {}
	
	public ErrorMessage(Date currenteDate, String message) {
		this.currenteDate = currenteDate;
		this.message = message;
	}
	
 
}
