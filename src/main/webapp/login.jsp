<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 14.06.2023
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="j_security_check">
    Email: <input type="email" required name="j_username"><br/>
    Password <input type="password" required name="j_password"><br/>

    <input type="submit" value="login"><br/>
</form>
<a href="FrontController?command=command_logout">log</a>

</body>
</html>
