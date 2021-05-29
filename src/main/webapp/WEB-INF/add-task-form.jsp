<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%--@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj zadanie ...</title>
</head>
<body>
<h2>Dodaj zadanie</h2>
<form>
    <label for="title">Nazwa zadania</label><br>
    <input type="text" name="title" id="title"/><br>
    <label for="deadline">Termin zakończenia zadania</label><br>
    <input type="date" name="deadline" id="deadline"/><br>
    <label for="email">Email wykonawcy zadania</label><br>
    <input type="email" name="email" id="email"/><br>
    <input type="submit" value="Zapisz"/>
</form>
</body>
</html>
