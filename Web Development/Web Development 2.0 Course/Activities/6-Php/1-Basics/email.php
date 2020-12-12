<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);
	$emailTo = "example@gmail.com";
	$subject = "Php mail";
	$body = "I think you're great!";
	$headers = "From: example@gmail.com";
	
	if(mail($emailTo, $subject, $body, $headers)){
		echo "Success";
	} else {
		echo "Fail";
	}
?>

<!doctype html>
<html>
	<head>
		<title>Php page</title>
	</head>
	<body>
		<form method="post">
			
		</form>
	</body>
</html>