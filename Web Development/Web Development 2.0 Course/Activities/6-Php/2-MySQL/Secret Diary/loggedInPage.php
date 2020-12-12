<?php 
	error_reporting(E_ERROR | E_PARSE |E_WARNING);
	session_start();
	$logout = "";
	$diaryContent = "";
	
	if(array_key_exists("id",$_COOKIE)){
		$SESSION['id'] = $_COOKIE['id'];
	}
	
	if(array_key_exists("id",$_SESSION)){
		$logout= "<a class='btn btn-danger ml-auto' href='index.php?logout=1'>Log Out</a>";
		
		$link = mysqli_connect("localhost", "root", "", "test");
		
		$query = "SELECT `diary` FROM `users` WHERE `id`=".mysqli_real_escape_string($link, $_SESSION["id"])."";
		$row = mysqli_fetch_array(mysqli_query($link, $query));
		
		$diaryContent = $row['diary'];
	}
	else{
		header("Location: index.php");
	}
?>

<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

		<!-- Custom CSS -->
		<link rel="stylesheet" href="./css/custom-style.css">

		<title>Secret Diary</title>
	</head>	

	<body>
		<div class="container">
			<div class="row mt-2">
				<?php echo $logout ?>
			</div>
			
			<div class="row mt-2">
				<textarea id="diary"><?php echo $diaryContent; ?></textarea>
			</div>
		</div>
		
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		
		<!-- Custom scripts -->
		<script src="./js/diary.js"></script>
	</body>
</html>