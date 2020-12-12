<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

		<title>Coursera, JavaScript</title>
		<link rel="stylesheet" href="./css/imageFiltering.css"/>
		
	</head>

	<body class="text-center">
		<h1>Mini Project</h1>
		
		<canvas id="imageCanvas">
		
		</canvas>
		
		<br/>
		<input type="file" id="imageFile" value="Upload" multiple="false" accept="image/*" onchange="uploadImage()" />
		<br/>
		<input type="button" id="grayScaleButton" value="Convert to Gray Scale" onclick="convertToGrayScale()" />
		<input type="button" id="rainbowImageButton" value="Convert to Rainbow" onclick="convertToRainbow()" />
		<input type="button" id="redImageButton" value="Convert to Red" onclick="convertToRed()" />
		<input type="button" id="resetImageButton" value="Reset Image" onclick="resetImage()" />
		
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<script src="./js/imageFiltering.js"></script>
		<script src="http://www.dukelearntoprogram.com/course1/common/js/image/SimpleImage.js"></script>
	</body>
</html>