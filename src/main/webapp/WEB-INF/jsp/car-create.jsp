<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create a car</title>
</head>
<body>
<h1>Add new car here:</h1>
<form method="post" action="${pageContext.request.contextPath}/car-create">
    <label for="brandId">Brand:
        <input type="text" name="brand" id="brandId">
    </label><br>
    <label for="modelId">Model:
        <input type="text" name="model" id="modelId">
    </label><br>
    <label for="productionYearId">Production year:
        <input type="text" name="productionYear" id="productionYearId">
    </label><br>
    <label for="pricePerDayId">Price per day:
        <input type="text" name="pricePerDay" id="pricePerDayId">
    </label><br>
    <label for="carNumberId">Car number:
        <input type="text" name="carNumber" id="carNumberId">
    </label><br>
    <button type="submit">Add car</button>
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
</body>
</html>
