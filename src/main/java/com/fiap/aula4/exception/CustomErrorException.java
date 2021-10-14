package com.fiap.aula4.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomErrorException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus status = null;

    private Object data = null;

    public CustomErrorException() {
      super();
    }

   public CustomErrorException(
      String message
   ) { 
      super(message);
   }

    public CustomErrorException(
        HttpStatus status,
        String message
    ) {
        this(message);
        this.status = status;
    }

    public CustomErrorException(
        HttpStatus status,
        String message,
        Object data
    ) {
        this(
          status,
      message
        );
        this.data = data;
    }
}