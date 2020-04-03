<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring-mvc start</title>
</head>
<body>
    <h2>
        <%= request.getAttribute("name") %>
    </h2>
    <h2>
        using expression language: ${name}
    </h2>
</body>