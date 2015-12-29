package com.edu.message;
/**
 * 准备发货结果消息
 * @author Gy
 *
 */
public class prepareDeliverableResultMessage {
	private String status;

	public prepareDeliverableResultMessage(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public prepareDeliverableResultMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
