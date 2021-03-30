"Given a string with the following data (it includes multiple lines):
2343225,2345,us_east,RedTeam,ProjectApple,3445s
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
 
The data is organized into columns delimited by a comma(,)
in the following order:
customerId,contractId,geozone,teamcode,projectcode,buildduration
 
The first line of data would then be interpreted as
  2343225 is the customerId
  2345 is the contractId
  us_east is the geozone
  RedTeam is the teamcode
  ProjectApple is the projectcode
  3445s is the buildduration
 
Using one of the following programming languages JAVA/JAVA8, write code (a function or method) that takes the entire multiline string and produces a report containing the following:
 
  The number of unique customerId for each contractId.
  The number of unique customerId for each geozone.
  The average buildduration for each geozone.
  The list of unique customerId for each geozone."
  
Note : 
Please be mindful of coding best practices
(1) Clean code.
(2) Design Patterns
(3) Design Principles
(3) Test Cases(TDD)

Note : 
(1) Please checkin the code in GitHub
(2) Please maintain the change history
