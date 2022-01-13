package com.michelle.bookstore.resources.exception;

public class StandardError {
	
	private Long timesTamps;
	private Integer status;
	private String msg;
	
	public StandardError() {
		
	}

	public StandardError(Long timesTamps, Integer status, String msg) {
		super();
		this.timesTamps = timesTamps;
		this.status = status;
		this.msg = msg;
	}




	public Long getTimesTamps() {
		return timesTamps;
	}
	public void setTimesTamps(Long timesTamps) {
		this.timesTamps = timesTamps;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
