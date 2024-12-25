package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(value="/delete")
public class UserDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		int a= new UserDao().deleteUserByIdDao(id);
		
		if(a!=0)
		{
			req.getRequestDispatcher("display.jsp").forward(req,resp);
		}
		
	}

}
