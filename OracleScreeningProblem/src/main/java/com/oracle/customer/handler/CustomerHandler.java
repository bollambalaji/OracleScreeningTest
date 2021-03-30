package com.oracle.customer.handler;

import java.util.List;

import com.oracle.customer.bean.CustomerDetailsBean;
import com.oracle.customer.service.Mapper;
import com.oracle.customer.service.impl.MapperImpl;
import com.oracle.customer.service.impl.CustomerServiceImpl;

public class CustomerHandler {

	CustomerServiceImpl taskHandler;
	
	Mapper mapString;
	
	public void handleCustomer(String multiLineList)
	{
		        //SingleTon class
				taskHandler=CustomerServiceImpl.getInstance();
				
				mapString=new MapperImpl();
				
				//Get All data to List of Beans
				List<CustomerDetailsBean> listOfRows=mapString.setMultiLineToBean(multiLineList);
			    System.out.println("Set All data to List of Beans:"+listOfRows);
			    System.out.println();
			    
			    //get Operations only if List of beans contain data
			    if(listOfRows.size() >0)
			    {
			    //The number of unique customerId for each contractId.
				taskHandler.findUniqueCustomerForContractId(listOfRows);
				
				 //The number or list of unique customerId for each geoZone.
				taskHandler.findUniqueCustomerForGeoZone(listOfRows);
				
				//Average Build Duration for each =new TaskHandler();
				taskHandler.averageBuildDurationForGeoZone(listOfRows);
	              }
	
	}
}
