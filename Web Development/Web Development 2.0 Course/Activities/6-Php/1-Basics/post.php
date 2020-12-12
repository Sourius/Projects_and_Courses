<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);
	
	if($_POST){
		$colour = $_POST["colour"];
		$colours = array("red","green","blue","yellow");
		
		foreach($colours as $aux){
			if($colour == $aux){
				$isKnown = true;
			}
		}
		
		if($isKnown){
			echo "<p>It's one of the expected colours.</p>";
		}
		else{
			echo "<p>It's none of the expected colours.</p>";
		}
	}
	/*
	if($_POST["name"]){
		echo("<p> Hi there ".$_POST["name"]."</p>");
	}
	$value = $_POST["number"];
	
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
	*/
?>

<!doctype html>
<html>
	<head>
		<title>Php page</title>
	</head>
	<body>
		<form method="post">
			<p>Write a colour's name?</p>
			<input name="colour" type="text"/>
			<p><input value="GO" type="submit"/></p>
		</form>
	</body>
</html>