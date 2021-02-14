<?php
	class Category{
		private $conn;
		private $table = 'categories';

		public $id;
		public $name;
		public $create_at;

		function __construct($db){
			$this->conn = $db;
		}

		public function read(){
			$query = 'SELECT * ';
			$query .= 'FROM '.$this->table;
			$query .= ' ORDER BY create_at DESC';
			$stmt = $this->conn->prepare($query);
			$stmt->execute();

			return $stmt;
		}
		
		public function read_single(){
			$query = 'SELECT * ';
			$query .= 'FROM '.$this->table.' ';
			$query .= 'WHERE id = ? LIMIT 1';

			$stmt = $this->conn->prepare($query);
			$stmt->bindParam(1, $this->id);
			$stmt->execute();
			$row = $stmt->fetch(PDO::FETCH_ASSOC);
			
			$this->name = $row['name'];
			$this->create_at = $row['create_at'];
		}

		public function create(){
			$query = 'INSERT INTO '.$this->table.' SET ';
			$query .= 'name = :name';
			
			$stmt = $this->conn->prepare($query);
			$this->name = htmlspecialchars(strip_tags($this->name));			
			$stmt->bindParam(':name', $this->name);

			if($stmt->execute()){
				return true;
			}
			printf("Error %s.\n",$stmt->error);
			return false;
		}

		public function update(){
			$query = 'UPDATE '.$this->table.' SET ';
			$query .= 'name = :name ';
			$query .= 'WHERE id = :id';
			
			$stmt = $this->conn->prepare($query);
			$this->name = htmlspecialchars(strip_tags($this->name));
			$this->id = htmlspecialchars(strip_tags($this->id));
			
			$stmt->bindParam(':name', $this->name);
			$stmt->bindParam(':id', $this->id);

			if($stmt->execute()){
				return true;
			}
			printf("Error %s.\n",$stmt->error);
			return false;
		}

		public function delete(){
			$query = "DELETE FROM ".$this->table." WHERE id = :id";
			$stmt = $this->conn->prepare($query);
			$this->id = htmlspecialchars(strip_tags($this->id));
			$stmt->bindParam(":id", $this->id);
			if($stmt->execute()){
				return true;
			}
			printf("Error %s.\n",$stmt->error);
			return false;
		}
	}

?>