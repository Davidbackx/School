<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gevonden</title>
<link rel="stylesheet" href="css/sample.css">
</head>
<body>
<jsp:include page="header.jsp">
	<jsp:param name="actual" value="gevonden"/>
</jsp:include>
<main>
<p id="boodschap">Je vroeg naar volgende gegevens: ${student.format()}</p>
</main>

</body>
</html>