package com.oracle.customer;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.oracle.customer.bean.CustomerDetailsBean;
import com.oracle.customer.service.Mapper;
import com.oracle.customer.service.impl.MapperImpl;
import com.oracle.customer.service.impl.CustomerServiceImpl;

import static org.junit.Assert.*;

import java.util.List; 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCustomerHandler {
	
	CustomerServiceImpl taskHandler;
	String multiLineString;
	List<CustomerDetailsBean> listOfRows;
	Mapper mapString;
	
	@Before
	public void setup()
	{
		taskHandler=CustomerServiceImpl.getInstance();
		multiLineString= "2343225,2345,us_east,RedTeam,ProjectApple,3445s \n"
		         + "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s \n"
		         + "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s \n"
		         + "1233456,2345,us_west,BlueTeam,ProjectDate,2221s \n"
		         + "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
		    
		mapString=new MapperImpl();
		listOfRows=mapString.setMultiLineToBean(multiLineString);
		System.out.println("Set All data to List of Beans:"+listOfRows);
		
	}
	
	
	@Test
	public void testfindUniqueCustomerForContractId()
	{
		if(listOfRows.size() >0)
			taskHandler.findUniqueCustomerForContractId(listOfRows);
	}
	
	@Test
	public void testfindUniqueCustomerForGeoZone()
	{
		if(listOfRows.size() >0)
			taskHandler.findUniqueCustomerForGeoZone(listOfRows);
	}
	
	@Test
	public void testaverageBuildDurationForGeoZone()
	{
		if(listOfRows.size() >0)
			taskHandler.averageBuildDurationForGeoZone(listOfRows);
	}
	
	
}
