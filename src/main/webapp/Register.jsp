<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Tài Chính</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        form {
            margin-top: 20px;
        }

        label, input, select {
            display: block;
            margin-bottom: 10px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        select {
            height: 34px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Quản Lý Tài Chính</h1>
    <form method="post" action="Login?action=addUser">
        <label for="userName">Name:</label>
        <input type="text" name="userName" id="userName" required>

        <label for="password">Password:</label>

        <input type="password" name="password" id="password" required>
        <label for="password">Confirm Password:</label>
        <input type="password" name="confirmPassword" id="confirmPassword" required>

        <label for="gender">Gender:</label>
        <select name="gender" id="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>

        <label for="birthdate">Birthdate:</label>
        <input type="date" name="birthdate" id="birthdate">

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" name="phoneNumber" id="phoneNumber" required>

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
