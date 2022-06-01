package com.DataAcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;
import com.mysql.cj.exceptions.RSAException;

public class UserDataImp implements UserData{
	private Connection connection;

	public UserDataImp(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean userRegister(User us) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="insert into user(name,email,phoneno,password ) values(?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,us.getName());
			pStatement.setString(2,us.getEmail());
			pStatement.setString(3,us.getPhoneno());
			pStatement.setString(4,us.getPassword());
			int i=pStatement.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public User login(String email, String password) {
		User user=null;
		try {
			String sql="select * from user where email=? and password=?";
			
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet resultSet=pStatement.executeQuery();
			while (resultSet.next()) {
				user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhoneno(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));
				user.setAddress(resultSet.getString(6));
				user.setLandmark(resultSet.getString(7));
				user.setCity(resultSet.getString(8));
				user.setState(resultSet.getString(9));
				user.setPincode(resultSet.getString(10));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkPassword(int id, String ps) {
		// TODO Auto-generated method stub
		boolean f=false;
		
		try {
			String sql="select * from user where id=? and password=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, ps);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateProfile(User us) {
		boolean f=false;
		try {
			String sql="update user set name=?,email=?,phoneno=? where id=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,us.getName());
			pStatement.setString(2,us.getEmail());
			pStatement.setString(3,us.getPhoneno());
			pStatement.setInt(4,us.getId());
			int i=pStatement.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkUser(String em) {
		boolean f=true;
		try {
			String sql="select * from user where email=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,em);
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				f=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
}
