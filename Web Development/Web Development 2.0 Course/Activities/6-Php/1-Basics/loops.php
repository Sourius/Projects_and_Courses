<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);

	$colors = array("red","green","blue","yellow","orange");
	
	echo("<p>");
	for($i = 0; $i < sizeof($colors); $i++){
		echo $colors[$i]."<br>";
	}
	echo("</p>");
	
	echo("<p>");
	foreach($colors as $index => $color){
		echo "Colour nº ".($index+1)." is ".$color."<br>";
	}
	echo("</p>");
	
	$i = 1;
	echo("<p>");
	while($i <= 10){
		echo((5*$i)."<br>");
		$i++;
	}
	echo("</p>");
	
	$i = 0;
	echo("<p>");
	while($i < sizeof($colors)){
		echo $colors[$i]."<br>";
		$i++;
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