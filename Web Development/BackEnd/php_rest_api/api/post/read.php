<?php
	//headers
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json");

	include_once('../../config/Database.php');
	include_once('../../models/Post.php');

	//instantiate db & connect
	$database = new Database();
	$db = $database->connect();

	//instantiate post object
	$post = new Post($db);

	//read posts
	$result = $post->read();
	
	//get row count
	$num = $result->rowCount();
	
	//check if there are posts
	if($num > 0){
		//post array
		$post_arr = array();
		$post_arr['data'] = array();
		
		while($row = $result->fetch(PDO::FETCH_ASSOC)){
			extract($row);
			$post_item = array(
				'id' => $id,
				'title' => $title,
				'body' => html_entity_decode($body),
				'author' => $author,
				'category_id' => $category_id,
				'category_name' => $category_name
			);

			//push to data
			array_push($post_arr['data'], $post_item);		
		}
		
		//convert to json & print
		echo json_encode($post_arr);
	}
	else{
		//there are no posts
		echo json_encode(array('message' => 'No posts found.'));
	}

?>