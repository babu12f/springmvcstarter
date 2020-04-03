<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</body>