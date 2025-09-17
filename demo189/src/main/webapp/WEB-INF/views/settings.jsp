<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mail Settings</title>
</head>
<body>
<h2>Mail Settings</h2>

<form:form method="post" modelAttribute="mail">
    <p>
        <label>Language: </label>
        <form:select path="language">
            <form:options items="${languages}"/>
        </form:select>
    </p>

    <p>
        <label>Page size:Show </label>
        <form:select path="pageSize">
            <form:options items="${pageSizes}"/>
        </form:select>
        emails per page
    </p>

    <p>
        Spams fillters:
        <form:checkbox path="spamFilter"/> Enable spam filter
    </p>

    <p>
        <label>Signature:</label><br>
        <form:textarea path="signature"/>
    </p>

    <button type="submit">Update</button>
</form:form>

<c:if test="${saved}">
    <p>được lưu</p>
</c:if>

</body>
</html>

