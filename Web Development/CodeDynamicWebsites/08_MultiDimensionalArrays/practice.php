<?php
	// Constants
	define("TITLE", "Multi-Dimensional Arrays");
	
	// Custom Variables
	$author = "sourius";
	$lesson_number = 8;

	// Moustache Multi-Dimensional Array
	$moustache = array(
		array(
			"name" => "Handlebar",
			"factor" => "High",
			"growdth" => 14
		),
		array(
			"name" => "Salvador Dali",
			"factor" => "Extreme",
			"growdth" => 62
		), 
		array(
			"name" => "Fu Manchu",
			"factor" => "Very High",
			"growdth" => 58
		)
	);
?>

<!DOCTYPE html>
<html>
	<head>
		<title>PHP <?php echo TITLE; ?></title>
		<link href="../assets/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Tutorial <?php echo $lesson_number; ?>: <small><?php echo TITLE; ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				<h2>The <?php echo $moustache[0]["name"]; ?> Moustache!</h2>
				<p>This moustache is quite the dirt squirrel! It boasts a creep factor of <strong><?php echo $moustache[0]["factor"]; ?></strong> and takes <strong><?php echo $moustache[0]["growdth"]; ?> days</strong> to grow on average.</strong></p>
				
				<!-- REPEAT ABOVE 2X -->
				<h2>The <?php echo $moustache[1]["name"]; ?> Moustache!</h2>
				<p>This moustache is quite the dirt squirrel! It boasts a creep factor of <strong><?php echo $moustache[1]["factor"]; ?></strong> and takes <strong><?php echo $moustache[1]["growdth"]; ?> days</strong> to grow on average.</strong></p>

				<h2>The <?php echo $moustache[2]["name"]; ?> Moustache!</h2>
				<p>This moustache is quite the dirt squirrel! It boasts a creep factor of <strong><?php echo $moustache[2]["factor"]; ?></strong> and takes <strong><?php echo $moustache[2]["growdth"]; ?> days</strong> to grow on average.</strong></p>
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the lecture</a>
			
			<hr>
			
			<small>&copy;<?php echo date("Y"); ?> - <?php echo $author; ?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include ('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
