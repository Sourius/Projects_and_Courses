<?php
	error_reporting(E_ERROR | E_PARSE);
	//include();
	include('weather_api.php');
	
	$weather = $error = "";
	if(array_key_exists('city',$_GET)){
		$city = urlencode($_GET['city']);
		
		$url = "http://api.openweathermap.org/data/2.5/weather?q=".$city."&appid=".$api_key;
		
		$urlContents = file_get_contents($url);
		$weatherArray = json_decode($urlContents,true);
		
		if($weatherArray["cod"] != 200){
			$error = "<div><p>That city could not be found. Please try again.</p></div>";
		}
		else{
			$weather = "The weather forecast of ".$city." is ".$weatherArray["weather"][0]['description'].".<br>";
			
			$tempInCelcious = intval($weatherArray['main']['temp'] - 273);
			
			$weather .= "The temperature is ".$tempInCelcious."&deg;C. <br>And the wind speed is ".$weatherArray["wind"]["speed"].".";
			
		}
	}
?>

<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		<title>Weather Scraper</title>
		
		<style>
			html { 
				background: url("https://images.unsplash.com/photo-1513237739339-5696060a5359?ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80") no-repeat center center fixed; 
				-webkit-background-size: cover;
				-moz-background-size: cover;
				-o-background-size: cover;
				background-size: cover;
			}
			
			body{
				background:none;
			}
			
			#content{
				margin-top: 10%;
				width:fit-content;
			}
			
			#city{
				margin-top:1em;
				width: 25em;
			}
			
			#forecast{
				margin-top: 2em;
				width: 27em;
				/*text-align: center;*/
			}
			
		</style>
	</head>
	
	<body>
		<div class="container justify-content-center text-center" id="content">
			<h1>What's The Weather?</h1>
			
			<form>
				<div class="container justify-content-center text-center" id="form-content">
					<fieldset class="form-group">
						<label for="city">Enter the name of the city.</label>
						<input class="form-control" type="text" name="city" id="city" placeholder="Eg. London, Tokyo" ></input>
					</fieldset>
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>	
		</div>
		<div id="forecast" class="container">
			<?php   
				if($weather){
					echo '<div class="alert alert-success text-center" role="alert">'.$weather.'</div>';
				}
				if($error){
					echo '<div class="alert alert-danger text-center" role="alert">'.$error.'</div>';
				}
			?>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>