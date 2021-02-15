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

	//read categories
	$result = $category->read();
	
	//get row count
	$num = $result->rowCount();
	
	//check if there are categories
	if($num > 0){
		$category_arr = array();
		$category_arr['data'] = array();
		
		while($row = $result->fetch(PDO::FETCH_ASSOC)){
			extract($row);
			$category_item = array(
				'id' => $id,
				'name' => $name,
				'created_at' => $created_at
			);

			//push to data
			array_push($category_arr['data'], $category_item);			
		}

		//convert to json & print
		echo json_encode($category_arr);
	}
	else{
		//there are no categories
		echo json_encode(array('message' => 'No categories found.'));
	}
?>