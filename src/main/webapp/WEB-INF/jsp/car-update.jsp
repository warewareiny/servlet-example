
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update the car</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/cars/update">
    <input type="hidden" name="carId" value="${car.id}">
    <label for="brandId">Enter new brand:
        <input type="text" name="brand" id="brandId" value="${car.brand}">
    </label><br>
    <label for="modelId">Enter new model:
        <input type="text" name="model" id="modelId" value="${car.model}">
    </label><br>
    <label for="productionYearId">Enter new production year:
        <input type="text" name="productionYear" id="productionYearId" value="${car.productionYear}">
    </label><br>
    <label for="pricePerDayId">Enter new price per day:
        <input type="text" name="pricePerDay" id="pricePerDayId" value="${car.pricePerDay}">
    </label><br>
    <label for="carNumberId">Enter new car number:
        <input type="text" name="carNumber" id="carNumberId" value="${car.carNumber}">
    </label><br>
    <button type="submit">Send</button>
    <div>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                </c:forEach>
            </div>
        </c:if>
    </div>
</form>

<a href="${pageContext.request.contextPath}/cars">Back</a>
</body>
</html>
