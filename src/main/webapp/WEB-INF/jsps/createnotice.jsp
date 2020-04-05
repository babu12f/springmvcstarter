<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Notice</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="col-md-8 col-md-offset-2">
        <sf:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/docreate" commandName="notice">
            <fieldset>
                <!-- Form Name -->
                <legend>Create Notice</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Name</label>
                    <div class="col-md-4">
                        <sf:input id="name" path="name" name="name" type="text" placeholder="Enter Your Name"
                               class="form-control input-md" />
                        <sf:errors path="name" cssClass="alert-danger"/>
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

                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="text">Notice</label>
                    <div class="col-md-4">
                        <sf:textarea path="text" class="form-control" id="text" name="text" />
                        <sf:errors path="text" cssClass="alert-danger" />
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
        </sf:form>
    </div>
</div>
</body>
</html>
