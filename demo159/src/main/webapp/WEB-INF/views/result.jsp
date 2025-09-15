<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Kết quả</h1>

<c:if test="${not empty calcError or not empty calcExpr}">
    <div class="card">
        <h2>Calculator</h2>
        <c:if test="${not empty calcError}">
            <p class="err">${calcError}</p>
        </c:if>
        <c:if test="${empty calcError}">
            <p><strong>${calcExpr}</strong> = <strong>${calcResult}</strong></p>
        </c:if>
    </div>
</c:if>

<c:if test="${not empty selectedCondiments}">
    <div class="card">
        <h2>🥪 Selected Condiments</h2>
        <ul>
            <c:forEach var="s" items="${selectedCondiments}">
                <li>${s}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<a href="${pageContext.request.contextPath}/">back</a>
</body>
</html>
