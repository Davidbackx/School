<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookies - Show a Quote</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="index" value="actual"/>
    </jsp:include>
    <main>
        <p>Lorizzle ipsizzle dolor sit pizzle, boofron adipiscing elit. Nullizzle sapien velizzle, aliquet volutpizzle,
            suscipit gizzle, pimpin' vizzle, arcu. Check it out egizzle tortor. Yippiyo erizzle. Shiznit izzle check it
            out dapibus crackalackin tempizzle you son of a bizzle. Maurizzle pellentesque nibh et my shizz. Vestibulum
            izzle tortizzle. We gonna chung you son of a bizzle izzle nisi. In owned black platea dictumst. Donec
            rizzle. Away dope shizzlin dizzle, pretium cool, mattis shizzle my nizzle crocodizzle, eleifend vitae, nunc.
            Go to hizzle suscipizzle. Daahng dawg semper velit sizzle bling bling.</p>

        <form>
            <p>Do you want to see a quote?</p>
            <p>
                <input type="radio" value="yes" name="command" id="quoteYes">
                <label for="quoteYes">Yes</label>
                <input type="radio" value="no" name="command" id="quoteNo">
                <label for="quoteNo">No</label>
            </p>
            <p><input type="submit" value="Send" id="submit"></p>
        </form>

        <c:if test="${requestCookie == 'true'}">
            <blockquote cite="Jim Hightower">
                Even a dead fish can go with the flow.
            </blockquote>
        </c:if>
        <p>Request cookie was ${requestCookie}.</p>
    </main>
</div>

</body>
</html>