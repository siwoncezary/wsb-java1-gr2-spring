<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%--@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Servlety</title>
</head>
<body>
<h2 class="hello-title">Spis serwletów</h2>
<ul>
    <li>
        <a href="/parameters?user=karol&count=5">ParametersServlet</a>
    </li>
    <li>
        <a href="/cookie">CookiesServlet</a>
    </li>
    <li>
        <a href="/login?login=ania">SessionServlet</a>
    </li>
    <li>
        <a href="/hello">HelloServlet</a>
    </li>
    <li>
        <a href="/todo/add">Dodaj zadanie do wykonania</a>
    </li>
    <li>
        <a href="/todo/list">Lista zadań</a>
    </li>
</ul>
</body>
</html>