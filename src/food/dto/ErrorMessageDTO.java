package food.dto;

import java.io.Serializable;

public class ErrorMessageDTO implements Serializable {
	@Override
	public String toString() {
		return "ErrorMessageDTO [id=" + id + ", Message=" + Message + "]";
	}
	private String id;
	private String Message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	private ErrorMessageDTO (){
		
	}
	
	private ErrorMessageDTO(String id,String errorMessage){
		this.id=id;
		this.Message=errorMessage;
	}
	public ErrorMessageDTO getErrorMessageDTO(String id, String errorMessage){
		//This is called factory pattern
	if (null == id){
		return new ErrorMessageDTO("globalErrorMessage", errorMessage);
	}else{
		return new ErrorMessageDTO(id, errorMessage);
	}	
	}

}
