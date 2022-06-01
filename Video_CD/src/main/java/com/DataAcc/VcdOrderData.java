package com.DataAcc;

import java.util.List;

import com.entity.Vcd_order;

public interface VcdOrderData {
	public boolean saveOrder(List<Vcd_order> v);
	public List<Vcd_order> getVcd(String email);
	public List<Vcd_order> getAllVcd();

}
