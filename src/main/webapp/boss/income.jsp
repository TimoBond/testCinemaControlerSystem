<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 06.07.2023
  Time: 19:23
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
        <td>title</td>
        <td>price</td>

    </tr>
    <c:forEach var="Statistic" items="${statistic.titleSum}">
        <tr>
           <td>${Statistic.key}</td>
            <td>${Statistic.value}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
