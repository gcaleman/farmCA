package ie.cct.farmCA2.response;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptable extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAcceptable(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
