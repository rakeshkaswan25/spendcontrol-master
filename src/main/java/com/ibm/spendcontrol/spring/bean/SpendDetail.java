package com.ibm.spendcontrol.spring.bean;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class SpendDetail {

	@JsonProperty("spendDate")
	private String spendDate;
	@JsonProperty("spendType")
	private String spendType;
	@JsonProperty("category")
	private String category;
	@JsonProperty("vendor")
	private String vendor;
	@JsonProperty("invoiceAmount")
	private String invoiceAmount;
	
	//@JsonIgnore
	//private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public SpendDetail() {
		
	}
	
	public SpendDetail(String spendDate, String spendType, String category, String vendor, String invoiceAmount) {
		
		this.spendDate = spendDate;
		this.spendType = spendType;
		this.category = category;
		this.vendor = vendor;
		this.invoiceAmount = invoiceAmount;
		
	}

	@JsonProperty("spendDate")
	public String getSpendDate() {
		return spendDate;
	}

	@JsonProperty("spendDate")
	public void setSpendDate(String spendDate) {
		this.spendDate = spendDate;
	}

	@JsonProperty("spendType")
	public String getSpendType() {
		return spendType;
	}

	@JsonProperty("spendType")
	public void setSpendType(String spendType) {
		this.spendType = spendType;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("vendor")
	public String getVendor() {
		return vendor;
	}

	@JsonProperty("vendor")
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@JsonProperty("invoiceAmount")
	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	@JsonProperty("invoiceAmount")
	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	/*
	 * @JsonAnyGetter public Map<String, Object> getAdditionalProperties() { return
	 * this.additionalProperties; }
	 * 
	 * @JsonAnySetter public void setAdditionalProperty(String name, Object value) {
	 * this.additionalProperties.put(name, value); }
	 */

}