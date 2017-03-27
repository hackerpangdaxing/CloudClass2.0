package cn.cloudclass.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cloudclass.bean.ProblemBank;
import cn.cloudclass.dao.IcheckProblemBankDao;

/**
 * @author 胖大星
 *查询题库的service
 */
@Service("findProblemBankService")
public class CheckProblemBankService {
	@Autowired
	private IcheckProblemBankDao pb_dao;
	/**
	 * @param type 题型
	 * @return true/false
	 */
	public ArrayList findProblem(String type){

		return pb_dao.findProblem(type);
		
	}
	public ArrayList checkAnswer(String answer){
		
		return null;
		
	}
	/**
	 * @param addproblem  ProblemBank实体所有属性
	 * @return true/false
	 */
	public boolean addProblem(ProblemBank addproblem){
		
		return pb_dao.addProblem(addproblem);
		
	}
	/**
	 * @param type 题型
	 * @param problemTitle 要删除的题目 通过 like '%problemTitle%'查询
	 * @return true/false
	 */
	public boolean deleteProblem(String type,String problemTitle){
		return pb_dao.deleteProblemBank(type, problemTitle);
		
	}
}
