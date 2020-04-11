<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Account</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="col-md-8 col-md-offset-2">
        <sf:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
            <fieldset>
                <!-- Form Name -->
                <legend>Create Notice</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="username">Username</label>
                    <div class="col-md-4">
                        <sf:input id="username" path="username" name="username" type="text" placeholder="Enter Your Username"
                               class="form-control input-md" />
                        <sf:errors path="username" cssClass="alert-danger"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email</label>
                    <div class="col-md-4">
                        <sf:input path="email" id="email" name="email" type="text" placeholder="Enter Your Email"
                               class="form-control input-md" />
                        <sf:errors path="email" cssClass="alert-danger"/>
                    </div>
                </div>

                <!-- Password input -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Password</label>
                    <div class="col-md-4">
                        <sf:password id="password" path="password" name="password" placeholder="Enter Your Password"
                                     class="form-control input-md" />
                        <sf:errors path="password" cssClass="alert-danger"/>
                    </div>
                </div>

                <!-- Password input -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="confirmPassword">Confirm Password</label>
                    <div class="col-md-4">
                        <input id="confirmPassword" path="confirmPassword" name="confirmPassword" type="password" placeholder="Re-Enter Your Passweord"
                                     class="form-control input-md" />
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="createAccount"></label>
                    <div class="col-md-4">
                        <button type="submit" id="createAccount" name="createAccount" class="btn btn-primary">
                            Create Account
                        </button>
                    </div>
                </div>

            </fieldset>
        </sf:form>
    </div>
</div>
</body>
</html>
