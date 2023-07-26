<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 11.07.2023
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/FrontController">
    <input type="hidden" name="command" value="income">
    <select name="cinemas" multiple>
        <c:forEach var="cinema" items="${cinemas}">
            <option  value="${cinema.id}">${cinema.title}</option>
        </c:forEach>
    </select>

    <select name="days">
        <option selected value="7"> 7 days</option>
        <option value="30"> 30 days</option>
    </select>

    <input type="submit" value="watch statistic" name="statistic">
</form>
</body>
</html>
