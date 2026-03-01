<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<h1>All cars:</h1>

<c:forEach var="car" items="${requestScope.cars}">
    <li>
        <a href="${pageContext.request.contextPath}/cars?carId=${car.id}">
            ${car.id} - ${car.status}
        </a>
    </li>
</c:forEach>

<c:if test="${empty requestScope.cars}">
    <p>No cars found</p>
</c:if>
</body>
</html>