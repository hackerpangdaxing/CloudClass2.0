package cn.cloudclass.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class UserViewId implements Serializable{
	private String name;
	private String password;
	private String type;
	
	public UserViewId() {
	}
	public UserViewId(String name, String password, String type) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
