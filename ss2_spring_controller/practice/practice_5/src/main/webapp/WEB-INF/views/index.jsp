<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/12/2022
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <form id="check" action="/alo" method="post">
     <select name="chao" onchange="document.getElementById('check').submit()">
       <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
       <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
       <option value="Singapore">Singapore</option>
       <option value="Asia/Hong_Kong">Hong Kong</option>
       <option value="Asia/Tokyo">Tokyo</option>
       <option value="Asia/Seoul">Seoul</option>
       <option value="Europe/London">London</option>
       <option value="Europe/Madrid">Madrid</option>
       <option value="America/New_York">New York</option>
       <option value="Australia/Sydney">Sydney</option>
       <option value="Argentina/Buenos_Aires">Buenos Aires</option>
     </select>
   </form>
  <h3>${city}</h3>
  <h3>${date}</h3>
  </body>

</html>
