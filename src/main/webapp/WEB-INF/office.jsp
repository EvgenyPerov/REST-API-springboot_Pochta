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
    <h1>Почтовые отделения</h1>
</p>
<p>
<h2>Для добавления нового отделения введите данные:</h2>
</p>

<div class="form-style-2">
<br/>
    <br/>
    <form method="post" action="/offices">
        <label for="index">Введите индекс отделения
            <input class="input-field" type="number" min="100000" max="999999"
                   value="123456" required id="index" name="index" style="width: 100px">
        </label>
        <br/>
        <br/>
        <label for="name">Введите название отделения
            <input class="input-field" type="text" value="" id="name" name="name">
        </label>
        <br/>
        <br/>
        <label for="address">Введите адрес отделения
            <input class="input-field" type="text" value="" id="address" name="address" name="index" style="width: 300px">
        </label>
        <br/>
        <br/>
        <input id="input-office" type="submit" value="Добавить">
    </form>
</div>
<br/>
<div>
    <table class="table" id="table">
        <tr>
            <th>#</th>
            <th>Индекс</th>
            <th>Название</th>
            <th>Адрес</th>
        </tr>
        <c:forEach  items="${listOffices}" var ="office">
            <tr>
                <td>${office.id}</td>
                <td>${office.index}</td>
                <td>${office.name}</td>
                <td>${office.address}</td>
            </tr>
        </c:forEach>
    </table>

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

<script>
    $(document).ready(function() {
        $('#input-office').click(function() {
            // if($(this).val() === "111111")
                alert("Добавлено новое почтовое отделение")
        });
    });
</script>

</body>
</html>