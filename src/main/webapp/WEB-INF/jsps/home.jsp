<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring-mvc start</title>
</head>
<body>
    <p>
        using (jstl) <c:out value="${name}"></c:out>
    </p>
    <p>
        using (EL): ${name}
    </p>

    <sql:query var="rs" dataSource="jdbc/TestDB">
        select id, name, email, text from notices
    </sql:query>

    <c:forEach var="row" items="${rs.rows}">
        id: ${row.id}<br />
        Name: ${row.text}<br />
    </c:forEach>
</body>