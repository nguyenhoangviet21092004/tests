<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: viet
  Date: 05/10/2023
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <a href="students?action=null">Quay về trang chủ</a><br/>
    <br>
    <c:forEach var="list" items="${listStudent}">
        <label>Name :</label>
        <input type="hidden" name=idEdit size="30" value="${list.id}"><br/>
        <input type="text" name="nameEdit" size="30" value="${list.name}"><br/>
        <br>
        <label>Email :</label>
        <input type="email" name="emailEdit" size="30"><br/>
        <br>
        <label>Sex :</label>
        <input type="text" name="sexEdit" size="30"><br/>
        <br>
        <input type="submit" value="Add">
    </c:forEach>

</form>
</body>
</html>
