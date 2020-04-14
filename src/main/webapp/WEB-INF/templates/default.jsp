<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <tiles:insertAttribute name="header"/>

    <div class="container">
        <tiles:insertAttribute name="content"/>
    </div>

    <div class="container">
        <tiles:insertAttribute name="footer"/>
    </div>

</body>
</html>
