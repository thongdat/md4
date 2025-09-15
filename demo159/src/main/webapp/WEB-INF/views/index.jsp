<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator & Sandwich</title>
</head>
<body>

<h1>Bài nộp: Calculator & Sandwich</h1>

<div class="card">
    <h2>Calculator</h2>
    <form action="calculate" method="post">
        <input type="number" name="a" placeholder="Số thứ nhất" step="any" required>
        <input type="number" name="b" placeholder="Số thứ hai" step="any" required>
        <div class="btns">
            <button type="submit" name="op" value="add">+</button>
            <button type="submit" name="op" value="sub">-</button>
            <button type="submit" name="op" value="mul">×</button>
            <button type="submit" name="op" value="div">÷</button>
        </div>
    </form>
</div>

<div class="card">
    <h2>Sandwich Condiments</h2>
    <form action="save" method="post">
        <c:forEach var="item" items="${condiments}">
            <label class="checkbox">
                <input type="checkbox" name="condiment" value="${item}"> ${item}
            </label>
        </c:forEach>
        <div class="btns">
            <button type="submit">Save</button>
        </div>
    </form>
</div>

</body>
</html>
