package cn.cloudclass.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.cloudclass.dao.IcheckUserDao;

@Component(value = "findDao")
public class findDaoImpl implements IcheckUserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public String findUser(String name, String password) {
		String flag = "0";
		String queryString = "select u.id.type from UserView u where name=? and password=? ";
		List list = hibernateTemplate.find(queryString, name, password);
		if (list.isEmpty()) {
			flag = "defeat";
		} else {
			for (Object object : list) {
				flag = (String) object;
			}
		}
		return flag;

	}

public int addUser(Object object) {
		SessionFactory sf = null;
		Session session = null;
		Transaction beginTransaction = null;
		Serializable save = null;
		try {
			sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
			beginTransaction = session.beginTransaction();
			save = session.save(object);
			beginTransaction.commit();
		} catch (Exception e) {
			beginTransaction.rollback();
		}
		
		if (save.equals(0)) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int selectUser(String name) {
		String queryString = "from UserView  where name=? ";
		List list = hibernateTemplate.find(queryString, name);
		if (list.isEmpty()) {
			return 0;
		} else {
			return 1;
		}

	}
}
