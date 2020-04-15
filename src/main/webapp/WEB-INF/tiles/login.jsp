<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-10 col-md-offset-1">
    <form class="form-horizontal" name='f' action='${pageContext.request.contextPath}/j_spring_security_check'
          method='POST'>
        <fieldset>

            <!-- Form Name -->
            <legend>Login</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="j_username">Username : </label>
                <div class="col-md-4">
                    <input id="j_username" name="j_username" type="text" placeholder="Username"
                           class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="j_password">Password : </label>
                <div class="col-md-4">
                    <input id="j_password" name="j_password" type="password" placeholder="Password"
                           class="form-control input-md">

                </div>
            </div>

            <!-- Multiple Checkboxes (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="_spring_security_remember_me">Remember me : </label>
                <div class="col-md-4">
                    <label class="checkbox-inline" for="_spring_security_remember_me">
                        <input type="checkbox" checked="checked" name="_spring_security_remember_me"
                               id="_spring_security_remember_me">
                    </label>
                </div>
            </div>

            <c:if test="${param.error}">
                <div class="alert-danger">
                    <span>Incorrect Username or Password</span>
                </div>
            </c:if>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Login</button>
                </div>
            </div>

        </fieldset>
    </form>

    <p><a href="<c:url value="/createaccount"/> ">Create Account</a></p>
</div>

<script>
    $(function () {
        document.f.j_username.focus();
    });
</script>
