<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Manage User</h2>
<div class="col-md-8 col-md-offset-2">
    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Enabled</th>
            <th>Authority</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.enabled}</td>
                <td>${user.authority}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

