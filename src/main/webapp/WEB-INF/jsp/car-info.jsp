<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car Information</title>
</head>
<body>

<h1>Car Information</h1>

<p>Brand: ${requestScope.car.brand}</p>
<p>Model: ${requestScope.car.model}</p>
<p>Year: ${requestScope.car.productionYear}</p>
<p>Price per day: ${requestScope.car.pricePerDay}</p>
<p>Status: ${requestScope.car.status}</p>
<p>Car number: ${requestScope.car.carNumber}</p>
<br>

<c:choose>
    <c:when test="${requestScope.car.status == 'AVAILABLE'}">
        <form action="${pageContext.request.contextPath}/cars/book" method="post">
            <input type="hidden" name="carId" value="${requestScope.car.id}">
            <button type="submit">Забронировать</button>
        </form>

        <form action="${pageContext.request.contextPath}/cars/broke" method="post">
            <input type="hidden" name="carId" value="${requestScope.car.id}">
            <button type="submit">Сломать</button>
        </form>
    </c:when>

    <c:when test="${requestScope.car.status == 'RENTED'}">
        <form action="${pageContext.request.contextPath}/cars/unbook" method="post">
            <input type="hidden" name="carId" value="${requestScope.car.id}">
            <button type="submit">Вернуть машину</button>
        </form>

        <form action="${pageContext.request.contextPath}/cars/broke" method="post">
            <input type="hidden" name="carId" value="${requestScope.car.id}">
            <button type="submit">Сломать</button>
        </form>
    </c:when>

    <c:when test="${requestScope.car.status == 'BROKEN'}">
        <form action="${pageContext.request.contextPath}/cars/fix" method="post">
            <input type="hidden" name="carId" value="${requestScope.car.id}">
            <button type="submit">Починить машину</button>
        </form>
    </c:when>
</c:choose>
<form action="${pageContext.request.contextPath}/cars/delete" method="post">
    <input type="hidden" name="carId" value="${requestScope.car.id}">
    <button type="submit">Delete</button>
</form>
<br>
<a href="${pageContext.request.contextPath}/cars">Go back</a>
<br>
</body>
</html>