<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Посылка создана</title>
    <style><%@include file="/WEB-INF/styles.css"%></style>
</head>
<body>

<a href="menu"> <--- вернуться в главное меню </a>

<p>
    <h1>Сохраните номер-идентификатор созданной посылки</h1>
</p>
<p>
<h2>${newID}</h2>
</p>


</body>
</html>