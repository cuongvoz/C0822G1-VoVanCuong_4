<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/12/2022
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/login" modelAttribute="login">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="account">Account: </form:label></td>
                <td><form:input path="account"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Password: </form:label></td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <th colspan="2"><button type="submit">Login</button></th>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
