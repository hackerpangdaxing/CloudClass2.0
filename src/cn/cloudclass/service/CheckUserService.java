package cn.cloudclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cloudclass.bean.Student;
import cn.cloudclass.bean.Teacher;
import cn.cloudclass.dao.IcheckUserDao;

@Component("findService")
public class CheckUserService {
	@Autowired
	private IcheckUserDao dao;

	public String findUser(String name, String password) {
		return dao.findUser(name, password);
	}
	public int addUser(String name, String password, String flag) {
		int in = dao.selectUser (name);
		if (in == 0) {

			if ("teacher".equals(flag)) {
				Teacher teacher = new Teacher();
				teacher.setName(name);
				teacher.setPassword(password);
				teacher.setType(flag);
				return dao.addUser( teacher);
			} else if("student".equals(flag)){
				Student student = new Student();
				student.setName(name);
				student.setPassword(password);
				student.setType(flag);
				return dao.addUser(student);
			}else {
				return 2;
			}
		} else {
			return 2;
		}

	}

}
