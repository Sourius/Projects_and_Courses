<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

		<title>Coursera, JavaScript</title>
		<link rel="stylesheet" href="./css/events.css"/>
		
	</head>

	<body class="text-center">
		<h1>Codigo exercise</h1>
		
		<div class="container brownDiv" id="first-div">
			Hello
		</div>
		
		<div class="container yellowDiv" id="second-div">
			Bye
		</div>
		
		<input type="button" id="swap-btn" onclick="swapColors();" value="Swap Colors"/>
		<input type="button" id="swapText-btn" onclick="swapText();" value="Swap Text"/>
		
		<div class="container">
			<canvas id="myCanvas"></canvas>
			<br>
			<input type="range" id="cubeSlider" min="10" max="100" oninput="drawCube()" value="10"/>
			<input type="button" id="changeBG" value="Change color" onclick="changeBackGroundColor()"/>
			<input type="color" id="colorInput" value="#0000FF" onchange="changeBackGroundColor()" />
		</div>
		
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<script src="./js/events.js"></script>
	</body>
</html>