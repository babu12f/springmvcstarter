<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Notice</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="col-md-8 col-md-offset-2">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/docreate">
            <fieldset>
                <!-- Form Name -->
                <legend>Create Notice</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Name</label>
                    <div class="col-md-4">
                        <input id="name" name="name" type="text" placeholder="Enter Your Name"
                               class="form-control input-md">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email</label>
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="Enter Your Email"
                               class="form-control input-md">
                    </div>
                </div>

                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="text">Notice</label>
                    <div class="col-md-4">
                        <textarea class="form-control" id="text" name="text"></textarea>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="createnotice"></label>
                    <div class="col-md-4">
                        <button type="submit" id="createnotice" name="createnotice" class="btn btn-primary">Create
                            Notice
                        </button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
