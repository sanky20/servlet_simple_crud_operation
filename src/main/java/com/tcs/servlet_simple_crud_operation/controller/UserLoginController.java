package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;
import com.tcs.servlet_simple_crud_operation.entity.User;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class UserLoginController extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		UserDao dao = new UserDao();

		String email = req.getParameter("userEmail");
		String password = req.getParameter("password");

		User user = dao.getUserByUserEmailDao(email);

		if (user != null) {

			if (user.getPassword().equals(password)) {

				req.getRequestDispatcher("display.jsp").forward(req, res);
			} else {
				req.setAttribute("msg", "given password is incorrect");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		} else {
			req.setAttribute("msg", "given email is incorrect");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

}
