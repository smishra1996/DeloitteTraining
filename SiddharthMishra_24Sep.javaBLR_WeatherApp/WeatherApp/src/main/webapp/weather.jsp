<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" >
 <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='resources/twitterbootstrapjs.js'></script>



<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>TodaysWeather</title>
  <title>Todays Weather</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/weather-icons/2.0.10/css/weather-icons.min.css'>

      <link rel="stylesheet" href="resources/style.css">

  
</head>

  	<body class="text-white pt-2">
  	
		
 <input type="text" id="search" name="search" class="form-control" placeholder="Search for city..." aria-label="Search for...">
 <input type="submit" value="Save to favourite" action="views/displayCities.jsp">
 	
			
			
			<!-- for submitting to db -->
			
			 
			
			<!-- for submitting to db ends -->
		
			
			
			
<!-- 			<input type="submit" id="search-button" class="btn btn-dark" value="Go!">
 -->			
			<header>
				<!-- <p id="about" class="text-right mb-0">About</p> -->
				
				<h1 class="display-1 mb-5">Todays weather</h1>
				
			</header>
					
			<section class="ml-5">
				<h2 class="display-4 mb-5"><span id="place">-----</span> today</h2>
				<p><span id="weather" class="display-3 ml-5">---------</span></p>
				<p><span id="temp" class="display-1 ml-5 mr-5">--</span><i id="icon" class="wi ml-5"></i></p>
			</section>
					
			<footer class="tools row fixed-bottom mb-5 w-75 mx-auto">
				<div class="input-group col-sm-5">
					
					<span class="input-group-btn">
						
					</span><!--.input-group-btn-->				
				</div><!--.input-group-->
				
				<div id="tempunit" class="btn-group col">
					<label class="btn btn-secondary active">
						&#8451 <input id="cel" type="radio" name="temp" checked>
					</label>
					<label class="btn btn-secondary">
						<input id="far" type="radio" name="temp"> &#8457;
					</label>
				</div><!--#tempunit-->
				
				<!-- <button type="button" id="home-button" class="btn btn-dark col col-xl-2">My location</button> -->
			</footer>
		</div><!--.container-->
			
		<!-- Model -->
		<div id="about-dialog" class="">
			<div id="close"></div>
			<h3>Todays Weather</h3>
			<p>Weather data from <a href="https://openweathermap.org" target="_blank">OpenWeatherMap.org</a></p>

		<!-- 	video code -->
		<!-- The video -->
<video autoplay muted loop id="myVideo">
  <source src="water-background-bw.webm" type="video/mp4">
</video>
		
<!-- 		video ends here -->
		
		
		
		
		
		
		
		
		
			<!-- <p>Current background image from <a id="photo" href="http://larsvidar.no" target="_blank"><span id="photographer">google</span></a></p> -->
		</div><!--#about-box-->
			
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js'></script>

  

    <script  src="resources/index.js"></script>



</body>

</html>

</html>
