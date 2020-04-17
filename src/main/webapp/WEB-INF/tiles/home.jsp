<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                <td>${notice.user.name}</td>
                <td>${notice.user.email}</td>
                <td><c:out value="${notice.text}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:choose>
        <c:when test="${hasNotice}">
            <a href="<c:url value='/createnotice'/>">Edit or delete your current notice</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value='/createnotice'/>">Add a new notice</a>
        </c:otherwise>
    </c:choose>
</div>
