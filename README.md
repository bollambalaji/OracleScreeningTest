# OracleScreeningTest
For Submitting Oracle Screening test
---------------Code Documentation
1.Class: com.oracle.OracleScreeningProblem.MainClass.java
This is Entry class i,e. main class to Application , From here we are calling TaskHandler Singleton class to perform different operations 

2.Class:com.oracle.OracleScreeningProblem.bean.TeamDetailsBean.java
Bean class which contain Row information in Multiline String provided Input

3.Class : com.oracle.OracleScreeningProblem.TaskHandler.java
SingleTon class where we have all Method for Particular Operation Need to be Performed 
Methods:
   setMultiLineToBean()
   Method takes Multiline string as Input AND loads every Row to Bean object and return list Of TeamDetailsBean
   
   findUniqueCustomerForContractId()
   Method take List of Rows i,e TeamDetailsBean's. Here we are iterating list . Every CuntractId we are adding as Map key And Customer ID's for That particular ContractId we are adding it in a HasSet
   so that it will remove Duplicates.

   findUniqueCustomerForGeoZone()
   Method take List of Rows i,e TeamDetailsBean's Here we are iterating list . Every GeoZone we are adding as Map key And Customer ID's for That particular GeoZone we are adding it in a HasSet so that it will remove Duplicates

   averageBuildDurationForGeoZone()
   Method take List of Rows i,e TeamDetailsBean's Here we are iterating list . Every GeoZone we are adding as Map key 
	 And BuildDurations for That particular GeoZone we are adding it in a HasSet so that it will remove Duplicates
	 After getting BuildDurations in Set For particular GeoZon we are getting average of buildDuration
	Using other method getAverageOfBuildDuration
  
  getAverageOfBuildDuration()
  Method takes Set of Integers and returns average for that 
