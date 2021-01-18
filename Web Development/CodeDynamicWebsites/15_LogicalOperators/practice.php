<?php
	
	// Constants
	define("TITLE", "Logical Operators");
	
	// Custom Variables
	$lesson = 15;
	$year = date("Y");
	$author = "sourius";

	$username = "jhonnyboy";
	$password = "qwerty";
	
	$cartTotal = 19.99;
	$couponCode = "DiscountPlease";
?>

<!DOCTYPE html>
<html>
	<head>
		<title>PHP <?php echo TITLE;?></title>
		<link href="../assets/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Tutorial <?php echo $lesson;?>: <small><?php echo TITLE;?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				
				<h3>And <code>and</code></h3>
				<?php
					if($username == 'jhonnyboy' and $password == 'qwerty'){
						echo "<p>Login info is correct!</p>";
					}
					else {
						echo "<p>Login info is incorrect</p>";
					}
				?>
				
				<h3>Or <code>or</code></h3>
				<?php
					if($cartTotal > 15 or $couponCode == "Discount Please"){
						echo "<p>You get a discount!</p>";
					}
					else {
						echo "<p>You don't get a discount!</p>";
					}
				?>
				
				<h3>Not <code>!</code></h3>
				<?php
					$ownDog = true;
					if(!$ownDog){
						echo "<p>You don't have a dog!</p>";
					}
					else {
						echo "<p>You have a dog.</p>";
					}
				?>
				
				<h3>And <code>&amp;&amp;</code></h3>
				<?php
					if($username == 'jhonnyboy' && $password == "qwerty"){
						echo "<p>Correct login info!</p>";
					} else{
						echo "<p>Login info is not correct!</p>";
					}
				?>
				
				<h3>Or <code>||</code></h3>
				<?php
					if($cartTotal > 15 || $couponCode == "Discount Please"){
						echo "<p>You get a discount!</p>";
					}
					else {
						echo "<p>You don't get a discount!</p>";
					}
				?>
				
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the lecture</a>
			
			<hr>
			
			<small>&copy;<?php echo $year;?> - <?php echo $author;?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>