package cn.cloudclass.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cloudclass.service.CheckUserService;

@Controller
public class CheckUser {
	@Autowired
	private CheckUserService service;

	@RequestMapping("findUser.do")
	public void findUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String flag = "0";
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		PrintWriter writer = response.getWriter();
		Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) session.getServletContext()
				.getAttribute("userMap");
		if (sessionMap == null) {
			sessionMap = new HashMap<String, HttpSession>();
			session.getServletContext().setAttribute("userMap", sessionMap);
		} else {
			for (Entry<String, HttpSession> entry : sessionMap.entrySet()) {
				if (username.equals(entry.getKey())) {
					flag = "exist";
					break;
				}
			}
		}
		if ("exist".equals(flag)) {
				writer.print(flag);
		} else {

			flag = service.findUser(username, password);
			if ("teacher".equals(flag) || "student".equals(flag) ) {
				sessionMap.put(username, session);
			}
			writer.print(flag);
		}
	}
	@RequestMapping("addUser.do")
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String flag = request.getParameter("flag");
		PrintWriter writer = response.getWriter();
		int in = service.addUser(username, password, flag);
		writer.print(in);
	}
}
