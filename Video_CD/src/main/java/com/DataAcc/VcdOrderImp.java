package com.DataAcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Vcd_order;

public class VcdOrderImp implements VcdOrderData{
	private Connection connection;

	public VcdOrderImp(Connection connection) {
		super();
		this.connection = connection;
	}


	public boolean saveOrder(List<Vcd_order> vlist) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="insert into vcd_order(order_id,user_name,email,address,phone,vcd_name,actors,price,payment) values(?,?,?,?,?,?,?,?,?)";
			connection.setAutoCommit(false);
			PreparedStatement ps=connection.prepareStatement(sql);
			for(Vcd_order v: vlist)
			{
				ps.setString(1, v.getOrderId());
				ps.setString(2, v.getUserName());
				ps.setString(3, v.getEmail());
				ps.setString(4, v.getFullAdd());
				ps.setString(5, v.getPhoneno());
				ps.setString(6, v.getVcdName());
				ps.setString(7, v.getActors());
				ps.setString(8, v.getPrice());
				ps.setString(9, v.getPaymentType());
				
				ps.addBatch();
			}
			
			int[] count=ps.executeBatch();
			connection.commit();
			f=true;
			connection.setAutoCommit(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}


	public List<Vcd_order> getVcd(String email) {
		// TODO Auto-generated method stub
		List<Vcd_order> list= new ArrayList<Vcd_order>();
		Vcd_order order=null;
		try {
			String sql="select * from vcd_order where email=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order=new Vcd_order();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setUserName(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setFullAdd(rs.getString(5));
				order.setPhoneno(rs.getString(6));
				order.setVcdName(rs.getString(7));
				order.setActors(rs.getString(8));
				order.setPrice(rs.getString(9));
				order.setPaymentType(rs.getString(10));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<Vcd_order> getAllVcd() {
		List<Vcd_order> list= new ArrayList<Vcd_order>();
		Vcd_order order=null;
		try {
			String sql="select * from vcd_order";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order=new Vcd_order();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setUserName(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setFullAdd(rs.getString(5));
				order.setPhoneno(rs.getString(6));
				order.setVcdName(rs.getString(7));
				order.setActors(rs.getString(8));
				order.setPrice(rs.getString(9));
				order.setPaymentType(rs.getString(10));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	

}
