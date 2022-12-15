<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/12/2022
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <marquee>

    </marquee>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<h2> Máy Tính</h2>
<form class="form-control" action="calculate" id="hay" style="width: 420px;border: 1px solid gray;border-radius: 10px">
    <table>
        <tr>
            <td colspan="2">
                <input class="form-control" placeholder="Nhập số thứ nhất" type="number" name="first" value="0">
            </td>
            <td colspan="2">
                <input class="form-control" placeholder="Nhập số thứ hai" type="number" name="second" value="0">
            </td>
        </tr>
        <tr>
            <th>
                <button class="btn btn-outline-success" name="operator" value="+" type="submit"><i
                        class="fa-sharp fa-solid fa-plus"></i></button>
            </th>
            <th>
                <button class="btn btn-outline-success" name="operator" value="-" type="submit"><i
                        class="fa-sharp fa-solid fa-minus"></i></button>
            </th>
            <th>
                <button class="btn btn-outline-success" name="operator" value="x" type="submit"><i
                        class="fa-sharp fa-solid fa-x"></i></button>
            </th>
            <th>
                <button class="btn btn-outline-success" name="operator" value="/" type="submit"><i
                        class="fa-sharp fa-solid fa-slash"></i></button>
            </th>
        </tr>
    </table>

</form>
<div>
    <marquee id="oke"><h1>
        ${result}</h1></marquee>
</div>
</body>
<script>

    let text = document.getElementById("oke").innerText;
    if (text != "") {
        setTimeout(bienMat, 10000)
        setTimeout(doiMau, 3000)
    }

    function doiMau() {
        document.getElementById("oke").style.color = "red";
    }

    function bienMat() {
        document.getElementById("oke").style.display = "none";
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
