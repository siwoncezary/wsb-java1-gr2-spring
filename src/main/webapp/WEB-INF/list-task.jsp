<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%--@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Servlety</title>
</head>
<body>
<p>
    <%=request.getAttribute("task").toString()%>
</p>
</body>
</html>