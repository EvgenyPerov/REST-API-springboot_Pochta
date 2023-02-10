<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Страница просмотра отделений</title>
    <style><%@include file="/WEB-INF/styles.css"%></style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<a href="menu"> <--- вернуться в главное меню </a>

<p>
    <h1>Номеклатура посылок</h1>
</p>
<div class="form-style-2">
    <form method="post" action="/packages">
    <label id="labelIndex" for="index">Выберите индекс вашего отделения
        <select class="select-field" id="index" name="index" style="width: 450px">
            <c:forEach items="${mapOffices}" var="mapOffice">
                <option value="${mapOffice.key}">${mapOffice.key} адрес: ${mapOffice.value}  </option>
            </c:forEach>
        </select>
    </label>
            <input id="find-index" type="submit" value="Найти">
    </form>
<br/>
<br/>
    <label for="identifier2" >Ваш индекс:
        <input class="input-field" type="text" value="${indexAndAddress}" readonly id="identifier2" style="width: 450px">
    </label>
    <br/>
    <br/>
    <table id="tablePackages">
        <tr>
            <th>#</th>
            <th>Идентификатор</th>
            <th>Статус</th>
            <th>Дата</th>
        </tr>
        <c:forEach  items="${findPackagesByIndex}" var ="pack" >
            <tr>
                <td>${pack.id}</td>
                <td>${pack.pack.identifier}</td>
                <td>${pack.name}</td>
                <td>${pack.date.toLocaleString()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>