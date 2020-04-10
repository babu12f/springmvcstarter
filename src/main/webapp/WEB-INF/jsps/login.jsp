<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login To Spring</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body onload="document.f.j_username.focus()">

<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <form class="form-horizontal" name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
            <fieldset>

                <!-- Form Name -->
                <legend>Login</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="j_username">Username : </label>
                    <div class="col-md-4">
                        <input id="j_username" name="j_username" type="text" placeholder="Username"
                               class="form-control input-md">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="j_password">Password : </label>
                    <div class="col-md-4">
                        <input id="j_password" name="j_password" type="password" placeholder="Password"
                               class="form-control input-md">

                    </div>
                </div>

                <c:if test="${param.error}">
                    <div class="alert-danger">
                        <span>Incorrect Username or Password</span>
                    </div>
                </c:if>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" name="submit" class="btn btn-primary">Login</button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
