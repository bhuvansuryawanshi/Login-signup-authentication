<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .Container {
        background-color: #ffffff;
        padding: 30px 50px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    a {
        display: inline-block;
        margin: 10px 15px;
        padding: 10px 20px;
        text-decoration: none;
        color: white;
        background-color: #007BFF;
        border-radius: 5px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="Container">
        <h1>Welcome To Home Page..!!</h1>
        <a href="index.jsp">New User</a>
        <a href="Login.jsp">Login</a>    
    </div>
</body>
</html>
