<?php

	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json");

	include_once('../core/initialize.php');

	$category = new Category($db);
	$category->id = isset($_GET['id']) ? $_GET['id'] : die();
	$category->read_single();

	$category_arr = array(
		'id' => $category->id,
		'name' => $category->name,
		'create_at' => $category->create_at,
	);
	print_r(json_encode($category_arr));
?>