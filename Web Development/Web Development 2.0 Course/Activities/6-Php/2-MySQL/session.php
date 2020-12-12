<?php
	error_reporting(E_ERROR | E_PARSE);
	session_start();
	
	if($_SESSION['email']){
		echo '<p>You are logged in as '.$_SESSION['email'].'</p>';
	}
	else{
		header("Location: index.php");
	}
?>