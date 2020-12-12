<?php 
	error_reporting(E_ERROR | E_PARSE |E_WARNING);
	session_start();
	
	if(array_key_exists("id",$_COOKIE)){
		$SESSION['id'] = $_COOKIE['id'];
	}
	
	if(array_key_exists("id",$_SESSION)){
		echo "Logged In! <a href='index.php?logout=1'>Log Out</a>";
	}
	else{
		header("Location: index.php");
	}
?>