<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="saveUser" />

<form:form  commandName="user" method="post" action="${actionUrl }" class="form-horizontal" >


	<div class="form-group">
		<label for="First Name" class="col-xs-4 control-label">First Name</label>
		<div class="col-xs-4">
			<form:input name="id" path="firstName" placeholder="User First Name" class="form-control" />
		</div>
	</div>
	
	
	
	
	<div class="form-group">
		<label for="First Name" class="col-xs-4 control-label">Last Name</label>
		<div class="col-xs-4">
			<form:input name="id" path="lastName" placeholder="User First Name" class="form-control" />
		</div>
	</div>
	
	
	

	<div class="form-group">
		<label for="Supplier Name" class="col-xs-4 control-label">Email</label>
		<div class="col-xs-4">
			<form:input name="id" path="email" placeholder="User Name" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Password</label>
		<div class="col-xs-4">
			<form:input name="password"  path="password" placeholder="User Password" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Phone Number</label>
		<div class="col-xs-4">
			<form:input name="phone"  path="phone" placeholder="User Phone" class="form-control" />
		</div>
	</div>



	<div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		
		<div class="col-xs-4">
		
			
	
		<input type="submit" value="Add User" id="btn-add" class="btn btn-primary" >
	
	

		
		</div>
	</div>
</form:form>


<%@include file="/WEB-INF/views/footer.jsp" %>
