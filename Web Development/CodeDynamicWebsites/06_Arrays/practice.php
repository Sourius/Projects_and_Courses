<?php
	
	// Constants
	define("TITLE", "Arrays");
	
	// Custom Variables
	$lesson_number = 06;
	
	// Moustache Array
	$moustache = array("Handlebar", "Salvador Dali", "Fu Manchu");
?>

<!DOCTYPE html>
<html>
	<head>
		<title><?php echo TITLE;?></title>
		<link href="../assets/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Lecture <?php echo $lesson_number;?>: <small><?php echo TITLE;?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
			
				<h2>Moustache Types</h2>
				<ul>
					<li><?php echo $moustache[0];?></li>
					<li><?php echo $moustache[1];?></li>
					<li><?php echo $moustache[2];?></li>
				</ul>
				
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the lecture</a>
			
			<hr>
			
			<small>&copy;<?php echo date("Y");?> - <?php echo "Sourius";?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
