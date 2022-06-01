package com.DataAcc;

import java.util.List;

import com.entity.VcdDetails;

public interface VcdData {
	public boolean addVcd(VcdDetails v);
	public List<VcdDetails> getAllVcd();
	public VcdDetails getVcdById(int id);
	public boolean updateEditvcd(VcdDetails v);
	public boolean deleteVcd(int id);
	public List<VcdDetails> getNewVcd();
	public List<VcdDetails> getRecentVcd();
	public List<VcdDetails> getOldVcd();
	public List<VcdDetails> getAllRecentVcd();
	public List<VcdDetails> getAllNewVcd();
	public List<VcdDetails> getAllOldtVcd();
	public List<VcdDetails> getVcdbyOld(String email,String cate);
	public boolean oldVcdDelete(String email,String cat,int id);
	public List<VcdDetails> getVcdBySearch(String ch);
	
}
