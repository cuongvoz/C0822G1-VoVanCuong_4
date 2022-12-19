<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2022
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<center>
    <h1>Danh sách học sinh</h1>
</center>
<div style="position: center">

    <form:form class="d-flex " cssStyle="width: 350px"  action="/find" method="post" modelAttribute="student">
        <form:input path="name" cssClass="form-control me-2"/>
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form:form>

</div>
<marquee>
    <h3>${message}</h3>
</marquee>
<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addModal">Thêm mới</button>

<a class="btn btn-danger" id="linkSort" href="/sort"><span id="textSort">điểm thấp</span></a>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Họ Tên</th>
        <th>Tuổi</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
        <th>Giới Tính</th>
        <th>Sửa</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${list}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.point}</td>
            <c:choose>
                <c:when test="${student.point >= 7}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point >= 5}">
                    <td>Trung Bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
            <c:if test="${student.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.gender}">
                <td>Nữ</td>
            </c:if>
            <td>
                <button class="btn btn-success"
                        onclick="editStudent('${student.id}','${student.name}','${student.age}','${student.point}','${student.gender}')"
                        data-bs-toggle="modal" data-bs-target="#editModal">Sửa
                </button>
            </td>
            <td>
                <button class="btn btn-success" onclick="deleteStudent('${student.id}','${student.name}')"
                        data-bs-toggle="modal" data-bs-target="#deleteModal">Xóa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-outline-success" href="/">Quay lại trang</a>
<div class="modal" tabindex="-1" id="editModal">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Sửa thông tin học sinh <i class="fa-sharp fa-solid fa-user"></i></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form action="/edit" method="post" modelAttribute="student">
                    <div class="mb-3 row">
                        <form:hidden path="id" id="editId"/>
                        <label class="col-sm-2 col-form-label">Nhập Tên</label>
                        <div class="col-sm-10">
                            <form:input path="name" id="editName" class="form-control"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Nhập Điểm</label>
                        <div class="col-sm-10">
                            <form:input path="point" id="editPoint" class="form-control"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Nhập Tuổi</label>
                        <div class="col-sm-10">
                            <form:input path="age" id="editAge" class="form-control"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Giới Tính</label>
                        <div class="col-sm-10">
                            <form:radiobutton path="gender" cssClass="form-check-input" id="s1" value="1"/>Nam
                            <form:radiobutton path="gender" cssClass="form-check-input" id="s2" value="0"/>Nữ
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Xác Nhận</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<div class="modal" tabindex="-1" id="addmodal">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Thêm mới nhân Viên <i class="fa-sharp fa-solid fa-user"></i></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form action="/add" method="post" modelAttribute="student">
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Nhập Tên</label>
                        <div class="col-sm-10">
                            <form:input path="name" id="addMod" onchange="checkName()" class="form-control"/>
                            <span id="errorName"
                                  style="display: none;color: red">Bạn nhập tên không đúng định dạng</span>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Nhập Điểm</label>
                        <div class="col-sm-10">
                            <form:input path="point" class="form-control"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Nhập Tuổi</label>
                        <div class="col-sm-10">
                            <form:input path="age" class="form-control"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Giới Tính</label>
                        <div class="col-sm-10">
                            <form:radiobutton path="gender" cssClass="form-check-input" value="1"/>Nam
                            <form:radiobutton path="gender" cssClass="form-check-input" value="0"/>Nữ
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" id="addButton" class="btn btn-primary">Xác Nhận</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<div class="modal" tabindex="-1" id="deletemodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác Nhận Xóa</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form:form action="/delete" method="post">
                <div class="modal-body">
                    <p>Bạn có chắc chắn muốn xóa học sinh <span id="nameDelete"></span> ?</p>
                </div>
                <input type="hidden" name="id" id="idDelete">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </form:form>

        </div>
    </div>
</div>
<div class="modal" tabindex="-1" id="modalTest">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="modalx" value="${isModal}">
<input type="hidden" id="flag" value="${sort}">
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
  let z = document.getElementById("modalx").value;
       let x = document.getElementById("flag").value;

       if (x == "true") {
           document.getElementById("linkSort").href = "/reverse";
           document.getElementById("linkSort").className = "btn btn-danger";
           document.getElementById("textSort").innerText = "Điểm Cao";
       } else {
           document.getElementById("linkSort").href = "/sort";
           document.getElementById("linkSort").className = "btn btn-primary";
           document.getElementById("textSort").innerText = "Điểm Thấp";

       }

       $(document).ready(
           function () {
               $("#modalTest").appendTo("body").modal('show')
           }
       )





    function deleteStudent(id, name) {
        document.getElementById("nameDelete").innerText = name;
        document.getElementById("idDelete").value = id;

    }

    function editStudent(id, name, age, point, gender) {

        if (gender === "true") {
            document.getElementById("s1").checked = true;
            document.getElementById("s2").checked = false;
        } else {
            document.getElementById("s1").checked = false;
            document.getElementById("s2").checked = true;
        }

        document.getElementById("editId").value = id;
        document.getElementById("editName").value = name;
        document.getElementById("editPoint").value = point;
        document.getElementById("editAge").value = age;

    }

    const notNum = /^[\D]+$/
    const regex = /^[a-z A-Z]+$/;

    function checkName() {
        let name = document.getElementById("addMod").value;
        if (regex.test(name) && notNum.test(name)) {
            document.getElementById("addMod").style.borderColor = "green";
            document.getElementById("addButton").disabled = false;
            document.getElementById("errorName").style.display = "none";
        } else {
            document.getElementById("addMod").style.borderColor = "red";
            document.getElementById("addButton").disabled = true;
            document.getElementById("errorName").style.display = "inline";
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
