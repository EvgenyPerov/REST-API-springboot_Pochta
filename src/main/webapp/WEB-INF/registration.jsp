<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Страница регистрации отправления</title>
    <style><%@include file="/WEB-INF/styles.css"%></style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<a href="menu"> <--- вернуться в главное меню </a>

<p>
    <h1 id="info">Регистрация отправки</h1>
</p>

<div class="form-style-2">

    <form method="post" action="/registration">

        <label for="indexCurrent">Ваше отделение

            <select class="select-field" id="indexCurrent" name="indexCurrentOffice" style="width: 400px">
                <c:forEach items="${mapOffices}" var="mapOffice">
                    <option value="${mapOffice.key}">${mapOffice.key} адрес: ${mapOffice.value} </option>
                </c:forEach>
            </select>
        </label>
        <br/>
        <br/>
        <label for="type">Выберите тип отправки
            <select class="select-field" id="type" name="type" style="width: auto">
                <c:forEach items="${types}" var="type">
                    <option value="${type}"> ${type.typeDescription} </option>
                </c:forEach>
            </select>
        </label>
        <br/>
        <br/>

        <label for="weight" id="label_weight">Введите вес Кг
            <input class="input-field" type="number" step="0.001" value="0" id="weight" placeholder="0.000"
                   name="weight" style="width: 100px">
        </label>
        <br/>
        <br/>
        <label for="cost">Введите стоимость Рублей
            <input class="input-field" type="number" step="0.01" value="0" placeholder="0.00" id="cost" name="cost" style="width: 100px">
        </label>
        <br/>
        <br/>
        <label for="name">Введите имя получателя
            <input class="input-field" type="text" value="" id="name" name="name" style="width: 400px">
        </label>
        <br/>
        <br/>
        <label for="address">Введите адрес получателя
            <input class="input-field" type="text" value="" id="address" name="address" style="width: 500px">
        </label>
        <br/>
        <br/>
        <label for="index">Выберите индекс отделения получателя
<%--            <input class="input-field" type="number" min="100000" max="999999" value="123456" id="index" name="index">--%>
            <select class="select-field" id="index" name="index" style="width: 400px">
                <c:forEach items="${mapOffices}" var="mapOffice">
                    <option value="${mapOffice.key}">${mapOffice.key} адрес: ${mapOffice.value}  </option>
                </c:forEach>
            </select>

        </label>
        <br/>
        <br/>
        <input id="input-pack" type="submit" value="Принять">
    </form>
</div>

<script>
    $(document).ready(function() {
        $('#type').change(function() {
            if($(this).val() === "PARCEL" || $(this).val() === "WRAPPER")
            {
                $("#weight").css("display", "block");
                $("#label_weight").css("display", "block");
            }
            else
            {
                $("#weight").css("display", "none");
                $("#label_weight").css("display", "none");
            }
        });
    });
</script>


</body>
</html>