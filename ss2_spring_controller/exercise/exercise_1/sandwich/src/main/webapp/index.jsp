<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/12/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/sandwich/save">
    <fieldset>
        <legend>Sandwich Condiments</legend>
        <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
        <input type="checkbox" name="condiment" value="Tomato"> Tomato
        <input type="checkbox" name="condiment" value="Mustard"> Mustard
        <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
        <button type="submit">Save</button>
    </fieldset>
</form>
</body>
</html>
