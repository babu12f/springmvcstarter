<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-8 col-md-offset-2">
    <sf:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/docreate"
             commandName="notice">
        <fieldset>
            <!-- Form Name -->
            <legend>Create Notice</legend>
            <sf:hidden path="id" name="id"/>
            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="text">Notice</label>
                <div class="col-md-4">
                    <sf:textarea path="text" class="form-control" id="text" name="text"/>
                    <sf:errors path="text" cssClass="alert-danger"/>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createnotice"></label>
                <div class="col-md-4">
                    <button type="submit" id="createnotice" name="createnotice" class="btn btn-primary">Save Notice</button>
                </div>
            </div>

            <c:if test="${notice.id != 0}">
                <div class="form-group">
                    <label class="col-md-4 control-label" for="createnotice"></label>
                    <div class="col-md-4">
                        <button type="submit" id="delete" name="delete" class="btn btn-primary">Delete Notice</button>
                    </div>
                </div>
            </c:if>

        </fieldset>
    </sf:form>
</div>
