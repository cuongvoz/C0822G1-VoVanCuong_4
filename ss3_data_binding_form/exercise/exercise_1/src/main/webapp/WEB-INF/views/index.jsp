<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2022
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <body>
  <marquee>
    <h2 style="color: red">${message}</h2>
  </marquee>
   <table class="table">
     <thead>
     <tr>
       <th>#</th>
       <th>Language</th>
       <th>Filter</th>
       <th>Size</th>
       <th>Signature</th>
       <th>Edit</th>
     </tr>
     </thead>
     <tbody>
     <c:forEach var="mail" items="${list}" varStatus="status">
       <tr>
         <td>${status.count}</td>
         <td>${mail.language}</td>
         <c:if test="${mail.filter}">
           <td>Enable</td>
         </c:if>
         <c:if test="${!mail.filter}">
           <td>Disable</td>
         </c:if>
         <td>${mail.size}</td>
         <td>${mail.signature}</td>
         <td><a class="btn btn-outline-success" href="/edit/${mail.id}"><i class="fa-sharp fa-solid fa-pen"></i> </a></td>
       </tr>
     </c:forEach>
     </tbody>
   </table>

  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>
