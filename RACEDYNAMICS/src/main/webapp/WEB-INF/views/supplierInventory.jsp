<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>



<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Supplier Inventory</h1>
            
            <p class="lead">This is supplier Inventory page</p> 
        </div>
        
        <table class="table table-striped table-hover">
             <thead>
             <tr class="bg-success">
                
              <th>Supplier Name</th>
              <th>Supplier ID</th>
                
               
             </tr>
             </thead>   
            <c:forEach items="${listsupplier}" var="supplier">
             <tr>
               
               <td>${supplier.supplierName}</td>
               <td>${supplier.sid}</td>
              
            
			   
               <td>
                     <a href="<spring:url value="/admin/supplierInventory/deleteSupplier/${supplier.sid}"/>"
                 ><span class="glyphicon glyphicon-remove"></span></a>
                     <a href="<spring:url value="/admin/supplierInventory/editSupplier/${supplier.sid}"/>"
                 ><span class="glyphicon glyphicon-pencil"></span></a>
                 </td>
             </tr> 
            </c:forEach>   
        </table>
        
        
     <a href= "<spring:url value="/admin/supplierInventory/AddSupplier"/>"> <button type="button" class="btn btn-success">Add Supplier</button></a>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>