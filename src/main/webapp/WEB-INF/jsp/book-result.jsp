<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Book the car</title>
</head>
<body>
<c:choose>
    <c:when test="${success == 'SUCCESS'}">
        <div style="color: green">
            <p>You have successfully booked a car</p>
        </div>
    </c:when>

    <c:otherwise>
        <div style="color: red">
            <p>You couldn't book this car</p>
        </div>
    </c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/cars">Back</a>
</body>
</html>