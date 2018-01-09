<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>



<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Category Inventory</h1>
            
            <p class="lead">This is category Inventory page</p> 
        </div>
        
        <table class="table table-striped table-hover">
             <thead>
             <tr class="bg-success">
              
                <th>Category Id</th>
                <th>Category Name</th>
                
                
                
             </tr>
             </thead>   
            <c:forEach items="${listcategory}" var="category">
             <tr>
                
                 <td>${category.cid}</td>
                 <td>${category.categoryName}</td>
                 
                
                 
                 <td>
                     <a href="<spring:url value="/admin/categoryInventory/deleteCategory/${category.cid}"/>"
                 ><span class="glyphicon glyphicon-remove"></span></a>
                     <a href="<spring:url value="/admin/categoryInventory/editCategory/${category.cid}"/>"
                 ><span class="glyphicon glyphicon-pencil"></span></a>
                 </td>
             </tr> 
            </c:forEach>   
        </table>
     <a href= "<spring:url value="/admin/categoryInventory/AddCategory"/>"> <button type="button" class="btn btn-success">Add Category</button></a>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>