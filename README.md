# Tennis court reservation
This is a Spring Boot application to create a reservation for tennis court.

# Needed software
To run this program you need to install these applications.
  - MYSQL (https://dev.mysql.com/downloads/installer/)
  - Postman (https://www.postman.com/downloads/)

# How to start
After downloading the mentioned applications what you need to do is open an MySql Workbench and create a new connection
with details:
  - port =  "3306"
  - username =  "root" 
  - password = "admin"
  
If you used a different details you need to change the values in the "application.properties" file:
> spring.datasource.url=jdbc:mysql://localhost:3306/tennis_court<br />
spring.datasource.username=root<br />
spring.datasource.password=admin<br />

After doing this you have to log into the connection and create a new schema called "tennis_court".
This is all you need to do for the MySQL part.

# How to create a reservation
After successfully connected to the MySQL database, you can now create the reservation.<br />
What you need to do is: <br />
  - 1. Run the "TennisCourtReservationApplicationTests.java" that will create all the courts that the tennis club owns.
  - 2. Run "TennisCourtReservationApplication.java" to start the application.
  - 3. Go to Postman.

How to use Postman to create a reservation:
  - Select POST and use following address "http://localhost:8082/reservations".
  - Go to Body -> form-data > Bulk Edit -> write following <br />
> courtId:<br />
customerName:<br />
customerSurname:<br />
telephoneNumber:<br />
startTime:<br />
endTime:<br />
doubles:<br />

Then add the values you would like use after the ":" sign.<br />
For example:
> courtId: 1<br />
customerName: John<br />
customerSurname: Francis<br />
telephoneNumber:+420 904 613 312<br />
startTime: 2022-5-6 04:30:00<br />
endTime:2022-5-6 05:30:00 <br />
doubles: true<br />

And this is all you need to do.

Value description:
  - courtId = number in long format that exists in the court database.
  - customerName = name containing only alphabetic characters(regex:a-zA-z).
  - customerSurname = surname containing only alphabetic characters(regex a-zA-z).
  - telephoneNumber = number starting with + and following by only digits(regex 0-9).
  - startTime = start of the reservation, must be in format "yyyy-mm-dd hh:mm:ss".
  - endTime = end of the reservation, must be in format "yyyy-mm-dd hh:mm:ss".
  - doubles = true if you want to play doubles, false for multi doubles.
 
# How to get all courts from the database
By this you will get all the courts with their court id and court surface available in database.
  - Go to Postman and use GET.
  - Use "http://localhost:8082/courts".
  - Press Send.
  
# How to get all reservations from database by telephone number or court id.
If you want to get all reservations created with certain number use:
  - Go to Postman and use Post.
  - Use "http://localhost:8082/reservations/number/{telephone number}".
  - For example "http://localhost:8082/reservations/number/+420204567201".
  - Press Send.<br />
  
If you want to get all reservations from database by court id:
  - Go to Postman and use Post.
  - Use "http://localhost:8082/reservations/{court id}".
  - For example "http://localhost:8082/reservations/1".
  - Press Send.<br />
  

  




  
