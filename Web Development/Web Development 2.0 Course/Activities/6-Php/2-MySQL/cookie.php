<?php
	error_reporting(E_ERROR | E_PARSE);
	//setcookie("customerId","1234",time() + 60 * 60 * 24); --> create
	setcookie("customerId","",time() - 60 * 60 * 24); //-> delete
	$_COOKIE['customerId'] = 'test'; //-> change cookie value
	echo($_COOKIE["customerId"]);
?>

<form method = "post">
    <input name="email" type="text" placeholder="Email address">
    <input name="password" type="password" placeholder="Password">
    <input type="submit" value = "Sign up">
</form>