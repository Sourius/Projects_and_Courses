<?php
	
	// Constants
	define("TITLE", "Elseif"); 
	
	// Custom Variables
	$lesson = 12;
	$year = date("Y");
	$author = "sourius";

	$native_language = "Spanish";


?>

<!DOCTYPE html>
<html>
	<head>
		<title>PHP <?php echo TITLE; ?></title>
		<link href="../assets/styles.css" rel="stylesheet">
		<meta charset="utf-8">
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
				<?php 
					if($native_language == "French"){
						echo "Bonjour! Vous parlez Farnçais";
					}
					else if($native_language == "Spanish"){
						echo "¡Hola! Usted habla español.";
					}
					else if($native_language == "Arabic"){
						echo "Yay! You can speak Arabic";
					}
					else{
						echo "Hello! You probably speak English";
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
