package com.app.listerner;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.app.entity.Category;
import com.app.service.Categoryservice;

public class categoryName implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	/*	System.out.println("---------------------------");
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		Categoryservice cs=(Catenameserviceimpl)ctx.getBean("Catename");
		System.out.println(cs);
		List<Category> li=cs.catename();
		ServletContext application=arg0.getServletContext();
		application.setAttribute("catename",cs.catename());
		*/
	}
	
}
