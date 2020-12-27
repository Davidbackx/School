<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="nl">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title>Bikes</title>
	<link rel="stylesheet" media="all" href="css/reset.css">
	<link rel="stylesheet" media="all" href="css/project.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
</head>

<body>
	<header>
		<h1>
			<img src="images/bikesBanner.png" alt="banner My Bikes">
		</h1>

		<jsp:include page="nav.jsp"/>
	</header>

	<div class="container">
		<main>
			<section>
				<h2>My Bikes</h2>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias at blanditiis enim id iure laborum
					maiores molestiae necessitatibus nemo, numquam quae quia quo repudiandae sapiente sit unde ut. Aut,
					exercitationem?</p>

			</section>
			<a href="Servlet?command=history">Show my history</a>
			<section>
			<h2>Nieuwsbrief</h2>
				<form method="GET" action="Servlet" novalidate>
					<input type="hidden"  name="command" value="submitNieuwsbrief">
					<p>
						<input type="checkbox" name="nieuwsbrief" ${nieuwsbriefOn eq 'on' ? " checked='checked'" : ""}>Ja, ik wil de nieuwsbrief ontvangen <br>
					</p>
					<p>
						<input type="submit" value="Submit" id="submit">
					</p>
				</form>
			</section>
		</main>

	</div>
</body>
</html>
