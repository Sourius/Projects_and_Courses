<?php
	// Constants
	define("TITLE", "Arrays");

	// Variables
	$current_year = date("Y");
	$author = "sourius";
	
	// Arrays
	$person = array(
		array(
			"name" => "Carter",
			"age" => "adult",
			"country" => "Canada",
			"moustache" => array(
				"name" => "Handlebar",
				"colour" => "black"
			)
		),
		array(
			"name" => "Rodrigo",
			"age" => "teenager",
			"country" => "Uruguay",
			"moustache" => array(
				"name" => "Fu Manchu",
				"colour" => "brown"
			)
		),
		array(
			"name" => "Carter",
			"age" => "adult",
			"country" => "Italy",
			"moustache" => array(
				"name" => "Salvador Dali",
				"colour" => "blonde"
			)
		)
	);
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Get Your Hands Dirty: <?php echo TITLE; ?></title>
		<link href="../assets/styles.css" rel="stylesheet">
		<script type="text/javascript" src="../assets/syntaxhighlighter/scripts/shCore.js"></script>
		<script type="text/javascript" src="../assets/syntaxhighlighter/scripts/shBrushPhp.js"></script>
		<link type="text/css" rel="stylesheet" href="../assets/syntaxhighlighter/styles/shCoreDefault.css"/>
		<script type="text/javascript">SyntaxHighlighter.all();</script>
	</head>
	<body>
		<div class="wrapper">
			<a href="/CodeDynamicWebsites" title="Back to directory" id="logo">
				<img src="../assets/img/logo.png" alt="PHP">
			</a>
			
			<h1>Get Your Hands Dirty: <small><?php echo TITLE; ?></small></h1>
			<hr>
			
			<h2>Your Example</h2>
			
			<div class="sandbox">
				<h3><?php echo $person[0]["name"]." from ".$person[0]["country"] ;?></h3>
				<p>
					<b><?php echo $person[0]["name"] ; ?></b> is quite the <b><?php echo $person[0]["age"] ; ?>!</b> He sports a solid <b><?php echo $person[0]["moustache"]["name"] ; ?></b> Moustache that is <b><?php echo $person[0]["moustache"]["colour"] ; ?></b> in colour.
				</p>
				
				<h3><?php echo $person[1]["name"]." from ".$person[1]["country"] ;?></h3>
				<p>
					<b><?php echo $person[1]["name"] ; ?></b> is a rather dapper <b><?php echo $person[1]["age"] ; ?>!</b> He proudly wears a <b><?php echo $person[1]["moustache"]["name"] ; ?></b> that is coloured a gentle <b><?php echo $person[1]["moustache"]["colour"] ; ?></b>.
				</p>

				<h3><?php echo $person[2]["name"]." from ".$person[2]["country"] ;?></h3>
				<p>
					<b><?php echo $person[2]["name"] ; ?></b> might seem too young for a 'stache because he is a <b><?php echo $person[2]["age"] ; ?>.</b> But he proudly displays his <b><?php echo $person[2]["moustache"]["name"] ; ?></b> at school! Although, it's a little hard to see because it's light <b><?php echo $person[2]["moustache"]["colour"] ; ?></b>.
				</p>
			</div><!-- end sandbox -->
			
			<a href="index.php" class="button">Back to the final example</a>
			<hr>
			
			<small>&copy;<?php echo $current_year; ?> - <?php echo $author; ?></small>
		</div><!-- end wrapper -->
		
		<div class="copyright-info">
			<?php include('../assets/includes/copyright.php'); ?>
		</div><!-- end copyright-info -->
	</body>
</html>
