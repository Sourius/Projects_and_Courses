<?php
	error_reporting(E_ERROR | E_WARNING | E_PARSE);
	
	$error = "";
	$success_msg = "";
	
	if($_POST){	
		$email = test_input($_POST["email"]);
		$subject = test_input($_POST["subject"]);
		$message = test_input($_POST["mail-body"]);
		
		$email = test_input($_POST["email"]);
		if(empty($email)){
			$error .= "Email field is required";
		}
		else if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
			$error .= "Invalid email format<br>";
		}
		if(empty($subject)){
			$error .= "Subject field is empty<br>";
		}
		if(empty($message)){
			$error .= "Content box is empty";
		}
		if(!empty($error)){
			$error = "<div class='alert alert-danger' role='alert'><strong>".$error."</strong></div>";
		}
		else {
			$emailTo = "example@example.com";
			$headers = "From: ".$email;
			
			if(mail($emailTo, $subject, $message, $headers)){
				$success_msg = "<div class='alert alert-success' role='alert'>Your message was sent. We'll get back to you ASAP.</div>";
			}
			else{
				$error = "<div class='alert alert-danger' role='alert'><strong>The message couldn't be sent. Try it again later.</strong></div>";
			}
		}
	}
	
	function test_input($data) {
		$data = trim($data);
		$data = stripslashes($data);
		$data = htmlspecialchars($data);
		return $data;
	}
?>

<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		<title>Form Validation!</title>
		<style type="text/css">
			textarea{
				height:10em;
			}
			
			#error-msg{
				margin-top:1em;
			}
			
			.hidden{
				display:none;
			}
			
		</style>
		
	</head>
	
	<body>
		<div class="container justify-content-center">
			<h1>Get in touch!</h1>
			<div id="success-alert"><?echo $success_msg;?></div>
			
			<?php /*  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" */?>
			
			<form method="post">
				<fieldset class="form-group">
					<label for="email">Email address</label>
					<input class="form-control" type="email" id="email" name="email" required />
					<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</fieldset>
				
				<fieldset class="form-group">
					<label for="subject">Subject</label>
					<input class="form-control" type="text" id="subject" name="subject" />
				</fieldset>
				
				<fieldset class="form-group">
					<label for="mail-body">What would you like to ask us?</label>
					<textarea class="form-control" id="mail-body" name="mail-body"></textarea>
				</fieldset>
				
				<button id="submit" type="submit" class="btn btn-primary">Submit</button>
			</form>
			
			<div id="error-msg"><? echo $error;?></div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

		<script>
			jQuery("form").submit(function(e){
				var error="";
				
				if(jQuery("#subject").html() == ""){
					error += "<p>The subject field is required.";
				}
				
				if(jQuery("#mail-body").html() == ""){
					error += "<p>The message field is required.";
				}
				
				if(error == ""){
					return true;					
				}
				else {
					jQuery("#error-msg").html("<div class='alert alert-danger' role='alert'><strong>"+error+"</strong></div>");
					return false;
				}
			});
			
		</script>
	</body>
</html>
