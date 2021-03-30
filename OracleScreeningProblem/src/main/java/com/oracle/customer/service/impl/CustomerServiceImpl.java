package com.oracle.customer.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.oracle.customer.bean.CustomerDetailsBean;

import java.util.Iterator;

public class CustomerServiceImpl {
	
	private static CustomerServiceImpl taskHandler=null;
	
	private CustomerServiceImpl()
	{
		
	}

	public static CustomerServiceImpl getInstance()
	{
		if(taskHandler == null)
			taskHandler=new CustomerServiceImpl();
		return taskHandler;
	}

	/*Method take List of Rows i,e CustomerDetailsBean's Here we are iterating list . Every CuntractId we are adding as Map key 
	And Customer ID's for That particular ContractId we are adding it in a HasSet so that it will remove Duplicates*/
	public void findUniqueCustomerForContractId(List<CustomerDetailsBean> listOfRows) {
		// TODO Auto-generated method stub
		HashMap<Integer,Set<BigInteger>> teamContract=new HashMap<Integer,Set<BigInteger>>();
		
		for(CustomerDetailsBean team:listOfRows)
		{
			if(teamContract.containsKey(team.getContractId()))
				{
				Set<BigInteger> teamCustomer=teamContract.get(team.getContractId());
				teamCustomer.add(team.getCustomerId());
				teamContract.put(team.getContractId(), teamCustomer);
				}
			else
			{
				HashSet<BigInteger> customer=new HashSet<BigInteger>();
				customer.add(team.getCustomerId());
				teamContract.put(team.getContractId(), customer);
			}
				
				
		}
		
		System.out.println("Unique Customer for Contrac Id"+teamContract);
		
	}

	
	/*Method take List of Rows i,e CustomerDetailsBean's Here we are iterating list . Every GeoZone we are adding as Map key 
	And Customer ID's for That particular GeoZone we are adding it in a HasSet so that it will remove Duplicates*/
	public void findUniqueCustomerForGeoZone(List<CustomerDetailsBean> listOfRows) {

		HashMap<String,Set<BigInteger>> teamGeoGZone=new HashMap<String,Set<BigInteger>>();
		
		for(CustomerDetailsBean team:listOfRows)
		{
			if(teamGeoGZone.containsKey(team.getGeozone()))
				{
				Set<BigInteger> teamCustomer=teamGeoGZone.get(team.getGeozone());
				teamCustomer.add(team.getCustomerId());
				teamGeoGZone.put(team.getGeozone(), teamCustomer);
				}
			else
			{
				HashSet<BigInteger> customer=new HashSet<BigInteger>();
				customer.add(team.getCustomerId());
				teamGeoGZone.put(team.getGeozone(), customer);
			}
				
				
		}
		
		System.out.println("Unique Customer for GeoZone"+teamGeoGZone);
		
	}

	/*Method take List of Rows i,e CustomerDetailsBean's Here we are iterating list . Every GeoZone we are adding as Map key 
	 And BuildDurations for That particular GeoZone we are adding it in a HasSet so that it will remove Duplicates
	 After getting BuildDurations in Set For particular GeoZon we are getting average of buildDuration
	Using other method getAverageOfBuildDuration*/
	public void averageBuildDurationForGeoZone(List<CustomerDetailsBean> listOfRows) {
      Map<String,HashSet<Integer>> teamGeoGZone=new HashMap<String,HashSet<Integer>>();
		
       //Getting Build Durations for each GeoZone
		for(CustomerDetailsBean team:listOfRows)
		{
			if(teamGeoGZone.containsKey(team.getGeozone()))
				{
				HashSet<Integer> buildDuration=teamGeoGZone.get(team.getGeozone());
				buildDuration.add(team.getBuildduration());
				teamGeoGZone.put(team.getGeozone(), buildDuration);
				}
			else
			{
				HashSet<Integer> buildDuration=new HashSet<Integer>();
				buildDuration.add(team.getBuildduration());
				teamGeoGZone.put(team.getGeozone(), buildDuration);
			}
				
				
		}
		
		
		System.out.println("BuildDUrations for each GeoZone:"+teamGeoGZone);
		
		//Get Average for Each GeoZone
		Iterator<Map.Entry<String,HashSet<Integer>>> itr=teamGeoGZone.entrySet().iterator();
		 while(itr.hasNext())
	        {
	             Map.Entry<String,HashSet<Integer>> entry = itr.next();
	             System.out.println("GeoZone=" + entry.getKey() +
	                                 ", Average BuildDUration= " + getAverageOfBuildDuration(entry.getValue()));
	        }
    
		
	}
	 
	//Method takes Set of Integers and returns average for that 
	public double getAverageOfBuildDuration(HashSet<Integer> buildDuration)
	{
		int length=buildDuration.size();
		Iterator<Integer> it = buildDuration.iterator();
		// default sum value.
        int sum = 0;
        while(it.hasNext()){
        	sum += it.next().intValue();
         }
        double average = sum / length;
        
		return average;
	}
	
}
