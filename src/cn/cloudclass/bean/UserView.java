package cn.cloudclass.bean;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="userview")
public class UserView implements Serializable{
	
	public UserView() {
	}
	
	public UserView(String name,String password,String type) {
		this.id = new UserViewId(name,password,type);
	}
	
	@EmbeddedId
	private UserViewId id;

	public UserViewId getId() {
		return id;
	}

	public void setId(UserViewId id) {
		this.id = id;
	}
	
}
