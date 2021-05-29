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
        <form method="POST" target="/todo/done">
            <label>Zaznacz jako wykonane</label>
            <c:if test="${task.done eq true}">
                <input type="checkbox" name="done" readonly checked value="${iteration.index}"/>
            </c:if>
            <c:if test="${task.done ne true}">
                <input type="checkbox" name="done" value="${iteration.index}"/>
                <input type="submit" value="Zapisz">
            </c:if>
        </form>
    </c:forEach>
</div>
</body>
</html>