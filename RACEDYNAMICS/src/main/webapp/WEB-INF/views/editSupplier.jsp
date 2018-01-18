<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>


<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Edit Supplier</h1>
            
            <p class="lead">Fill the below information to edit the supplier</p> 
        </div>
        <form:form action="${pageContext.request.contextPath}/admin/supplierInventory/editSupplier" method="post" commandName="supplier">
        <form:hidden path="sid" value="${supplier.sid}"/>
        
         <div class="form-group">
             <label for="name">Name</label>
           <form:input path="supplierName" id="name" class="form-control" value="${supplier.supplierName}"/>
             
        </div>
        
        <br><br>
       <input type="submit"  value="submit"  class = "btn btn-default">
       <a href = "<c:url value="/admin/supplierInventory"/>" class="btn btn-default">Cancel</a>
       
        </form:form>
     </div>
</div>   
        
        <%@include file="/WEB-INF/views/footer.jsp" %>    
        