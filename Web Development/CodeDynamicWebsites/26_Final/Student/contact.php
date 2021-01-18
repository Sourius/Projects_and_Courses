<?php
	define("TITLE", "Contact Us | Franklin's Fine Dining");
	include("includes/header.php");

	
?>

<div id = "contact">
	<hr>
	<h1>Get in touch with us!</h1>
	
	<?php
		// check for header injections
		function has_header_injection($str){
			return preg_match("/[\r\n]/", $str);
		}

		if(isset($_POST['contact_submit'])){
			$name = trim($_POST['name']);
			$email = trim($_POST['email']);
			$msg = $_POST['message'];

			// check if name and email have header injections
			if(has_header_injection($name) || has_header_injection($email)){
				die();
			}
			if(!$name || !$email || !$msg){
				echo '<h4 class="error">All fields required</h4><a href="contact.php" class="button block">Go back and try again</a>';
				exit;
			}

			$to = "your@email.com";
			$subject = "$name sent you a message via contact form";
			$message = "Name: $name\r\n";
			$message .= "Email: $email\r\n";
			$message .= "Message:\r\n$msg";

			if(isset($_POST['subscribe']) && $_POST['subscribe'] === "Subscribe"){
				$message .= "\r\nPlease add $email to mailing list.\r\n";
			}

			$message = wordwrap($message, 72);
			$headers = "MIME-Version: 1.0\r\n";
			$headers .= "Content-type: text/plain; charset-iso-8859-1\r\n";
			$headers .= "From: $name <$email>\r\n";
			$headers .= "X-Priority: 1\r\n";
			$headers .= "X-MSMail-Priority: High\r\n\r\n";

			mail($to, $subject, $message, $headers);
		
	?>
			<h5>Thanks for contacting Franklin's</h5>
			<p>Please allow 24 hours for a response</p>
			<p><a href="/final">&laquo: Go to Home Page</a></p>

	<?php } else { ?>

		<form method="post" action="" id="contact-form">
			<label for="name">Your name</label>
			<input type="text" id="name" name="name">

			<label for="enail">Your email</label>
			<input type="email" id="email" name="email">

			<label for="message">and your message</label>
			<textarea id="message" name="message"></textarea>

			<input type="checkbox" id="subscribe" name="subscribe">
			<label for="subscribe">Subscribe to newsletter</label>

			<input type="submit" class="button next" name="contact_submit" value="Send Message">
		</form>

	<?php } ?>
</div>

<?php include("includes/footer.php"); ?>