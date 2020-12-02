package ie.cct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Class responsible for sending back to the user a error message with a not acceptable response (code 406);

//ResponseStatus is sending the 406 code for not acceptable;
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor receives the message 'msg' to be send back to the user;
	public NotAcceptableException(String msg) {
		super(msg);
	}

}
