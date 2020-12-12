<?php
	if (isset($_POST)){
		if(	array_key_exists('to', $_POST) and 
			array_key_exists('from', $_POST) and 
			array_key_exists('subject', $_POST) and 
			array_key_exists('message', $_POST){
			
			//json variable
			$result = array();
			
			//get mail details
			$to = $_POST['to'];
			$subject = $_POST['subject'];
			$message = $_POST['message'];
			$from = $_POST['from'];
			$headers = "From: ".$from."\r\n"
						."Reply-To: ".$from."\r\n"
						."X-Mailer: PHP/".phpversion();
			//send mail
			$result['success'] = mail($to, $subject, $message, $headers);
			
			if(array_key_exists('callback', $_POST)){
				header('Content-Type: text/javascript; charset=utf8');
				header('Access-Control-Allow-Origin: http://www.example.com/');
				header('Access-Control-Max-Age: 3628800');
				header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');

				$callback = $_POST['callback'];
				echo $callback.'('.json_encode($result).');';

			}
			else{
				// normal JSON string
				header('Content-Type: application/json; charset=utf8');
				echo json_encode($result);
			}
		}
	}
?>