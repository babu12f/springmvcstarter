<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    Hello World!!! spring in action
    <h2>
        <%= session.getAttribute("name") %>
    </h2>
</body>