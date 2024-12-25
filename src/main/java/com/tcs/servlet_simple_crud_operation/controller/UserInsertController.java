package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;
import com.tcs.servlet_simple_crud_operation.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class UserInsertController implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("===service method===");
		UserDao dao = new UserDao();
		res.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		LocalDate dob = LocalDate.parse(req.getParameter("userDOB"));
		String gender = req.getParameter("gender");

		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(dob);
		System.out.println(gender);

		PrintWriter p = res.getWriter();

//		LocalDate date= LocalDate.now();
//		LocalTime time= LocalTime.now();

//		p.write("<html><body> <h5 style='color:green;'>Current Date: "+date+"</h5> </body></html>"); 
//		p.write("<html><body> <h5 style='color:green;'>Current Time: "+time+"</h5> </body></html>"); 	
//		p.write("success !!!");

		User user = dao.saveUserDao(new User(id, name, email,password, dob, gender)); // it can be null ...

		if (user != null) {
			p.write("<html><body> <h5 style='color:green;'>SUCCESS</h5> </body></html>"); // html can be sent due to
																							// res.setContentType();

		} else {
			p.write("<html><body> <h5 style='color:red;'>FAILED</h5> </body></html>"); // html can be sent due to
																							// res.setContentType();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
//		dispatcher.forward(req, res);  
		dispatcher.include(req, res);

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
