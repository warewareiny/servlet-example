
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Unbook the car</title>
</head>
<body>

<c:choose>
    <c:when test="${successUnbook == 'SUCCESS'}">
        <div style="color: green">
            <p>You have successfully unbooked a car</p>
        </div>
    </c:when>
    <c:otherwise>
        <div style="color: red">
            <p>You couldn't unbook this car</p>
        </div>
    </c:otherwise>
</c:choose>
<br>
<a href="${pageContext.request.contextPath}/cars">Go back</a>
</body>
</html>
