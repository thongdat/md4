<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>

<form th:action="@{/products/add}" th:object="${product}" method="post">
    <label>Tên sản phẩm:</label>
    <input type="text" th:field="*{name}" /> <br>

    <label>Mô tả:</label>
    <input type="text" th:field="*{description}" /> <br>

    <label>Giá:</label>
    <input type="number" th:field="*{price}" /> <br>

    <label>Loại:</label>
    <select th:field="*{category}">
        <option th:each="c : ${categories}" th:value="${c}" th:text="${c}"></option>
    </select> <br>

    <button type="submit">Thêm sản phẩm</button>
</form>

<div th:if="${mess}" style="color: green;">
    <p th:text="${mess}"></p>
</div>
</body>
</html>
