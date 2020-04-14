<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<div class="container">
    <div>
        <tiles:insertAttribute name="header"/>
    </div>

    <div>
        <tiles:insertAttribute name="content"/>
    </div>

    <div>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>

</body>
</html>
