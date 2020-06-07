package com.ibm.spendcontrol.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.spendcontrol.spring.bean.Spend;


public interface SpendRepository extends CrudRepository<Spend, String>{

}
