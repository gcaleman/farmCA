package ie.cct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Class responsible for sending back to the user a error message with a bad request response (code 400);

// ResponseStatus is sending the 400 code for bad request;
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor receives the message 'msg' to be send back to the user;
	public BadRequestException(String msg) {
		super(msg);
	}

}
