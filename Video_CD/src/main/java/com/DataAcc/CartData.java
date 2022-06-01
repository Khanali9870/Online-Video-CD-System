package com.DataAcc;

import java.util.List;

import com.entity.Cart;
import com.entity.VcdDetails;

public interface CartData {
	public boolean addCart(Cart c);
	public List<Cart> getVcdByUser(int userId);
	public boolean deteteVcd(int vid, int uid,int cid);

}
