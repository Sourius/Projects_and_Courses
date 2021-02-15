<?php
	//headers
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json");

	include_once('../../config/Database.php');
	include_once('../../models/Category.php');

	//instantiate db & connect
	$database = new Database();
	$db = $database->connect();

	//instantiate category object
	$category = new Category($db);

	//get id from url
	$category->id = isset($_GET['id']) ? $_GET['id'] : die();
	
	//get category
	$category->read_single();

	//create array
	$category_arr = array(
		'id' => $category->id,
		'name' => $category->name,
		'created_at' => $category->created_at,
	);

	//convert to json and print
	print_r(json_encode($category_arr));
?>