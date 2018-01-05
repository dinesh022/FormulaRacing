<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>


<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Add Supplier</h1>
            
            <p class="lead">Fill the below information to add the supplier</p> 
        </div>
        
        <form:form action="${pageContext.request.contextPath}/supplieradmin/supplierInventory/AddSupplier" method="post" commandName="supplier">
        <div class="form-group">
             <label for="name">Name</label>
           <form:input path="supplierName" id="name" class="form-control"/>
        </div>
       
    
       <br><br>
       <input type="submit"  value="submit"  class = "btn btn-default">
       <a href = "/supplieradmin/supplierInventory" class= "btn btn-default">cancel</a>
       
        </form:form>
     </div>
</div>   
        
        <%@include file="/WEB-INF/views/footer.jsp" %>