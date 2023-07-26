<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 16.06.2023
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="FrontController">
   Name: <input type="text" required name="name"><br/>
    Email:<input type="email" required name="email"><br/>
     Password: <input type="password" required name="password"><br/>
    Phone: <input type="text" required name="phone"><br/>
    <input type="hidden" name="command" value="REGISTRATION"><br/>
    <input type="submit" name="registration"><br/>
</form>

</body>
</html>
