<?php
	//error_reporting(E_ERROR | E_PARSE |E_WARNING);
	error_reporting(E_ALL);
    session_start();
   
   $error = "";    

    if (array_key_exists("logout", $_GET)) {
        unset($_SESSION);
        setcookie("id", "", time() - 60*60);
        $_COOKIE["id"] = "";  
    }
	else if((array_key_exists("id", $_SESSION) AND $_SESSION['id']) OR (array_key_exists("id", $_COOKIE) AND $_COOKIE['id'])) {
        header("Location: loggedinpage.php");
    }

    if (array_key_exists("submit", $_POST)) {
        $link = mysqli_connect("localhost", "root", "", "test");
        
		if (mysqli_connect_error()) {
            die ("Database Connection Error");
        }

        if (!$_POST['email']) {
            $error .= "An email address is required<br>";
        } 
        if (!$_POST['password']) {
            $error .= "A password is required<br>";
        } 
        
        if ($error != "") {
            $error = "<p class='alert alert-danger' role='alert'>There were error(s) in your form:<br>".$error."</p>";
        } 
		else {
            if ($_POST['signUp'] == '1') {
                $query = "SELECT id FROM `users` WHERE email = '".mysqli_real_escape_string($link, $_POST['email'])."' LIMIT 1";

                $result = mysqli_query($link, $query);
                if (mysqli_num_rows($result) > 0) {
                    $error = "That email address is taken.";
                }
				else {
                    $query = "INSERT INTO `users` (`email`, `password`) VALUES ('".mysqli_real_escape_string($link, $_POST['email'])."', '".mysqli_real_escape_string($link, $_POST['password'])."')";

                    if (!mysqli_query($link, $query)) {
                        $error = "<p>Could not sign you up - please try again later.</p>";
                    } 
					else {
                        $query = "UPDATE `users` SET password = '".md5(md5(mysqli_insert_id($link)).$_POST['password'])."' WHERE id = ".mysqli_insert_id($link)." LIMIT 1";
						
						mysqli_query($link, $query);
                        $_SESSION['id'] = mysqli_insert_id($link);

                        if ($_POST['stayLoggedIn'] == '1') {
                            setcookie("id", mysqli_insert_id($link), time() + 60*60*24*365);
                        } 
                        header("Location: loggedinpage.php");
                    }
                } 
            } 
			else {
				$query = "SELECT * FROM `users` WHERE email = '".mysqli_real_escape_string($link, $_POST['email'])."'";
				
				$result = mysqli_query($link, $query);
				$row = mysqli_fetch_array($result);
				
				if(isset($row)) {
					$hashedPassword = md5(md5($row['id']).$_POST['password']);
					if ($hashedPassword == $row['password']) {
						$_SESSION['id'] = $row['id'];
						if ($_POST['stayLoggedIn'] == '1') {
							setcookie("id", $row['id'], time() + 60*60*24*365);
						} 
						header("Location: loggedinpage.php");
					} 
					else {
						$error = "That email/password combination could not be found.";
					}
				} 
				else {
					$error = "That email/password combination could not be found.";
				}
			}
        }
    }
?>

<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

		<!-- Custom CSS -->
		<link rel="stylesheet" href="./css/custom-style.css">

		<title>Sign In Page</title>
	</head>

	<body>
		<div class="container" id="main-content">
			<h1>Secret Diary</h1>
			
			<p><strong>Store your thoughts permanently and securely</strong></p>
			
			<div class="container" id="error">
				<?php 
					if($error){
						echo $error;
					}
				 ?>
			</div>
				
			<div class="container" id="signup-form">
				<p>Enter your email and password for Sign up</p>
				
				<form method="post">
					<fieldset class="form-group">
						<input type="email" class="form-control" name="email" placeholder="Your Email"></input>
					</fieldset>
					
					<fieldset class="form-group">
						<input type="password" class="form-control" name="password" placeholder="Password"></input>
					</fieldset>
					
					<fieldset class="form-check">
						<input class="form-check-input" type="checkbox"  name="stayLoggedIn" value=1></input>
						 <label class="form-check-label" for="stayLoggedIn">Stay Logged in</label>
					</fieldset>
					
					<fieldset class="form-group-inline">	
						<input type="hidden" name="signUp" value="1"></input>
						
						<input type="submit" class="btn btn-primary col-12" name="submit" value="Sign up"></input>
						
						<a id="show-login-form" class="btn btn-success mt-3 col-12">Log in</a>
					</fieldset>
				</form>
			</div>
			
			
			
			<div class="container" id="login-form">
				<p>Enter your username and password for Log in.</p>
				<form method="post">
					<fieldset class="form-group">
						<input type="email" class="form-control" name="email" placeholder="Your Email"></input>
					</fieldset>
					
					<fieldset class="form-group">
						<input type="password" class="form-control" name="password" placeholder="Password"></input>
					</fieldset>
					
					<fieldset class="form-check">
						<input class="form-check-input" type="checkbox"  name="stayLoggedIn" value=1></input>
						 <label class="form-check-label" for="stayLoggedIn">Stay Logged in</label>
					</fieldset>
					
					<fieldset class="form-group">
						<input type="hidden" name="signUp" value="0"></input>
						
						<input type="submit" class="col-12 btn btn-primary" name="submit" value="Log in"></input>
						
						<a id="show-signup-form" class="col-12 btn btn-success mt-3">Sign up</a>
					</fieldset>
				</form>
			</div>
		</div>
		
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		
		<!-- Custom scripts -->
		<script src="./js/signin.js"></script>
	</body>
</html>
