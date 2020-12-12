<?php
    error_reporting(E_ERROR | E_PARSE);
	$link = mysqli_connect("localhost","root","","test");
	
	$con_error = mysqli_connect_error(); //error message
	if($con_error){
		//stops if there is an error connectiong with database
		die("<p>Could not connect to database</p>");
	}
	
	// getting data from database
	$query = "SELECT * FROM users where name='".mysqli_real_escape_string($link,"name1")."';";
	
	$result = mysqli_query($link, $query);
	if($result){
		$row = mysqli_fetch_array($result);
		while($row){
			print_r($row);
			echo("<br>");
			$row = mysqli_fetch_array($result);
		}
		
	}
?>


<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- Required meta tags always come first -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="x-ua-compatible" content="ie=edge">

		<title></title>

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		  
		<style type="text/css">
			
		</style>
	</head>
	
	<body>
		
		
		<!-- jQuery first, then Bootstrap JS. -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>