<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <title>Notices</title>
</head>
<body>

    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>@ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Notice</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="notice" items="${notices}">
                        <tr>
                            <td>${notice.id}</td>
                            <td>${notice.name}</td>
                            <td>${notice.email}</td>
                            <td><c:out value="${notice.text}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>