<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: viet
  Date: 05/10/2023
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1px">
    <a href="/students?action=create">Thêm mới sinh viên</a>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Sex</th>
        <th>Action</th>
    </tr>
    <c:forEach var="list" items="${listStudent}">
        <tr>
            <th>${list.id}</th>
            <td>${list.name}</td>
            <td>${list.email}</td>
            <td>${list.sex}</td>
            <td><a href="/students?action=edit&id=${list.id}&name=${list.name}&email=${list.email}&sex=${list.sex}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
