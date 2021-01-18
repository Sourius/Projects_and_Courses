<?php
	
	// Constants
	define("TITLE","String Operators");
	
	// Custom Variables
	$lesson = 17;
	$year = date("Y");
	$author = "sourius";

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
				
				<h3>Concatenation Operator <code>.</code></h3>
				<?php
					$a = "Hola ";
					$b = "Mi Amigos!";
					echo $a.$b;
				?>
				
				<h3>Concatenating Assignment Operator <code>.=</code></h3>
				<?php	
					$a = "Hola ";
					$a .= "Mi Amigos!";
					echo $a; 
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
