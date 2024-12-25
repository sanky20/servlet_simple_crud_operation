package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;
import com.tcs.servlet_simple_crud_operation.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/userUpdate")
public class UpdateUserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao dao = new UserDao();

		resp.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		LocalDate dob = LocalDate.parse(req.getParameter("userDOB"));
		String gender = req.getParameter("gender");

		User user = dao.updateUserDao(new User(id, name, email, password, dob, gender));

	
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		dispatcher.include(req, resp);

	}

}
