package com.DataAcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.VcdDetails;

public class CartDataImp implements CartData{
	
	private Connection connection;
	public CartDataImp(Connection connection)
	{
		this.connection=connection;
	}
	public boolean addCart(Cart c) {
		boolean f=false;
		try {
			String sql="insert into cart(vid,uid,vcdName,actors,price,total_price) values(?,?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, c.getVid());
			ps.setInt(2, c.getUserid());
			ps.setString(3, c.getVcdName());
			ps.setString(4, c.getActors());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalPrice());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	public List<Cart> getVcdByUser(int userId) {
		List<Cart> list=new ArrayList<Cart>();
		Cart c=null;
		Double totalPrice = 0.0;
		try {
			String sql="select * from cart where uid=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Cart();
				c.setCid(rs.getInt(1));
				c.setVid(rs.getInt(2));
				c.setUserid(rs.getInt(3));
				c.setVcdName(rs.getString(4));
				c.setActors(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				totalPrice=totalPrice+rs.getDouble(7);
				c.setTotalPrice(totalPrice);
				list.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public boolean deteteVcd(int vid, int uid,int cid) {
		
		boolean f=false;
		
		try {
			String sql="delete from cart where vid=? and uid=? and cid=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, vid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	

}
