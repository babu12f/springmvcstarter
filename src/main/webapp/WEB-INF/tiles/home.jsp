<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-md-8 col-md-offset-2">
    <sec:authorize access="isAuthenticated()">
        <h2><sec:authentication property="principal.username"/> Notices</h2>
    </sec:authorize>

    <c:choose>
        <c:when test="${notices.size() > 0}">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>@ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Notice</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="notice" items="${notices}">
                        <tr>
                            <td>${notice.id}</td>
                            <td>${notice.user.name}</td>
                            <td>${notice.user.email}</td>
                            <td><c:out value="${notice.text}"/></td>
                            <td>
                                <a href="<c:url value='/editnotice'/>/${notice.id}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:otherwise>
            <h3>You have no notices !!</h3>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${hasNotice}">
            <a href="<c:url value='/createnotice'/>">Edit or delete your current notice</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value='/createnotice'/>">Add a new notice</a>
        </c:otherwise>
    </c:choose>
</div>
