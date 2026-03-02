<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Unbook Result</title>
</head>
<body>

<c:choose>
    <c:when test="${unbookResult == 'SUCCESS'}">
        <p style="color: green">You have successfully returned the car</p>
    </c:when>
    <c:otherwise>
        <p style="color: red">You couldn't return this car: ${unbookResult}</p>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/cars">Back</a>

</body>
</html>