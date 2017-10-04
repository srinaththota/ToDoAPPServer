package com.onlineshopping.sample.OnlineShopping;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
@JacksonStdImpl
public class Task {

	private int taskId;
	private String msg;
	private boolean status;
	public Task(){
		
	}
	public Task(int i, String msg, boolean status) {
		this.taskId=i;
		this.msg=msg;
		this.status=status;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
