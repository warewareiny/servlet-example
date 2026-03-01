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

</body>
</html>