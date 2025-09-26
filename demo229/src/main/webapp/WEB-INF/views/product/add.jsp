<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <th:block th:insert="~{layout/layout::library}"/>
</head>
<body>
<th:block th:insert="~{layout/layout::header}"/>
<h1>Add Product</h1>
<form action="/products/add" method="post" th:object="${product}">
    Name:
    <input type="text"> <br>
    Description:
    <input type="text" > <br>
    Price:
    <input type="number" > <br>
    Category:
    <input type="checkbox" th:each="cate:${category}" th:value="${cate}" th:text="${cate}"> <br>
    Quantity:
    <input type="number" > <br>
    <button type="submit">ADD NEW PRODUCT</button>
    <a href="/products">CANCEL</a>
</form>
</body>
</html>