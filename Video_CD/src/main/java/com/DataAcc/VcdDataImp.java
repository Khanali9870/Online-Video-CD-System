package com.DataAcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.VcdDetails;

public class VcdDataImp implements VcdData {
	private Connection connection;
	

	public VcdDataImp(Connection connection) {
		super();
		this.connection = connection;
	}


	public boolean addVcd(VcdDetails v) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="insert into vcd_details(vcdName,actors,price,vcdCategory,status,photo,email) value(?,?,?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, v.getVcdName());
			ps.setString(2, v.getActors());
			ps.setString(3, v.getPrice());
			ps.setString(4, v.getVcdCategory());
			ps.setString(5, v.getStatus());
			ps.setString(6, v.getPhotoName());
			ps.setString(7, v.getEmail());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	public List<VcdDetails> getAllVcd() {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		return list;
	}


	public VcdDetails getVcdById(int id) {
		// TODO Auto-generated method stub
		
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where vcdId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return v;
	}


	public boolean updateEditvcd(VcdDetails v) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="update vcd_details set vcdName=?,actors=?,price=?,status=? where vcdId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, v.getVcdName());
			ps.setString(2, v.getActors());
			ps.setString(3, v.getPrice());
			ps.setString(4, v.getStatus());
			ps.setInt(5, v.getVcdId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}


	public boolean deleteVcd(int id) {
		boolean f=false;
		try {
			String sql="delete from vcd_details where vcdId=? ";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}


	public List<VcdDetails> getNewVcd() {
		// TODO Auto-generated method stub
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where vcdCategory=? and status=? order by vcdId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "new");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<VcdDetails> getRecentVcd() {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where status=? order by vcdId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}


	public List<VcdDetails> getOldVcd() {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where vcdCategory=? and status=? order by vcdId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<VcdDetails> getAllRecentVcd() {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where status=? order by vcdId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<VcdDetails> getAllNewVcd() {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where vcdCategory=? and status=? order by vcdId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "new");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<VcdDetails> getAllOldtVcd() {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		try {
			String sql="select * from vcd_details where vcdCategory=? and status=? order by vcdId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<VcdDetails> getVcdbyOld(String email, String cate) 
	{
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		
		try {
			String sql="select * from vcd_details where vcdCategory=? and email=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, cate);
			ps.setString(2, email);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				v=new VcdDetails();
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public boolean oldVcdDelete(String email, String cat,int id) {
		boolean f=false;
		try {
			String sql="delete from vcd_details where vcdCategory=? and email=? and vcdId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, cat);
			ps.setString(2, email);
			ps.setInt(3, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}


	public List<VcdDetails> getVcdBySearch(String ch) {
		List<VcdDetails> list=new ArrayList<VcdDetails>();
		VcdDetails v=null;
		
		try {
			String sql="select * from vcd_details where vcdName like ? or actors like ? or vcdCategory like ? and status=? ";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				v=new VcdDetails();
				v=new VcdDetails();
				v.setVcdId(rs.getInt(1));
				v.setVcdName(rs.getString(2));
				v.setActors(rs.getString(3));
				v.setPrice(rs.getString(4));
				v.setVcdCategory(rs.getString(5));
				v.setStatus(rs.getString(6));
				v.setPhotoName(rs.getString(7));
				v.setEmail(rs.getString(8));
				list.add(v);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
}
