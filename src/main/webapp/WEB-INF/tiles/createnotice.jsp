<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="col-md-8 col-md-offset-2">
    <sf:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/docreate"
             commandName="notice">
        <fieldset>
            <!-- Form Name -->
            <legend>Create Notice</legend>

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
                    <button type="submit" id="createnotice" name="createnotice" class="btn btn-primary">Create
                        Notice
                    </button>
                </div>
            </div>

        </fieldset>
    </sf:form>
</div>
