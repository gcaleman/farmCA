package ie.cct.farmCA;

// Class responsible for sending a JASON type response for the server, instead of a string;

public class SuccessResponse {

	private String response;

	public SuccessResponse() {
		super();
	}

	public SuccessResponse(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
