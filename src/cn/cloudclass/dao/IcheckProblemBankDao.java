package cn.cloudclass.dao;


import java.util.ArrayList;

import cn.cloudclass.bean.ProblemBank;

public interface IcheckProblemBankDao {
	/**
	 * @param type
	 * @return  true/false
	 */
	public ArrayList findProblem(String type);
	/**
	 * @param addproblem  （包含题库里的所有属性）
	 * @return true/false
	 */
	public boolean addProblem(ProblemBank addproblem);
	/**
	 * @param type
	 * @param problemTitle
	 * @return true/false
	 */
	public boolean deleteProblemBank(String type,String problemTitle);
	/**
	 * @param answer
	 * @return 前台返回答题卡数组
	 */
	public ArrayList checkAnswer(String answer);
}
