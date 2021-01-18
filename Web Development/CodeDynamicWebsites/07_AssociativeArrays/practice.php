<?php
	
	// Constants
	define("TITLE", "Associative Arrays");
	
	// Custom Variables
	$current_year = date("Y");
	$lesson_number = 07;
	$author = "sourius";

	// Moustache Associative Array
	$moustache_aa = array(
		"name" => "Handlebar",
		"factor" => "High",
		"growth" => 14
	);

?>

<!DOCTYPE html>
<html>
	<head>
		<title>PHP <?php echo(TITLE); ?></title>
		<link href="../assets/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Tutorial <?php echo($lesson_number); ?>: <small><?php echo(TITLE); ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
			
				<h2>The <?php echo($moustache_aa["name"]); ?> Moustache!</h2>
				<p>This moustache is quite the dirt squirrel! It boasts a creep factor of <strong><?php echo($moustache_aa["factor"]); ?></strong> and takes <strong><?php echo $moustache_aa["growth"]; ?> days</strong> to grow on average.</strong></p>
				
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the lecture</a>
			
			<hr>
			
			<small>&copy;<?php echo($current_year); ?> - <?php echo $author;?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
