package com.ibm.spendcontrol.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.spendcontrol.spring.bean.Spend;
import com.ibm.spendcontrol.spring.repository.SpendRepository;

@Service
@Transactional
public class SpendServiceImp implements SpendService {
	@Autowired
	SpendRepository spendRepository;
	
	public void createSpend(Spend spend) {
		// TODO Auto-generated method stub
		spendRepository.save(spend);
	}
	
	public List<Spend> getSpend() {
		// TODO Auto-generated method stub
		return (List<Spend>)spendRepository.findAll();
	}
	
	@Override
	public Optional<Spend> findSpendById(String Id) {
		// TODO Auto-generated method stub
		return spendRepository.findById(Id);
	}
	
	/*
	 * @Override public Optional<Spend> findSpendByEmailId(String emailId) { // TODO
	 * Auto-generated method stub return null; }
	 */
	
	@Override
	public void updateSpend(Spend currentSpend, String id) {
		// TODO Auto-generated method stub
		Optional<Spend> spend = spendRepository.findById(id);
		Spend s = new Spend();
		if(spend.isPresent()) {
			s = spend.get();
			s.setId(currentSpend.getId());
			s.setEmail(currentSpend.getEmail());
			s.setSpendDate(currentSpend.getSpendDate());
			s.setSpendType(currentSpend.getSpendType());
			s.setCategory(currentSpend.getCategory());
			s.setVendor(currentSpend.getVendor());
			s.setInvoiceAmount(currentSpend.getInvoiceAmount());
		}
		spendRepository.save(s);
	}
	
	@Override
	public void deleteSpendById(String id) {
		// TODO Auto-generated method stub
		spendRepository.deleteById(id);
	}
	



}
