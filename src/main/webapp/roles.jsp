<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 25.06.2023
  Time: 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="post" action="FrontController">--%>
<%--    <input type="hidden" name="command" value="LOGIN">--%>
<%--    Roles <select name="roles">--%>
<%--    <option selected value="admin">admin</option>--%>
<%--    <option value="employee">employee</option>--%>
<%--    <option value="manager">manager</option>--%>
<%--    <option value="boss">boss</option>--%>
<%--            </select>--%>
<%--    <input type="submit" name="login">--%>
<%--</form>--%>
<a href="${pageContext.request.contextPath}/boss/bossMainPaige.jsp">Boss</a>
<a href="${pageContext.request.contextPath}/admin/adminMainPaige.jsp">Admin</a>
<a href="${pageContext.request.contextPath}/manager/managerMainPaige.jsp">Manager</a>
<a href="${pageContext.request.contextPath}/employee/employeeMainPaige.jsp">Employee</a>
</body>
</html>
