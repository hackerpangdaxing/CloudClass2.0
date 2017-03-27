package cn.cloudclass.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author 胖大星
 * @param ProblemBank 总题库
 * @param type （题库类型：H5 、C#、JAVA、C、dataStructure、algorithm、math、SoftwareEngineering、ComputerBasics、softTest）
 */
@Entity
@Table(name="problemBank")
public class ProblemBank {
	@Id
	@GeneratedValue(generator="xxx")  //使用自己定义的主键生成器
	@GenericGenerator(name="xxx",strategy="native") //生成一个主键生成器
	private int pb_id;
	private String type;
	private int answerType;    //单选：1、多选：2
	private String problemTitle;
	private String A;
	private String B;
	private String C;
	private String D;
	private String answer;
	private int score;
	private String analysis;
	
	public ProblemBank() {
		
	}

	public int getPb_id() {
		return pb_id;
	}
	public void setPb_id(int pb_id) {
		this.pb_id = pb_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAnswerType() {
		return answerType;
	}
	public void setAnswerType(int answerType) {
		this.answerType = answerType;
	}
	public String getProblemTitle() {
		return problemTitle;
	}
	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	@Override
	public String toString() {
		return "ProblemBank [type=" + type + ", answerType=" + answerType + ", problemTitle=" + problemTitle + ", A="
				+ A + ", B=" + B + ", C=" + C + ", D=" + D + ", answer=" + answer + ", score=" + score + ", analysis="
				+ analysis + "]";
	}


}
