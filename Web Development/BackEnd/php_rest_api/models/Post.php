<?php

class Post{
	//db properties
	private $conn;
	private $table = 'posts';

	//post properties
	public $id;
	public $category_id;
	public $category_name;
	public $title;
	public $body;
	public $author;
	public $created_at;

	//constructor
	function __construct($db){
		$this->conn = $db;
	}

	//get posts
	public function read(){
		//query
		$query = 'SELECT ';
		$query .= 'c.name as category_name, ';
		$query .= 'p.id, p.category_id, ';
		$query .= 'p.title, ';
		$query .= 'p.body, ';
		$query .= 'p.author, ';
		$query .= 'p.created_at ';
		$query .= 'FROM '.$this->table.' p ';
		$query .= 'LEFT JOIN ';
		$query .= 'categories c ON p.category_id = c.id ';
		$query .= 'ORDER BY p.created_at DESC';

		//prepare statement
		$stmt = $this->conn->prepare($query);
		
		//execute query
		$stmt->execute();

		return $stmt;
	}
	
	//get single post
	public function read_single(){
		//query
		$query = 'SELECT ';
		$query .= 'c.name as category_name, ';
		$query .= 'p.id, p.category_id, ';
		$query .= 'p.title, ';
		$query .= 'p.body, ';
		$query .= 'p.author, ';
		$query .= 'p.created_at ';
		$query .= 'FROM '.$this->table.' p ';
		$query .= 'LEFT JOIN ';
		$query .= 'categories c ON p.category_id = c.id ';
		$query .= 'WHERE p.id = ? LIMIT 1';

		//prepare statement
		$stmt = $this->conn->prepare($query);
		
		//bind parameter
		$stmt->bindParam(1, $this->id);
		
		//execute query
		$stmt->execute();
		$row = $stmt->fetch(PDO::FETCH_ASSOC);
		
		//set properties
		$this->title = $row['title'];
		$this->body = $row['body'];
		$this->author = $row['author'];
		$this->category_id = $row['category_id'];
		$this->category_name = $row['category_name'];
	}

	//create post
	public function create(){
		//query
		$query = 'INSERT INTO '.$this->table.' SET ';
		$query .= 'title = :title, ';
		$query .= 'body = :body, ';
		$query .= 'author = :author, ';
		$query .= 'category_id = :category_id';
		
		//prepare statement
		$stmt = $this->conn->prepare($query);

		//clean data
		$this->title = htmlspecialchars(strip_tags($this->title));
		$this->body = htmlspecialchars(strip_tags($this->body));
		$this->author = htmlspecialchars(strip_tags($this->author));
		$this->category_id = htmlspecialchars(strip_tags($this->category_id));
		
		//bind data
		$stmt->bindParam(':title', $this->title);
		$stmt->bindParam(':body', $this->body);
		$stmt->bindParam(':author', $this->author);
		$stmt->bindParam(':category_id', $this->category_id);

		//execute query
		if($stmt->execute()){
			return true;
		}

		//print error
		printf("Error %s.\n",$stmt->error);
		return false;
	}

	//update post
	public function update(){
		//query
		$query = 'UPDATE '.$this->table.' SET ';
		$query .= 'title = :title, ';
		$query .= 'body = :body, ';
		$query .= 'author = :author, ';
		$query .= 'category_id = :category_id ';
		$query .= 'WHERE id = :id';
		
		//prepare statement
		$stmt = $this->conn->prepare($query);

		//clean data
		$this->title = htmlspecialchars(strip_tags($this->title));
		$this->body = htmlspecialchars(strip_tags($this->body));
		$this->author = htmlspecialchars(strip_tags($this->author));
		$this->category_id = htmlspecialchars(strip_tags($this->category_id));
		$this->id = htmlspecialchars(strip_tags($this->id));
		
		//bind parameters
		$stmt->bindParam(':title', $this->title);
		$stmt->bindParam(':body', $this->body);
		$stmt->bindParam(':author', $this->author);
		$stmt->bindParam(':category_id', $this->category_id);
		$stmt->bindParam(':id', $this->id);

		//execute query
		if($stmt->execute()){
			return true;
		}

		//print error
		printf("Error %s.\n",$stmt->error);
		return false;
	}

	//delete post
	public function delete(){
		//query
		$query = "DELETE FROM ".$this->table." WHERE id = :id";

		//prepare statement
		$stmt = $this->conn->prepare($query);

		//clean data
		$this->id = htmlspecialchars(strip_tags($this->id));

		//bind parameter
		$stmt->bindParam(":id", $this->id);

		//execute query
		if($stmt->execute()){
			return true;
		}

		//print error
		printf("Error %s.\n",$stmt->error);
		return false;
	}
}


?>