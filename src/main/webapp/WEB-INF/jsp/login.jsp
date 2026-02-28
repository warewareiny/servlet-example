<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="emailId">Email:
        <input type="text" id="emailId" name="email">
    </label><br>
    <label for="passwordId">Password
        <input type="password" id="passwordId" name="password">
    </label>
    <button type="submit">Login</button>
</form>
</body>
</html>
