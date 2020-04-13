<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring-Home</title>
</head>
<body>
    <p>
        <a href="${pageContext.request.contextPath}/notices">Show Notices</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/createnotice">Create New Notice</a>
    </p>
    <p>
        <a href="<c:url value="/createaccount"/>">Create New Account</a>
    </p>
    <p>
        <a href="<c:url value="/logout"/>">Logout</a>
<%--        <a href="<c:url value="/j_spring_security_logout"/>">Logout</a> default logout_url--%>
    </p>
    <p><a href="<c:url value="/admin"/>">Admin page</a></p>
</body>