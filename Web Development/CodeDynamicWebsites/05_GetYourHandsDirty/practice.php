<?php
	date_default_timezone_set('Europe/Madrid');
	// Define a Constant
	define("TITLE", "Variables and Constants");
	
	// Your Variables
	$current_date = date("F j, Y");
	$current_year = date("Y");
	
	$name = "sourius";
	$favourite_color = "green";
	$birth_year = 2012;

	/*
	Use PHP to calculate the difference
	between your birth year and this year
	to show your age dynamically
	*/
	$age = $current_year - $birth_year;

	
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Get Your Hands Dirty: <?php print(TITLE); ?></title>
		<link href="../assets/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Get Your Hands Dirty: <small><?php print(TITLE); ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				<h3>Today's Date:</h3>
				<p><?php print($current_date); ?></p>
				
				<h3>My Name:</h3>
				<p><?php print($name); ?></p>
				
				<h3>My Favourite Colour:</h3>
				<p><?php print($favourite_color); ?></p>
				
				<h3>My Age:</h3>
				<p><?php print($age); ?></p>
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the final example</a>
			
			<hr>
			
			<small>&copy;<?php print($current_year); ?> - <?php print($name); ?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
