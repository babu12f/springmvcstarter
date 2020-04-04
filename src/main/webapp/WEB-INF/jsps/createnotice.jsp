<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Create Notice</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/docreate">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input name="name" type="text"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input name="email" type="text"/></td>
                </tr>
                <tr>
                    <td>Notice:</td>
                    <td><textarea rows="10" cols="10" name="text"></textarea></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input name="CreateNotice" type="Submit"></td>
                </tr>
            </table>
        </form>

    </div>
</body>
</html>
