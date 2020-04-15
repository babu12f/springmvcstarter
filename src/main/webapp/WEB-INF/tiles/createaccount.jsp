<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="col-md-10 col-md-offset-1">
    <sf:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/createaccount"
             commandName="user">
        <fieldset>
            <!-- Form Name -->
            <legend>Create Notice</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="username">Username : </label>
                <div class="col-md-4">
                    <sf:input id="username" path="username" name="username" type="text"
                              placeholder="Enter Your Username"
                              class="form-control input-md"/>
                    <sf:errors path="username" cssClass="alert-danger"/>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email : </label>
                <div class="col-md-4">
                    <sf:input path="email" id="email" name="email" type="text" placeholder="Enter Your Email"
                              class="form-control input-md"/>
                    <sf:errors path="email" cssClass="alert-danger"/>
                </div>
            </div>

            <!-- Password input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password : </label>
                <div class="col-md-4">
                    <sf:password id="password" path="password" name="password" placeholder="Enter Your Password"
                                 class="form-control input-md"/>
                    <sf:errors path="password" cssClass="alert-danger"/>
                </div>
            </div>

            <!-- Password input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="confirmPassword">Confirm Password : </label>
                <div class="col-md-4">
                    <input id="confirmPassword" name="confirmPassword" type="password"
                           placeholder="Re-Enter Your Password"
                           class="form-control input-md"/>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createAccount"></label>
                <div class="col-md-4">
                    <button type="submit" id="createAccount" name="createAccount" class="btn btn-primary">
                        Create Account
                    </button>
                </div>
            </div>

        </fieldset>
    </sf:form>
</div>

<script>
    var password1 = document.getElementById('password');
    var password2 = document.getElementById('confirmPassword');
    var checkPasswordValidity = function () {
        if (password1.value != password2.value) {
            password1.setCustomValidity('<fmt:message key="passwords.must.match"/>');
        } else {
            password1.setCustomValidity('');
        }
    };
    password1.addEventListener('change', checkPasswordValidity, false);
    password2.addEventListener('change', checkPasswordValidity, false);
    var form = document.getElementById('user');
    form.addEventListener('submit', function (e) {
        checkPasswordValidity();
        if (!this.checkValidity()) {
            e.preventDefault();
            password1.focus();
        }
    }, false);
</script>
