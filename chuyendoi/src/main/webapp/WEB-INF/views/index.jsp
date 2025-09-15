<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Spring MVC - 2 Bài tập</title>
    <style>
        body{font-family:Arial,sans-serif;max-width:820px;margin:40px auto;}
        .grid{display:grid;grid-template-columns:1fr 1fr;gap:20px;}
        .card{border:1px solid #ddd;border-radius:12px;padding:24px}
        h2{margin-top:0}
        .error{color:#c00}
        input,button{margin:6px 0;padding:6px}
    </style>
</head>
<body>
<h1>Bài tập Spring MVC</h1>

<div class="grid">

    <div class="card">
        <h2>Chuyển đổi USD → VNĐ</h2>
        <form method="post" action="<c:url value='/convert'/>">
            <label>Tỉ giá (VNĐ/USD):</label><br/>
            <input type="text" name="rate" value="${rate}" required/><br/>
            <label>Số USD:</label><br/>
            <input type="text" name="usd" value="${usd}" required/><br/>
            <button type="submit">Chuyển đổi</button>
        </form>
        <c:if test="${not empty errorConvert}">
            <p class="error">${errorConvert}</p>
        </c:if>
        <c:if test="${not empty vnd}">
            <p>Kết quả: ${usd} USD = <b>${vnd}</b> VNĐ</p>
        </c:if>
    </div>


    <div class="card">
        <h2>Từ điển Anh – Việt</h2>
        <form method="post" action="<c:url value='/translate'/>">
            <label>Nhập từ tiếng Anh:</label><br/>
            <input type="text" name="word" value="${word}" required/><br/>
            <button type="submit">Dịch</button>
        </form>
        <c:if test="${not empty errorDict}">
            <p class="error">${errorDict}</p>
        </c:if>
        <c:if test="${not empty meaning}">
            <p><b>${word}</b> → ${meaning}</p>
        </c:if>
    </div>
</div>
</body>
</html>
