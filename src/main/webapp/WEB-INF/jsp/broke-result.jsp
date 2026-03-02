<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Broke Result</title>
</head>
<body>

<c:choose>
    <c:when test="${brokeResult == 'SUCCESS'}">
        <p style="color: green">You have successfully marked the car as broken</p>
    </c:when>
    <c:otherwise>
        <p style="color: red">You couldn't mark this car as broken: ${brokeResult}</p>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/cars">Back</a>

</body>
</html>