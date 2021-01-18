<?php
	
	// Constants
	define("TITLE", "Intro to Functions");
	
	// Custom Variables
	$myName	= "sourius";
	$lessonNum	= 23;
	
	function myFunction(){
		echo "hello from my function";
	}
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
			
			<h1>Tutorial <?php echo $lessonNum; ?>: <small><?php echo TITLE; ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				
				<h3>Using <code>sort()</code></h3>
				<?php
					$dinner = array("Meat", "Potatoes", "Beans", "Rice");
					sort($dinner);
					foreach($dinner as $ingredient){
						echo "$ingredient<br>";
					}
				?>
				
				<h3>Using <code>rsort()</code></h3>
				<?php
					$dinner = array("Meat", "Potatoes", "Beans", "Rice");
					rsort($dinner);
					foreach($dinner as $ingredient){
						echo "$ingredient<br>";
					}
				?>
				
				<h3>Using <code>strtolower()</code></h3>
				<?php
					$dinner = array("Meat", "Potatoes", "Beans", "Rice");
					foreach($dinner as $ingredient){
						echo strtolower($ingredient)."<br>";
					}
				?>
				
				<h3>Using <code>sha1()</code></h3>
				<?php
					$dinner = array("Meat", "Potatoes", "Beans", "Rice");
					foreach($dinner as $ingredient){
						echo sha1($ingredient)."<br>";
					}
				?>
				
			</div><!-- end sandbox -->
			<a href="index.php" class="button">Back to the lecture</a>
			
			<hr>
			
			<small>&copy;<?php echo date('Y'); ?> - <?php echo $myName; ?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
