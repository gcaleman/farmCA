package ie.cct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Class responsible for sending back to the user a error message with a not found response (code 404);

//ResponseStatus is sending the 404 code for not found;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// Constructor receives the message 'msg' to be send back to the user;
	public NotFoundException(String msg) {
		super(msg);
		
	}
	
	
	
}
