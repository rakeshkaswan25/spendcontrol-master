package com.ibm.spendcontrol.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.ibm.spendcontrol.spring.bean.Spend;
import com.ibm.spendcontrol.spring.service.SpendService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = { "/", "/spend" })
@Api(value = "onlinestore", description = "Operations pertaining to Spend Control")
public class SpendController {
	@Autowired
	SpendService spendService;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String get() {
		return "Please give url as Spring-Boot-Rest/spend/get";

	}

	@PostMapping(value = "/create/spend", headers = "Accept=application/json")
	public ResponseEntity<Void> createSpend(@RequestBody Spend spend, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Spend " + spend);
		String id = "S" + "-" + System.currentTimeMillis();
		spend.setId(id);
		spendService.createSpend(spend);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/spend/{id}").buildAndExpand(spend.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get/spend", headers = "Accept=application/json")
	public List<Spend> getAllSpends() {
		List<Spend> spends = spendService.getSpend();
		return spends;

	}
	
	@GetMapping(value="/get/spend/{id}", headers="accept=application/json")
	 public Optional<Spend> findSpendById(@PathVariable("id") String id){
		 Optional<Spend> spend= spendService.findSpendById(id);
		 return spend;
	 }
	
	/*
	 * @GetMapping(value="/get/spend/{emailId}", headers="accept=application/json")
	 * public Optional<Spend> findSpendByEmailId(@PathVariable("emailId") String
	 * emailId){ Optional<Spend> spend= spendService.findSpendByEmailId(emailId);
	 * return spend; }
	 */
	
	@PutMapping(value="/update/spend/{id}", headers="Accept=application/json") 
	  public ResponseEntity<Spend> updateSpend(@RequestBody Spend currentSpend,@PathVariable("id") String id) {
	  
		  System.out.println("Current Spend is : "+currentSpend.getId());
		  spendService.updateSpend(currentSpend, id);
		  return new ResponseEntity<Spend>(HttpStatus.OK); 
	  }
	  
	  @DeleteMapping(value="/delete/spend/{id}", headers ="Accept=application/json") 
	  public ResponseEntity<Spend> deleteUser(@PathVariable("id") String id){
		  
		  Optional<Spend> spend = spendService.findSpendById(id);
		  if (spend == null) { 
			  return new ResponseEntity<Spend>(HttpStatus.NOT_FOUND); 
		  } 
		  spendService.deleteSpendById(id);
		  return new ResponseEntity<Spend>(HttpStatus.NO_CONTENT); 
	  }

}
