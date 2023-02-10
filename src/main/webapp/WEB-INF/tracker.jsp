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
    <h1>Отслеживание посылок</h1>
</p>
<div class="form-style-2">
<br/>
    <form method="post" action="/tracker">
            <label for="identifier">Введите идентификатор посылки:
                <input class="input-field" type="text" value="" id="identifier" name="identifier" style="width: 150px">
            </label>
        <input id="find-pack" type="submit" value="Найти">
    </form>

    <br/>

    <form method="post" action="/tracker/add">
        <label id="labelIdent" for="identifier2" >Идентификатор:
            <input class="input-field" type="text" value="${findedId}" readonly id="identifier2" name="identifier" style="width: 150px">
        </label>
        <br/>
        <label id="labelIndex" for="index">Выберите индекс вашего текущего отделения
            <select class="select-field" id="index" name="index" style="width: 400px">
                <c:forEach items="${mapOffices}" var="mapOffice">
                    <option value="${mapOffice.key}">${mapOffice.key} адрес: ${mapOffice.value}  </option>
                </c:forEach>
            </select>
        </label>
        <br/>
        <br/>
        <label id="labelStatus" for="type">Выберите новый статус
            <select class="select-field" id="type" name="typeStatus" style="width: 200px">
                <c:forEach items="${types}" var="type">
                    <option value="${type}"> ${type.toString()} </option>
                </c:forEach>
            </select>
        </label>
        <br/>
        <br/>
        <input type="submit" value="Изменить статус" id="changeStatusButton">
    </form>
</div>
<br/>
<div>
    <table id="tableStatuses">
        <tr>
            <th>#</th>
            <th>Идентификатор</th>
            <th>Название</th>
            <th>Дата</th>
            <th>Индекс отделения</th>
            <th>Адрес отделения</th>
        </tr>
        <c:forEach  items="${findListByIdentifier}" var ="track">
            <tr>
                <td>${track.id}</td>
                <td id="validIdent">${track.pack.identifier}</td>
                <td>${track.name}</td>
                <td>${track.date.toLocaleString()}</td>
                <td>${track.office.index}</td>
                <td>${track.office.address}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>

    $(document).ready(function() {

            if(${findListByIdentifier.size() == 0})
            {
                $("#identifier2").css("display", "none");
                $("#labelIdent").css("display", "none");
                $("#labelIndex").css("display", "none");
                $("#index").css("display", "none");
                $("#labelAddress").css("display", "none");
                $("#labelStatus").css("display", "none");
                $("#type").css("display", "none");
                $("#changeStatusButton").css("display", "none");
                $("#tableStatuses").css("display", "none");
            }
            else
            {
                if (${isCompleted == 1}) {
                <%--    if(${findListByIdentifier.size() == 7}){--%>
                    $("#identifier2").css("display", "block");
                    $("#labelIdent").css("display", "block");
                    $("#tableStatuses").css("display", "block");

                    $("#labelIndex").css("display", "none");
                    $("#index").css("display", "none");
                    $("#labelAddress").css("display", "none");
                    $("#labelStatus").css("display", "none");
                    $("#type").css("display", "none");
                    $("#changeStatusButton").css("display", "none");
                } else {
                    $("#identifier2").css("display", "block");
                    $("#labelIdent").css("display", "block");
                    $("#labelIndex").css("display", "block");
                    $("#index").css("display", "block");
                    $("#labelAddress").css("display", "block");
                    $("#labelStatus").css("display", "block");
                    $("#type").css("display", "block");
                    $("#changeStatusButton").css("display", "block");
                    $("#tableStatuses").css("display", "block");
                }
            }
    });
</script>

<script>
    $(document).ready(function() {
        $('#changeStatusButton').click(function() {
                alert("Статус изменен");
            ${findListByIdentifier.clear()}
        });
    });
</script>

</body>
</html>