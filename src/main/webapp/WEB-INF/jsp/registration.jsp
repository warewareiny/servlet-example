<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registration">
    <label for="firstNameId">First name:
        <input type="text" name="firstName" id="firstNameId">
    </label><br>
    <label for="lastNameId">Last name:
        <input type="text" name="lastName" id="lastNameId">
    </label><br>
    <label for="emailId">Email:
        <input type="text" name="email" id="emailId">
    </label><br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId">
    </label><br>
    <label for="phoneId">Phone:
        <input type="text" name="phone" id="phoneId">
    </label><br>
    <label for="passportNumberId">Passport number:
        <input type="text" name="passportNumber" id="passportNumberId">
    </label><br>
    <button type="submit">Send</button>
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
