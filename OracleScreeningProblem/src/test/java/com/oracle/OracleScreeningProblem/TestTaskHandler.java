package com.oracle.OracleScreeningProblem;
import org.junit.Before;
import org.junit.Test;

import com.oracle.OracleScreeningProblem.bean.TeamDetailsBean;

import static org.junit.Assert.*;

import java.util.List; 

public class TestTaskHandler {
	
	TaskHandler taskHandler;
	String multiLineString;
	
	@Before
	public void setup()
	{
		taskHandler=TaskHandler.getInstance();
		multiLineString= "2343225,2345,us_east,RedTeam,ProjectApple,3445s \n"
		         + "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s \n"
		         + "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s \n"
		         + "1233456,2345,us_west,BlueTeam,ProjectDate,2221s \n"
		         + "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
	}
	
	@Test
	public void testSetMultiLineToBean()
	{
		List<TeamDetailsBean> listOfRows=taskHandler.setMultiLineToBean(multiLineString);
		System.out.println("Set All data to List of Beans:"+listOfRows);
		assertNotNull(listOfRows);
	}
}
