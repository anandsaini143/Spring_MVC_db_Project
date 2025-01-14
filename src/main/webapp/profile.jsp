<%@page import="com.btps.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        background: linear-gradient(to right, #6a11cb, #2575fc);
        color: #fff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        padding: 20px;
    }

    .container {
        background: rgba(0, 0, 0, 0.6);
        padding: 30px;
        border-radius: 10px;
        width: 500px;
        box-shadow: 0 15px 25px rgba(0, 0, 0, 0.5);
    }

    h2, h3 {
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        font-size: 24px;
        text-transform: uppercase;
        letter-spacing: 1px;
    }

    h3 {
        margin-bottom: 15px;
        font-size: 18px;
    }

    a {
        display: block;
        text-align: center;
        margin-top: 20px;
        padding: 10px 20px;
        font-size: 16px;
        text-decoration: none;
        color: #000;
        background: #f44703;
        border-radius: 5px;
        transition: 0.3s ease;
    }

    a:hover {
        background: #ff764a;
        box-shadow: 0 0 10px #f44703, 0 0 30px #f44703;
        color: #fff;
    }
</style>
</head>
<body>

<%
    User user = (User) session.getAttribute("sessio_user");
%>

<div class="container">
    <h2>Welcome</h2>
    <h3>Name: <%= user.getName() %></h3>
    <h3>Father's Name: <%= user.getFname() %></h3>
    <h3>Age: <%= user.getAge() %></h3>
    <h3>Mobile No: <%= user.getMobile() %></h3>
    <h3>Email: <%= user.getEmail() %></h3>
    <h3>District: <%= user.getDistrict() %></h3>
    <h3>Address: <%= user.getAddress() %></h3>
    <a href="logout">Logout</a>
</div>

</body>
</html>
