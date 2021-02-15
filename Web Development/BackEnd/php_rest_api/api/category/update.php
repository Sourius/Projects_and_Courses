<?php
	//headers
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json");
	header("Access-Control-Allow-Methods: PUT");
	header("Access-Control-Allow-Headers: Access-Control-Allow-Headers, Content-Type, Access-Control-Allow-Methods, Authorization, X-Requested-With");

	include_once('../../config/Database.php');
	include_once('../../models/Category.php');

	//instantiate db & connect
	$database = new Database();
	$db = $database->connect();

	//instantiate category object
	$category = new Category($db);

	//get raw posted data
	$data = json_decode(file_get_contents("php://input"));

	$category->id = $data->id;
	$category->name = $data->name;

	//update category
	if($category->update()){
		echo json_encode(array("message"=>"Category updated"));
	}
	else{
		echo json_encode(array("message"=>"Category not updated"));
	}
?>