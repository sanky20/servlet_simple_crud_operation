package com.tcs.servlet_simple_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tcs.servlet_simple_crud_operation.connection.UserConnection;
import com.tcs.servlet_simple_crud_operation.entity.User;

public class UserDao {

	Connection connection = UserConnection.getUserConnection();

	private final String INSERTUSERQUERY = "insert into user(id,name,email,password,dob,gender) values(?,?,?,?,?,?)";
	private final String USEREMAILQUERY = "SELECT * FROM USER WHERE email=?";
	private final String DISPLAYALLUSERQUERY = "SELECT * FROM USER";
	private final String DELETEUSERBYIDQUERY = "Delete from user where id=?";
	private final String DISPLAYUSERBYIDQUERY= "Select * from user where id=?";
	private final String UPDATEUSERQUERY= "UPDATE USER SET name=?,email=?,password=?,dob=?,gender=? WHERE id=?";

	public User saveUserDao(User user) {

		try {
			PreparedStatement ps = connection.prepareStatement(INSERTUSERQUERY);

			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setObject(5, user.getDob());
			ps.setString(6, user.getGender());

			int a = ps.executeUpdate();

			return a != 0 ? user : null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByUserEmailDao(String userEmail) {
		try {
			PreparedStatement ps = connection.prepareStatement(USEREMAILQUERY);
			ps.setString(1, userEmail);

			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				return new User(email, password);
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUserDao() {

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYALLUSERQUERY);

			List<User> l = new ArrayList<>();
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				LocalDate dob = resultSet.getDate("dob").toLocalDate();
				String gender = resultSet.getString("gender");

				l.add(new User(id, name, email, dob, gender));
			}

			return l;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public int deleteUserByIdDao(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(DELETEUSERBYIDQUERY);
			ps.setInt(1, id);
			int a = ps.executeUpdate();

			return a;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	public User getUserByIdDao(int userId) {

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYUSERBYIDQUERY);
            ps.setInt(1, userId);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				LocalDate dob = resultSet.getDate("dob").toLocalDate();
				String gender = resultSet.getString("gender");

				return new User(id, name, email,password, dob, gender);
			}

			else { 
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
		
	public User updateUserDao(User user) {

		try {
			PreparedStatement ps = connection.prepareStatement(UPDATEUSERQUERY);

			ps.setInt(6, user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setObject(4, user.getDob());
			ps.setString(5, user.getGender());
			int a = ps.executeUpdate();
			
			String msg= a!=0?"Data updated":"Error...";

			return a != 0 ? user : null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
