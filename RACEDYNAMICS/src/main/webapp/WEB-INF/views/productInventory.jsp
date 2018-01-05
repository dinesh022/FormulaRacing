<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>



<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Product Inventory</h1>
            
            <p class="lead">This is product Inventory page</p> 
        </div>
        
        <table class="table table-striped table-hover">
             <thead>
             <tr class="bg-success">
                <th>Photo Image</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>SupplierId</th>
                <th>CategoryId</th>
             </tr>
             </thead>   
            <c:forEach items="${products}" var="product">
             <tr>
                 <td><img src="#" alt="image"/></td>
                 <td>${product.productName}</td>
                 <td>${product.productCategory}</td>
                 <td>${product.productCondition}</td>
                 <td>${product.productPrice}INR</td>
                 <td>${product.sid}</td>
                 <td>${product.cid}</td>
                 <td><a href="<spring:url value="/productInventory/viewproduct/${product.productId}"/>"
                 ><span class="glyphicon glyphicon-info-sign"></span></a>
                     <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>"
                 ><span class="glyphicon glyphicon-remove"></span></a>
                 </td>
             </tr> 
            </c:forEach>   
        </table>
     <a href= "<spring:url value="/admin/productInventory/AddProduct"/>"> <button type="button" class="btn btn-success">Add Product</button></a>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>