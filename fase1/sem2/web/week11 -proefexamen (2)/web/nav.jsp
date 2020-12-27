<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="nav">
    <ul>
        <li><a href="Servlet?command=home">Home</a></li>
        <li><a href="Servlet?command=overview">Overview</a></li>
        <li><a href="Servlet?command=bikeadd">Add bike</a></li>
        <c:if test="${nieuwsbriefOn eq 'on'}"><li><a href="nieuwsbrief.jsp">Nieuwsbrief</a></li></c:if>
    </ul>
</nav>