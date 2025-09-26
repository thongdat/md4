<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Giá</th>
        <th>Loại</th>
        <th>Chi tiết</th>
    </tr>
    <tr th:each="product : ${productList}">
        <td th:text="${product.id}"></td>
        <td th:text="${product.name}"></td>
        <td th:text="${product.description}"></td>
        <td th:text="${product.price}"></td>
        <td th:text="${product.category}"></td>
        <td><a th:href="@{/products/detail/{id}(id=${product.id})}">Xem</a></td>
    </tr>
</table>

<a th:href="@{/products/add}">Thêm sản phẩm mới</a>
</body>
</html>
