package com.oracle.OracleScreeningProblem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;


import com.oracle.OracleScreeningProblem.bean.TeamDetailsBean;

public class TaskHandler {
	
	private static TaskHandler taskHandler=null;
	
	private TaskHandler()
	{
		
	}

	public static TaskHandler getInstance()
	{
		if(taskHandler == null)
			taskHandler=new TaskHandler();
		return taskHandler;
	}

	/*Method take List of Rows i,e TeamDetailsBean's Here we are iterating list . Every CuntractId we are adding as Map key 
	And Customer ID's for That particular ContractId we are adding it in a HasSet so that it will remove Duplicates*/
	public void findUniqueCustomerForContractId(List<TeamDetailsBean> listOfRows) {
		// TODO Auto-generated method stub
		HashMap<Integer,Set<BigInteger>> teamContract=new HashMap<Integer,Set<BigInteger>>();
		
		for(TeamDetailsBean team:listOfRows)
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

	//Method takes MultiLine string as Input AND loads every Row to Bean object and return list Of Bean
	public List<TeamDetailsBean> setMultiLineToBean(String multiLineList) {
		String lines[] = multiLineList.split("[\\r\\n]+");
		List<TeamDetailsBean> listOfRows=new ArrayList<TeamDetailsBean>();
		
		for (String line : lines) {
			String words[] = line.split(",");
			TeamDetailsBean bean=new TeamDetailsBean();
			if(words.length ==6)
			{
				bean.setCustomerId(new BigInteger(words[0]));
				bean.setContractId(Integer.valueOf(words[1]));
				bean.setGeozone(words[2]);
				bean.setTeamcode(words[3]);
				bean.setProjectcode(words[4]);
				String buildDureation=words[5].trim();
				buildDureation=buildDureation.substring(0,buildDureation.length()-1);
				bean.setBuildduration(Integer.valueOf(buildDureation));
				listOfRows.add(bean);
			}
			else
			{
				System.out.println("Give row is not valid to capture data to beans");
			}
				
			
		}
		return listOfRows;
	}

	/*Method take List of Rows i,e TeamDetailsBean's Here we are iterating list . Every GeoZone we are adding as Map key 
	And Customer ID's for That particular GeoZone we are adding it in a HasSet so that it will remove Duplicates*/
	public void findUniqueCustomerForGeoZone(List<TeamDetailsBean> listOfRows) {

		HashMap<String,Set<BigInteger>> teamGeoGZone=new HashMap<String,Set<BigInteger>>();
		
		for(TeamDetailsBean team:listOfRows)
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

	/*Method take List of Rows i,e TeamDetailsBean's Here we are iterating list . Every GeoZone we are adding as Map key 
	 And BuildDurations for That particular GeoZone we are adding it in a HasSet so that it will remove Duplicates
	 After getting BuildDurations in Set For particular GeoZon we are getting average of buildDuration
	Using other method getAverageOfBuildDuration*/
	public void averageBuildDurationForGeoZone(List<TeamDetailsBean> listOfRows) {
      Map<String,HashSet<Integer>> teamGeoGZone=new HashMap<String,HashSet<Integer>>();
		
       //Getting Build Durations for each GeoZone
		for(TeamDetailsBean team:listOfRows)
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
