<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/12/2022
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<c:form method="post" action="/addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><c:label path="id">Employee ID: </c:label></td>
            <td><c:input path="id"/></td>
        </tr>
        <tr>
            <td><c:label path="name">Employee Name: </c:label></td>
            <td><c:input path="name"/></td>
        </tr>
        <tr>
            <td><c:label path="contactNumber">Employee ContactNumber: </c:label></td>
            <td><c:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><button type="submit">Check</button> </td>
        </tr>
    </table>
</c:form>
</body>
</html>
