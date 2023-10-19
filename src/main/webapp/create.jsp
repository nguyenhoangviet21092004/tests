<%--
  Created by IntelliJ IDEA.
  User: viet
  Date: 05/10/2023
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post">
    <a href="students?action=null">Quay về trang chủ</a><br/>
    <br>
    <label>Name :</label>
    <input type="text" name="name" size="30"><br/>
    <br>
    <label>Email :</label>
    <input type="email" name="email" size="30"><br/>
    <br>
    <label>Sex :</label>
    <input type="text" name="sex" size="30"><br/>
    <br>
    <input type="submit" value="Add">
</form>
</body>
</html>
