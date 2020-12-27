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
    <jsp:include page="header.jsp"/>
    <main>
        
        <c:choose>
            <c:when test="${empty products}">
                <p>error</p>

                <p>No products to show</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>Product Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Add to Cart</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.productId}</td>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td><a href="Controller?command=addToCart&productId=${product.productId}">Add to Cart</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <caption>Product Overview</caption>
                </table>
            </c:otherwise>
        </c:choose>
    </main>
    <footer>
        &copy; Webontwikkeling 2, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>