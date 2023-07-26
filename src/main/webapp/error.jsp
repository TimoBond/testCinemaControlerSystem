<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 14.06.2023
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Error page</h1>
<h1>please check email or password and try again</h1>
<form action="j_security_check" method="get" >
  Email: <input type="email" name="j_username"><br/>
  Password: <input type="password" name="j_password">
  <input type="submit" value="login">
</form>
</body>
</html>
