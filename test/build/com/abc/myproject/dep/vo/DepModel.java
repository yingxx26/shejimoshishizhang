after=======package com.abc.myproject.dep.vo;

public class DepModel {
	private String uuid;	
	private String depName;
	private String managerUserId;
	
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setDepName(String obj){
		this.depName = obj;
	}
	public String getDepName(){
		return this.depName;
	}
	
	public void setManagerUserId(String obj){
		this.managerUserId = obj;
	}
	public String getManagerUserId(){
		return this.managerUserId;
	}
	
	
}
