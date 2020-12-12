<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);

	$message = "<p>Hello World!</p>";
	echo $message;
	
	$string1 = "<p>This is the first part";
	$string2 = "of a sentence.</p>";
	
	echo "$string1 $string2\n";
	echo $string1." ".$string2."\n";
	
	$num = 10;
	$calc = $num + 2/10 * 2;
	echo $calc;
	
	$bval = true;
	echo "<p>This statement is true? ".$bval."</p>";
	
	$varname = "message";
	echo $$varname;
?>

<!doctype html>
<html>
	<head>
		<title>Php page</title>
	</head>
	<body>
		
	</body>
</html>