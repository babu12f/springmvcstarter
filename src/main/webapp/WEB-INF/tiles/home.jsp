<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<p><a href="${pageContext.request.contextPath}/notices">Show Notices</a></p>

<p><a href="${pageContext.request.contextPath}/createnotice">Create New Notice</a></p>

<p><a href="<c:url value="/createaccount"/>">Create New Account</a></p>

<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value="/login"/>">Login</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p><a href="<c:url value="/logout"/>">Logout</a></p>
</sec:authorize>
<%--<a href="<c:url value="/j_spring_security_logout"/>">Logout</a> default logout_url--%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value="/admin"/>">Admin page</a></p>
</sec:authorize>