<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../layout/taglib.jsp" %>
    <style>
  .errors{
  color: red;
  }
</style>
      <div class="container">
    <form:form commandName="user" cssClass="form-horizontal">
    
    		  <c:if test="${param.success eq true }">
			    	<div class="alert alert-success">
			    		Registration successfull!
			    	</div>
			  </c:if>
    		
	    	<div class="form-group">
	    		<label for="name" class="col-sm-2 control-label">Nom :</label>
	    		<div class="col-sm-10">
	    			<form:input path="userName" cssClass="form-control" placeholder="name"/>
	    			<form:errors path="userName" cssClass="errors"/>
	    		</div>
	    	</div>
	    	<div class="form-group">
	    		<label for="password" class="col-sm-2 control-label">Password :</label>
	    		<div class="col-sm-10">
	    			<form:password path="password" cssClass="form-control" placeholder="password"/>
	    			<form:errors path="password" cssClass="errors" />
	    		</div>
	    	</div>
	    	<div class="form-group">
	    		<label  class="col-sm-2 control-label">Roles :</label>
	    		<div class="col-sm-10">
	    			<form:select  path="roles" cssClass="form-control" items="${roles}"
	    			itemLabel="roleName" itemValue="roleName"/>
	    			<form:errors path="roles" cssClass="errors"/>
	    		</div>
	    	</div>
	    	<div class="form-group">
	    		<div class="col-sm-2">
	    			<input type="submit" value="save" class="btn btn-lg btn-primary" />
	    		</div>
	    	</div>
	    
	    </form:form>
    </div>
    