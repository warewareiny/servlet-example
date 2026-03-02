<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fix the car</title>
</head>
<body>

<c:choose>
    <c:when test="${successFix == 'SUCCESS'}">
        <div style="color: green">
            <p>You have successfully fixed a car</p>
        </div>
    </c:when>
    <c:otherwise>
        <div style="color: red">
            <p>You couldn't fix this car</p>
        </div>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/cars">Back</a>
</body>
</html>