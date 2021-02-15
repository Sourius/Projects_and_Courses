<?php
	class Database{
		//db params
		private $host = "localhost";
		private $db_name = "test";
		private $username = "root";
		private $password = "";
		private $connection = null;

		//db connect
		public function connect(){
			$this->connection = null;
			try{
				$this->connection = new PDO('mysql:host='.$this->host.';dbname='.$this->db_name.';charset=utf8', $this->username, $this->password);
				$this->connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			}
			catch(PDOException $e){
				echo "Connection error: ".$e->getMessage();
			}
			return $this->connection;
		}

	}
?>