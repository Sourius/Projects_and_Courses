<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);

	$myArray = array("Red","Green","Blue");
	echo $myArray;
	
	print_r($myArray);
	echo "<p>".$myArray[1]."</p>";
	
	echo "<p>";
	$anoterArray[0] = "pizza";
	$anoterArray[1] = "yoghurt";
	$anoterArray[5] = "sandwitch";
	$anoterArray["fruit"] = "watermelon";
	print_r($anoterArray);
	echo "</p>";
	
	echo "<p>";
	$newArray = array("France" => "French", "USA" => "English", "Germany"=> "German");
	print_r($newArray);
	echo "</p>";
	
	echo "<p>";
	unset($newArray["France"]);
	print_r($newArray);
	echo "</p>";
	
	echo "<p>";
	echo sizeof($newArray);
	echo "</p>";
	echo "<br/>";
?>

<!doctype html>
<html>
	<head>
		<title>Php page</title>
	</head>
	<body>
		
	</body>
</html>