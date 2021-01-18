<?php
	
	// Constants
	define("TITLE", "Assignment Operators");
	
	// Custom Variables
	$year = date("Y");
	$lesson = 24;
	$author = "sourius";

?>

<!DOCTYPE html>
<html>
	<head>
		<title>PHP <?php print(TITLE); ?></title>
		<link href="../assets/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Tutorial <?php print($lesson); ?>: <small><?php print(TITLE); ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				
				<h3>Addition Assignment Operator <code>+=</code></h3>
				<?php
					$a = 30;
					$a += 50;
					echo $a;
				?>
				
				<h3>Subtraction Assignment Operator <code>-=</code></h3>
				<?php
					$a = 30;
					$a -= 50;
					echo $a;
				?>
				
				<h3>Multiplication Assignment Operator <code>*=</code></h3>
				<?php
					$a = 30;
					$a *= 50;
					echo $a;
				?>
				
				<h3>Division Assignment Operator <code>/=</code></h3>
				<?php
					$a = 30;
					$a /= 50;
					echo $a;
				?>
				
				<h3>Modulus Assignment Operator <code>%=</code></h3>
				<?php
					$a = 30;
					$a %= 50;
					echo $a;
				?>
				
				<h3>Concatenation Assignment Operator <code>.=</code></h3>
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
