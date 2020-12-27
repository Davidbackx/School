<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="Shopping Cart"/>
    </jsp:include>
    <main>
            <c:choose>
                <c:when test="${not empty cart}">
                    <table>
                        <tr>
                            <th>Product Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Remove from Cart</th>
                        </tr>

                        <c:forEach var="product" items="${cart}">
                            <tr>
                                <td>${product.productId}</td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.price}</td>
                                <td><a href="Controller?command=removeFromCart&productId=${product.productId}">Remove From
                                    Cart</a></td>
                            </tr>
                        </c:forEach>

                        <caption>Shopping Cart</caption>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>error</p>
                    <p>No products in your shopping cart</p>
                </c:otherwise>
            </c:choose>
    </main>
    <footer>
        &copy; Webontwikkeling 2, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>