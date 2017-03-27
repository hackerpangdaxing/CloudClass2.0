package cn.cloudclass.daoImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.cloudclass.dao.IUserService;
@Scope("prototype")
@Component("userService")
public class UserService implements IUserService{

	@Override
	public void doSome() {
		System.out.println("welcome");
	}

}
