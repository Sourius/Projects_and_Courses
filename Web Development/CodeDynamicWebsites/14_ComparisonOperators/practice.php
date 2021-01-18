<?php
	// Constants
	define("TITLE", "Comparison Operators");
	
	// Custom Variables
	$lesson = 14;
	$year = date("Y");
	$author = "sourius";

	$yearsOnEarth = 25.32;
	$favouriteStringNum = "1";
	$birthCountry = "Canada";
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
			
			<h1>Tutorial <?php echo $lesson; ?>: <small><?php echo TITLE; ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				
				<h3>Equal <code>==</code></h3>
				<?php
					if($yearsOnEarth == 25.32){
						echo "<p>Your age is equal to $yearsOnEarth</p>";
					}
				?>
				
				<h3>Identical <code>===</code></h3>
				<?php
					if($favouriteStringNum === 1){
						echo "<p>Your favourite number is an integer</p>";
					}
					else if($favouriteStringNum === "1"){
						echo "Your favourite number is a string called 1!";
					}
					else {
						echo "<p>You must have a different favourite number than 1 the integer, or the string.</p>";
					}
				?>
				
				<h3>Not Equal <code>!=</code></h3>
				<?php
					if($birthCountry != "Mexico"){
						echo "<p>Excuse me,señor. You must not be from around here.</p>";
					}
					else{
						echo "<p>Excuse me, señor. You are Mexican.</p>";
					}
				?>
				
				<h3>Not Identical <code>!==</code></h3>
				<?php
					if($yearsOnEarth !== "25.32"){
						echo "<p>You are not exactly the string '$yearsOnEarth'</p>";
					} 
					else {
						echo "<p>You are exactly the string \"$yearsOnEarth\" </p>";
					}
				?>
				
				<h3>Less Than <code>&lt;</code></h3>
				<?php
					if($lesson < 15){
						echo "You haven't quite made it to lesson 15, yet.";
					}
				?>
				
				<h3>Greater Than <code>&gt;</code></h3>
				<?php
					if($lesson > 10){
						echo "You've made it past lesson 10!";
					}
				?>
				
				<h3>Less Than or Equal To <code>&lt;=</code></h3>
				<?php
					if($lesson <= 14){
						echo "$lesson is less than or equal to 14";
					}
				?>
				
				<h3>Greater Than or Equal To <code>&gt;=</code></h3>
				<?php
					if($lesson >= 4){
						echo "$lesson is greater than equal to 4";
					}
				?>
				
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the lecture</a>
			
			<hr>
			
			<small>&copy;<?php echo $year; ?> - <?php echo $author; ?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
