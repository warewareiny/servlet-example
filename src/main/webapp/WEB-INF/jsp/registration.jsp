<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registration">
    <label for="firstNameId">
        <input type="text" name="firstName" id="firstNameId">First name:
    </label><br>
    <label for="lastNameId">
        <input type="text" name="lastName" id="lastNameId">Last name:
    </label><br>
    <label for="emailId">
        <input type="text" name="email" id="emailId">Email:
    </label><br>
    <label for="phoneId">
        <input type="text" name="phone" id="phoneId">Phone:
    </label><br>
    <label for="passportNumberId">
        <input type="text" name="passportNumber" id="passportNumberId">Passport number:
    </label><br>
    <button type="submit">Send</button>
</form>
</body>
</html>
