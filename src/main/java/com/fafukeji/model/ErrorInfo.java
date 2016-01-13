package com.fafukeji.model;

/**
 * ErrorInfo model
 * @author wjx
 *
 */
public class ErrorInfo implements java.io.Serializable {
	
	
	public static final byte STATE_ERROR = 0;
	public static final byte STATE_SUCCES = 1;
	public static final byte STATE_TIMEOUT = 2;
	
	private static final long serialVersionUID = -1565382288312289710L;
	private String message;
	
	private Integer success=0;
	private byte state;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Integer getSuccess() {
		return success;
	}



	public void setSuccess(Integer success) {
		this.success = success;
	}



	public byte getState() {
		return state;
	}



	public void setState(byte state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return message;
	}

}
