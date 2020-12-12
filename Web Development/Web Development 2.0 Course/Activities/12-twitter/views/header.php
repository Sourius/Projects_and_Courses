<!doctype html>
<html lang="en" class="h-100">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<link rel="stylesheet" href="./styles.css" />

		<title>Hello, world!</title>
	</head>

	<body class="d-flex flex-column h-100">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="./">Twitter</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active">
						<a class="nav-link" href="?page=timeline">Timeline <span class="sr-only">(current)</span></a>
					</li>
      
					<li class="nav-item">
						<a class="nav-link" href="?page=yourtweets">Tweets</a>
					</li>
     
					<li class="nav-item">
						<a class="nav-link" href="?page=publicprofiles">Profiles</a>
					</li>
				</ul>
    
				<div class="form-inline pull-xs-right">
					<?php if(array_key_exists('id',$_SESSION)){ ?>
						<a class="btn btn-outline-success my-2 my-sm-0" href="?function=logout">Logout</a>
					<?php } else { ?>
						<button class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#myModal">Login/SignUp</button>
					<?php } ?>
				</div>
			</div>
		</nav>