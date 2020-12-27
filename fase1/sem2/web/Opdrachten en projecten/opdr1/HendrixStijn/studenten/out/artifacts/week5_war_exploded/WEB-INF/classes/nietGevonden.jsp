<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/sample.css">
<title>Niet gevonden</title>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="actual" value="nietGevonden"/>
	</jsp:include>
	<main>
	<p id="foutboodschap">Helaas, de student waarnaar je vraagt is niet gevonden. </p>
	</main>

</body>
</html>