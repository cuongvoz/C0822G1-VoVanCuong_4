<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/12/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/validate">
    <input name="email" type="text">
    <button type="submit">Kiểm Tra</button>
  </form>
  <h1>${result}</h1>
  </body>
</html>
