<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2022
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
 <form:form action="/edit" method="post" modelAttribute="mail">
    <table class="table">
        <tr>
            <form:hidden path="id"/>
            <th>Language: </th>
            <th>
                <form:select cssClass="form-control" path="language" items="${listLanguage}"/>
            </th>
        </tr>
        <tr>
            <th>Page Size: </th>
            <th>
              Show  <form:select path="size" cssClass="form-control" items="${listSize}"/> Email per page
            </th>
        </tr>
        <tr>
            <th>Spams filter: </th>
            <th>
                 <form:checkbox path="filter" value="${mail.filter}" />
            </th>
        </tr>
        <tr>
            <th>Signature: </th>
            <th>
                <form:textarea path="signature" cssClass="form-control" value="${mail.filter}"/>
            </th>
        </tr>

    </table>
     <button class="btn btn-success" type="submit">Update</button>
 </form:form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>
