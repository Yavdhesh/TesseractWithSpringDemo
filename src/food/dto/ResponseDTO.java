package food.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ResponseDTO implements Serializable {
	private Object response;
	private List<ErrorMessageDTO> errorMessages;
	private Map<String,Object> responseMap;
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public List<ErrorMessageDTO> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(List<ErrorMessageDTO> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public Map<String, Object> getResponseMap() {
		return responseMap;
	}
	public void setResponseMap(Map<String, Object> responseMap) {
		this.responseMap = responseMap;
	}
	@Override
	public String toString() {
		return "ResponseDTO [response=" + response + ", errorMessages=" + errorMessages + ", responseMap=" + responseMap
				+ "]";
	}


}
