<?php
	error_reporting(E_ERROR | E_PARSE);
	$apiKey = "AIzaSyAykbhCzd7sr42FN4AtOOhHQ3RAO41Lzho";
	$geo_api = "AIzaSyD4c7YJ4rcFTbVHfbElCKHGJltXKRaSYTA";
	$geo_url = "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY";
?>

<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

		<title>Hello, world!</title>
	</head>

	<body>
	
		<div class="container">
			<h1>Postalcode finder</h1>
			<p>Enter the address to get the postal code</p>
			
			<div id="pc-alert"></div>
			
			<form>
				<div class="form-group">
					<label for="address">Address</label>
					<input type="text" class="form-control" id="address" placeholder="Enter the address"></input>
				</div>
				
				<button id="search-btn" type="submit" class="btn btn-primary">Search</button>
			</form>
		</div>
		
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		
		<script>
		
			jQuery("#search-btn").click(function(e){
				e.preventDefault();
				jQuery("#pc-alert").html("");
				
				jQuery.ajax({
					url: "https://maps.googleapis.com/maps/api/geocode/json?address="+encodeURIComponent(jQuery("#address").val())+"&key=AIzaSyD4c7YJ4rcFTbVHfbElCKHGJltXKRaSYTA",
					type: "GET",
					success: function(data){
						if(data["status"] != "OK"){
							jQuery("#pc-alert").html('<p class="alert alert-warning" role="alert">The postal code could not be found. Please try again."</p>");
						}
						else {
							jQuery.each(data["results"][0]["address_components"], function(key,value){
								if(value["types"][0] == "postal_code"){
									jQuery("#pc-alert").html('<p class="alert alert-success" role="alert">The postal code is: '+value["long_name"]'+"</p>");
								}
							});
						}
					}
				});
			});
		</script>
	</body>
</html>