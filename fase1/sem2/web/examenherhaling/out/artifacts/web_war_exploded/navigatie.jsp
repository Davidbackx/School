<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>
        <img src="images/bikesBanner.png" alt="banner My Bikes">
    </h1>

    <nav class="nav">
        <ul>
            <li><a href="Servlet?command=home">Home</a></li>
            <li><a href="Servlet?command=overview">Overview</a></li>
            <li><a href="Servlet?command=bikeAdd">Add bike</a></li>
            <c:if test="${nieuwsbriefOn eq 'on'}"><li><a href="Servlet?command=nieuwsbrief">Nieuwsbrief</a></li></c:if>
        </ul>
    </nav>
</header>