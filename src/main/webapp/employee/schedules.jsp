<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 06.07.2023
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
<tr>
<td>id</td>
    <td>title</td>
    <td>date</td>
    <td>price</td>
    <td>place</td>
    <td>time</td>
    <td>place_amount</td>

</tr>
<c:forEach var="Schedule" items="${schedules}">
<tr>
<td>${Schedule.id}</td><td>${Schedule.film.title}</td><td>${Schedule.date}</td><td>${Schedule.price}</td><td>${Schedule.bay_place}</td><td>${Schedule.time}</td><td>${Schedule.place_amount}</td>
    <td><a href="${pageContext.request.contextPath}/FrontController?command=TICKETS&idSchedule=${Schedule.id}">билет</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>
