<%-- 
    Document   : editUser
    Created on : Dec 3, 2024, 7:10:29 AM
    Author     : helmy
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>

    <form action="editUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label for="username">Username:</label>
        <input type="text" name="username" value="${user.username}" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" value="${user.password}" required><br><br>

        <label for="fullName">Full Name:</label>
        <input type="text" name="fullName" value="${user.full_name}" required><br><br>

        <button type="submit">Update User</button>
    </form>
</body>
</html>