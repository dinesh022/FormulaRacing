<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>


<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Edit Category</h1>
            
            <p class="lead">Fill the below information to edit the Category</p> 
        </div>
        
        <form:form action="${pageContext.request.contextPath}/admin/categoryInventory/editCategory" method="post" commandName="category">
         <form:hidden path="cid" value="${category.cid}"/>
        
        <div class="form-group">
             <label for="name">Name</label>
            
           <form:input path="categoryName" id="name" class="form-control" value="${category.categoryName}"/>
        </div>
        
        
        
       <br><br>
       <input type="submit"  value="submit"  class = "btn btn-default">
       <a href = "<c:url value="/admin/categoryInventory"/>" class="btn btn-default">Cancel</a>
       
        </form:form>
     </div>
</div>   
        
<%@include file="/WEB-INF/views/footer.jsp" %>