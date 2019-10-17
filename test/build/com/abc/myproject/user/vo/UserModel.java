after=======package com.abc.myproject.user.vo;

public class UserModel {
	private String uuid;	
	private String name;
	private int age;
	
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setName(String obj){
		this.name = obj;
	}
	public String getName(){
		return this.name;
	}
	
	public void setAge(int obj){
		this.age = obj;
	}
	public int getAge(){
		return this.age;
	}
	
	
}
