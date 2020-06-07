package com.ibm.spendcontrol.spring.service;

import java.util.List;
import java.util.Optional;

import com.ibm.spendcontrol.spring.bean.Spend;



public interface SpendService {
	public void createSpend(Spend spend);
	
	public List<Spend> getSpend();
	//public User findById(String id);
	//public Spend updateSpend(Spend spend, String l);
	//public void deleteUserById(String id);
	//public User updatePartially(User user, String id);
	
	public Optional<Spend> findSpendById(String id);
	
	//public Optional<Spend> findSpendByEmailId(String emailId);
	
	public void updateSpend(Spend currentSpend, String id);
	
	public void deleteSpendById(String id);
	
}
