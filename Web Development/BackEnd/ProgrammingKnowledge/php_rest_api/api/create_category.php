<?php
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json");
	header("Access-Control-Allow-Methods: POST");
	header("Access-Control-Allow-Headers: Access-Control-Allow-Headers, Content-Type, Access-Control-Allow-Methods, Authorization,X-Requested-With");

	include_once('../core/initialize.php');

	$category = new Category($db);

	$data = json_decode(file_get_contents("php://input"));

	$category->name = $data->name;

	if($category->create()){
		echo json_encode(array("message"=>"Category created"));
	}
	else{
		echo json_encode(array("message"=>"Category not created"));
	}
?>