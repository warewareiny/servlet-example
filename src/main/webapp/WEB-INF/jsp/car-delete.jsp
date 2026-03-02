<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete car</title>
</head>
<body>

<c:choose>
    <c:when test="${deleteResult == 'SUCCESS'}">
        <p style="color: green">You have successfully deleted the car</p>
    </c:when>
    <c:otherwise>
        <p style="color: red">
            You couldn't delete this car.
            <c:if test="${deleteResult == 'FAIL'}">Car not found or could not be deleted.</c:if>
        </p>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/cars">Back</a>

</body>
</html>
