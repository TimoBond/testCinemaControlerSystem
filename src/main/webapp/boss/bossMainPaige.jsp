<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 16.06.2023
  Time: 08:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/FrontController?command=command_logout">log</a>
Boss
<%--<a href="FrontController?command=command_logout">logout</a>--%>
<form method="post" action="${pageContext.request.contextPath}/FrontController">
    <input type="hidden" name="command" value="command_logout">
    <input type="submit" value="log" name="logout">
</form>

<form method="post" action="${pageContext.request.contextPath}/FrontController">
   <input type="hidden" name="command" value="GO_INCOME">
    <input type="submit" value="watch statistic" name="statistic">
</form>

</body>
</html>
