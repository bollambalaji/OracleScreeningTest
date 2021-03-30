package com.oracle.customer.bean;

import java.math.BigInteger;

public class CustomerDetailsBean {

	BigInteger customerId;
	
	Integer contractId;
	
	String geozone;
	
	String teamcode;
	
	String projectcode;
	
	Integer buildduration;

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public String getGeozone() {
		return geozone;
	}

	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}

	public String getTeamcode() {
		return teamcode;
	}

	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public Integer getBuildduration() {
		return buildduration;
	}

	public void setBuildduration(Integer buildduration) {
		this.buildduration = buildduration;
	}

	@Override
	public String toString() {
		return "Bean [customerId=" + customerId + ", contractId=" + contractId + ", geozone=" + geozone + ", teamcode="
				+ teamcode + ", projectcode=" + projectcode + ", buildduration=" + buildduration + "]";
	}

	
	
	
}
