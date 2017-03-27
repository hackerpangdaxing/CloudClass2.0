package cn.cloudclass.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name="t_user")
@Component("MyUser")
public class User {

	@Id
	@GeneratedValue(generator="xxx")  //使用自己定义的主键生成器
	@GenericGenerator(name="xxx",strategy="native") //生成一个主键生成器
	private Integer id;
	@Value("胖大星")
	private String name;
	@Value("student")
	private String type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
}
