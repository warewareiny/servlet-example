<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fix Result</title>
</head>
<body>

<c:choose>
    <c:when test="${fixResult == 'SUCCESS'}">
        <p style="color: green">You have successfully fixed the car</p>
    </c:when>
    <c:otherwise>
        <p style="color: red">You couldn't fix this car: ${fixResult}</p>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/cars">Back</a>

</body>
</html>