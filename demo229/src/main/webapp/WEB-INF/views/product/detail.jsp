<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Chi tiết sản phẩm</title>
</head>
<body>
<h2>Chi tiết sản phẩm</h2>

<p><strong>ID:</strong> <span th:text="${product.id}"></span></p>
<p><strong>Tên:</strong> <span th:text="${product.name}"></span></p>
<p><strong>Mô tả:</strong> <span th:text="${product.description}"></span></p>
<p><strong>Giá:</strong> <span th:text="${product.price}"></span></p>
<p><strong>Loại:</strong> <span th:text="${product.category}"></span></p>

<a th:href="@{/products}">Quay lại danh sách</a>
</body>
</html>
