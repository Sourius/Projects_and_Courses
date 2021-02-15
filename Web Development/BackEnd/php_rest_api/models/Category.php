<?php
	class Category{
		//db properties
		private $conn;
		private $table = 'categories';

		//properties
		public $id;
		public $name;
		public $created_at;

		//constructor with db
		function __construct($db){
			$this->conn = $db;
		}

		//get categories
		public function read(){
			//query
			$query = 'SELECT * ';
			$query .= 'FROM '.$this->table;
			$query .= ' ORDER BY created_at DESC';

			//prepare statement
			$stmt = $this->conn->prepare($query);

			//execute query
			$stmt->execute();

			return $stmt;
		}
		
		//get single category
		public function read_single(){
			$query = 'SELECT * ';
			$query .= 'FROM '.$this->table.' ';
			$query .= 'WHERE id = ? LIMIT 1';

			//prepare statement
			$stmt = $this->conn->prepare($query);

			//bind parameter
			$stmt->bindParam(1, $this->id);

			//execute query
			$stmt->execute();
			$row = $stmt->fetch(PDO::FETCH_ASSOC);
			
			//set properties
			$this->name = $row['name'];
			$this->created_at = $row['created_at'];
		}

		//create category
		public function create(){
			//query
			$query = 'INSERT INTO '.$this->table.' SET ';
			$query .= 'name = :name';
			
			//prepare statement
			$stmt = $this->conn->prepare($query);

			//clean data
			$this->name = htmlspecialchars(strip_tags($this->name));	
			
			//bind parameter
			$stmt->bindParam(':name', $this->name);

			//execute query
			if($stmt->execute()){
				return true;
			}

			//print error
			printf("Error %s.\n",$stmt->error);
			return false;
		}
		
		//update category
		public function update(){
			$query = 'UPDATE '.$this->table.' SET ';
			$query .= 'name = :name ';
			$query .= 'WHERE id = :id';
			
			//prepare statement
			$stmt = $this->conn->prepare($query);

			//clean data
			$this->name = htmlspecialchars(strip_tags($this->name));
			$this->id = htmlspecialchars(strip_tags($this->id));
			
			//bind parameters
			$stmt->bindParam(':name', $this->name);
			$stmt->bindParam(':id', $this->id);

			//execute query
			if($stmt->execute()){
				return true;
			}

			//print error
			printf("Error %s.\n",$stmt->error);
			return false;
		}

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