package cn.cloudclass.Test;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cloudclass.bean.User;

public class MyTest {
	 
      
    @Test
    public void test01()throws IOException,SQLException{
    	Logger logger = Logger.getLogger(MyTest.class);  
    	logger.info("hello");
    	logger.debug("你好！");  
    	logger.warn("1");  
    	logger.error("2");  
    }
    @Test
    public void test02(){
    	String rescource = "applicationContext.xml";
    	ApplicationContext ac = new ClassPathXmlApplicationContext(rescource);
    	User user = (User) ac.getBean("MyUser");
    	user.setName("xiaoer");
    	user.setId(12);
    	System.out.println(user);
    	
    }
}
