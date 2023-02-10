<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Страница меню</title>
    <style><%@include file="/WEB-INF/styles.css"%></style>
</head>

<body>

<p>
    <h1 class="form-style-2-heading">Выберите действие</h1>
</p>

<div class="form-style-2" style="font-size: 20px">
    <button type="button" onclick=window.location="/registration">Регистрация новой посылки</button>
    <br/>
    <br/>
    <button type="button" onclick=window.location="/tracker">Отслеживание посылок</button>
    <br/>
    <br/>
    <button type="button" onclick=window.location="/packages">Просмотр номеклатуры посылок </button>
    <br/>
    <br/>
    <button type="button" onclick=window.location="/offices">Просмотр почтовых отделений </button>
</div>

</body>
</html>