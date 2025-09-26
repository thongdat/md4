<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <th:block th:insert="~{/layout/layout::library}"/>
</head>
<body>
<div th:replace="~{/layout/layout::header}"></div>
<a href="/products/add">Thêm mới</a>
<a th:href="@{/products/add}">Thêm mới</a>
<table class="table table-dark">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Description</th>
        <th>RP-Detail</th>
        <th>PV-Detail</th>
    </tr>

    <tr th:each="product,status:${productList}">
        <td th:text="${status.count}"></td>
        <td th:text="${product.id}"></td>
        <td th:text="${product.name}"></td>
        <td th:text="${product.price}"></td>
        <td th:text="${product.category}"></td>
        <td th:text="${product.description}"></td>
        <td>
            <a th:href="@{/products/detail(id=${product.id})}">Detail</a>
        </td>
        <td>
            <a th:href="@{/products/detail/__${product.id}__}">Detail</a>
        </td>
    </tr>
    <tr>
        <td th:if="${productList.isEmpty()}" colspan="8" th:text="${'Không có giá trị nào'}"></td>
    </tr>
</table>
</body>
</html>
