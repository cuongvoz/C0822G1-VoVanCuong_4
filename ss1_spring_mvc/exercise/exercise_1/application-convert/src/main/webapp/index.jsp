<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/12/2022
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/convert">
    <fieldset style="display: inline">
        <legend><b>Ứng dụng đổi tiền</b></legend>
        <table>
            <tr>
                <td>Mệnh Giá Muốn Đổi</td>
                <td>
                    <select name="firstType" style="width: 100%">
                        <option value="USD">USD</option>
                        <option value="VND">VND</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Số Tiền Cần Đổi</td>
                <td>
                    <input type="number" name="value" value="0">
                </td>
            </tr>
            <tr>
            <td>Mệnh Giá Cần Đổi</td>
            <td>
                <select name="secondType" style="width: 100%">
                    <option value="USD">USD</option>
                    <option value="VND">VND</option>
                </select>
            </td>
            </tr>
        </table>
        <center>
            <button type="submit">Đổi</button>
        </center>
    </fieldset>

</form>
</body>
</html>
