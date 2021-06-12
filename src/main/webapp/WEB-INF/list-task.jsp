<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Servlety</title>
</head>
<body>
<h1>Lista zadań</h1>
<div>
    <c:forEach items="${tasks}" var="task" varStatus="iteration">
        <h3>Zadanie nr: ${iteration.index + 1}</h3>
        <p>Tytuł zadania: ${task.title}</p>
        <p>Email wykonawcy: ${task.email}</p>
        <p>Termin: ${task.deadline}</p>
        <form method="POST" action="/todo/done">
            <c:if test="${task.done eq true}">
                <p>Zadanie wykonane</p>
                <input type="checkbox" name="done" disabled checked value="${task.id}"/>
            </c:if>
            <c:if test="${task.done ne true}">
                <label>Zaznacz jako wykonane</label>
                <input type="checkbox" name="done" value="${task.id}"/>
                <input type="submit" value="Zapisz">
            </c:if>
        </form>
    </c:forEach>
</div>
</body>
</html>