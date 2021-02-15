<?php
	//headers
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json");
	header("Access-Control-Allow-Methods: DELETE");
	header("Access-Control-Allow-Headers: Access-Control-Allow-Headers, Content-Type, Access-Control-Allow-Methods, Authorization, X-Requested-With");

	include_once('../../config/Database.php');
	include_once('../../models/Category.php');

	//instantiate db & connect
	$database = new Database();
	$db = $database->connect();

	//instantiate category object
	$category = new Category($db);
	
	//get raw posted object
	$data = json_decode(file_get_contents("php://input"));
	$category->id = $data->id;

	//delete category
	if($category->delete()){
		echo json_encode(array("message"=>"Category deleted"));
	}
	else{
		echo json_encode(array("message"=>"Category not deleted"));
	}
?>