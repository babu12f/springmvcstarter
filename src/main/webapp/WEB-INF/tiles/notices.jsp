<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <td>${notice.name}</td>
                <td>${notice.email}</td>
                <td><c:out value="${notice.text}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
