<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Notices</title>
</head>
<body>

    <c:forEach var="notice" items="${notices}">
        id: ${notice.id}<br />
        Name: ${notice.name}<br />
        Email: ${notice.email}<br />
        Text: ${notice.text}<br />
        <hr />
    </c:forEach>

</body>