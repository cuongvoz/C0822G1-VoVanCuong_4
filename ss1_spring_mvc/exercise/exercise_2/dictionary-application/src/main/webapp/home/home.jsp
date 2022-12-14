<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/12/2022
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/dictionary" class="form-control">
    <fieldset style="display: inline">
        <table class="table">
            <thead>
            <tr>
                <th colspan="2">Ứng Dụng Từ Điển</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" style="display: inline" class="form-control" name="english"
                           placeholder="Nhập từ tiếng anh"></td>
                <td>
                    <button class="btn btn-outline-success" style="display: inline" type="submit"><i
                            class="fa-sharp fa-solid fa-wand-magic-sparkles"></i></button>
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
<span></span>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
