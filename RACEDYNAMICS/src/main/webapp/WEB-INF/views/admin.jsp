<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>



<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Adminstrator</h1>
            
            <p class="lead">Adminstrator Page</p> 
        </div>
        
        <c:if test = "${pageContext.request.userPrincipal.name !=null}">
           <h2>
               Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url
               value="/j_spring_security_logout"/>">Logout</a>
           </h2>
           </c:if>
        
        <h3>
           <a href="admin/productInventory">product Inventory</a>
           <a href="admin/categoryInventory">category Inventory</a>
           <a href="admin/supplierInventory">supplier Inventory</a>
           
        </h3>
     <p>Here you can do the CRUD operations!</p>   
        
        
<%@include file="/WEB-INF/views/footer.jsp" %>