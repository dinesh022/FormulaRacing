<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>
            
            <p class="lead">Fill the below information to get registered</p> 
        </div>
        
        <form:form action="saveCustomer" method="post" modelAttribute="customer">
        <h3>Basic info</h3>
        
        <div class = "form-group">
           <label for = "name">Name</label>
           <form:input path="customerName" id="name" class="form-Control"/>
        </div>
        
        <div class = "form-group">
           <label for = "email">UserEmail</label>
           <form:input path="useremail" id="useremail" class="form-Control"/>
        </div>
        
         <div class = "form-group">
           <label for = "phone">Phone</label>
           <form:input path="CustomerPhone" id="phone" class="form-Control"/>
        </div>
        
        <div class = "form-group">
           <label for = "password">Password</label>
           <form:input path="password" id="password" class="form-Control"/>
        </div>
        
        <div class = "form-group">
           <label for = "billingAddress">Billing Address</label>
           <form:input path="billingAddress" id="billingAddress" class="form-Control"/>
        </div>
       
       <br><br>
       <input type="submit"  value="submit"  class = "btn btn-default">
       <a href = "<c:url value="/"/>" class="btn btn-default">Cancel</a>
       
        </form:form>
     </div>
</div>   
        
<%@include file="/WEB-INF/views/footer.jsp" %>