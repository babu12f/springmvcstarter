<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">Spring App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/"/>">Home</a></li>
                <li><a href="<c:url value="/notices"/>">Notices</a></li>
                <li><a href="<c:url value="/createnotice"/>">Create notice</a></li>
                <li><a href="<c:url value="/createaccount"/>">Create account</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="<c:url value="/admin"/>">Admin</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="">Hi <sec:authentication property="principal.username"/></a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li>
                        <a href="<c:url value='/login' />">Log in</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <a href="<c:url value='/logout' />">Log out</a>
                        <%--<a href="<c:url value="/j_spring_security_logout"/>">Logout</a> default logout_url--%>
                    </li>
                </sec:authorize>

            </ul>
        </div>
    </div>
</nav>