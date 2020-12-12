<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);
	
	if($_GET["name"]){
		echo("<p> Hi there ".$_GET["name"]."</p>");
	}
	$value = $_GET["number"];
	
	if(is_numeric($value) && $value > 0 && $value == round($value, 0)){
		$prime = true;
		
		echo($value);
		
		if($value == 2){
			$prime = false;
		}
		
		for($i = 2; $i < $value && $prime; $i++){
			if(($value % $i) == 0){
				$prime = false;
			}
		}
		
		if($prime){
			echo (" is a prime number."."<br>");
		}else{
			echo (" is not a prime number."."<br>");
		}
	}
	
?>

<!doctype html>
<html>
	<head>
		<title>Php page</title>
	</head>
	<body>
		<form method="get">
			<p>What's your name?</p>
			<input name="name" type="text"/>
			<p>Is it a prime number?</p>
			<p><input name="number" type="text"/></p>
			<p><input value="GO" type="submit"/></p>
		</form>
	</body>
</html>