package cn.cloudclass.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.cloudclass.bean.ProblemBank;
import cn.cloudclass.dao.IcheckProblemBankDao;
@Component(value="findProblemBankDao")
@Scope("prototype") //springmvc 默认为单例模式 prototype：为多例 
public class CheckProblemBankImpl implements IcheckProblemBankDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	/*
	 * @param type 题型
	 * @return ArrayList 返回 一个由十个题目组成的试卷
	 * */
	@Override
	public ArrayList findProblem(String type) {
		String sqlQuery = " from ProblemBank where type=?";
		ArrayList list = (ArrayList) hibernateTemplate.find(sqlQuery,type);
		ArrayList titleList = new ArrayList();
		if(list.isEmpty()){
			return null;
		}else{
			for(int i = 0; i<10; i++){
				int index = (int) (Math.random()*list.size());
				titleList.add(list.get(index));
				list.remove(index);
			}
		}
		return titleList;
	}

	@Override
	public boolean addProblem(ProblemBank addproblem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProblemBank(String type, String problemTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList checkAnswer(String answer) {
		// TODO Auto-generated method stub
		return null;
	}

}
