package cn.cloudclass.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cloudclass.service.CheckProblemBankService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class CheckProblemBank {
	@Autowired
	private CheckProblemBankService pb_service;
	Logger logger = Logger.getLogger(CheckProblemBank.class);
	

	@SuppressWarnings("unused")
	@RequestMapping("findProblemBank.do")
	public void findProblemBank(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String type = request.getParameter("type");
		PrintWriter write = response.getWriter();
		JSONArray json = new JSONArray();
		@SuppressWarnings("rawtypes")
		ArrayList problemList = new ArrayList();
		problemList = pb_service.findProblem(type);
		for(int i = 0 ; i<problemList.size(); i++){
		logger.info("第"+i+"题： "+problemList.get(i));
		}
		if(problemList!=null){
			json.addAll(problemList);
			write.println(json.toString());
		}else{
			logger.info("题库数据传输失败了！");
			write.print("error");
		}
	}
	@RequestMapping("checkAnswer.do")
	public void checkAnswer(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ServletContext session = request.getServletContext();
		//Map userList = (Map) session.getAttribute("userMap");
		String answer = request.getParameter("answer");
		String userName = request.getParameter("username");
		String userType = request.getParameter("type");
		logger.info(userName+"============"+userType);
		JSONArray json=JSONArray.fromObject(answer);
		 for(int i=0;i<json.size();i++){
			// logger.info(json.get(i));
			 String str = (String) json.get(i);
			String[] answerList = str.split(":");
			System.out.println(answerList[0]+"-------------------------");
			System.out.println(answerList[1]+"-----------------------------");
		  }
	}
	
	@RequestMapping("addProblemBank.do")
	public void addProblemBank(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
	
	
	@RequestMapping("deleteProblemBank.do")
	public void deleteProblemBank(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
	
}
