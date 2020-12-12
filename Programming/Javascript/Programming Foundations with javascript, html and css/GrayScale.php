<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

		<title>Coursera, JavaScript</title>
		<link rel="stylesheet" href="./css/grayscale.css"/>
		
	</head>

	<body class="text-center">
		<h1>Codigo exercise, Upload and Display Image</h1>
		
		<canvas id="imageCanvas">
		
		</canvas>
		<canvas id="grayScaleCanvas">
		
		</canvas>
		<br/>
		<input type="file" id="imageFile" value="Upload" multiple="false" accept="image/*" onchange="uploadImage()" />
		<input type="button" id="grayScaleButton" value="Convert to Gray Scale" onclick="convertToGrayScale()" />
		
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<script src="./js/grayscale.js"></script>
		<script src="http://www.dukelearntoprogram.com/course1/common/js/image/SimpleImage.js"></script>
	</body>
</html>