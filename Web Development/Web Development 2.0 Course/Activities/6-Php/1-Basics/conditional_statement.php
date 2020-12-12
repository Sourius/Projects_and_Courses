<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);

	$user = "keller";
	
	echo("<p>");
	if($user == "keller"){
		echo("Hello there spellbinder");
	}else {
		echo("intruder, alert!");
	}
	echo("</p>");
	
	$age = 25;
	echo("<p>");
	if($age >= 18){
		echo("You may proceed.");
	}else{
		echo("You must leave.");
	}
	echo("</p>");
	
?>

<!doctype html>
<html>
	<head>
		<title>Php page</title>
	</head>
	<body>
		
	</body>
</html>