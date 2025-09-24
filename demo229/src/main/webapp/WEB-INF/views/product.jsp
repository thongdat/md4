<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Giá</th>
    </tr>
    <tr th:each="p : ${products}">
        <td th:text="${p.id}"></td>
        <td th:text="${p.name}"></td>
        <td th:text="${p.description}"></td>
        <td th:text="${p.price}"></td>
    </tr>
</table>

<h2>Thêm sản phẩm</h2>
<form th:action="@{/products/add}" th:object="${product}" method="post">
    <label>Tên: </label>
    <input type="text" th:field="*{name}" /><br/>
    <label>Mô tả: </label>
    <input type="text" th:field="*{description}" /><br/>
    <label>Giá: </label>
    <input type="number" th:field="*{price}" /><br/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
