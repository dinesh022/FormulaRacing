<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>



<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>All products</h1>
            
            <p class="lead">Check out all the products available now!</p> 
        </div>
        
        <table class="table table-striped table-hover">
             <thead>
             <tr class="bg-success">
                <th>Photo Image</th>
                <th>Product Name</th>
              
                <th>Condition</th>
                <th>Price</th>
               
             </tr>
             </thead>   
            <c:forEach items="${products}" var="product">
             <tr>
                 <td><img src="#" alt="image"/></td>
                 <td>${product.productName}</td>
                 
                 <td>${product.productCondition}</td>
                 <td>${product.productPrice}INR</td>
                 
                 <td><a href="productList/viewproduct/${product.productId}">
                 <span class="glyphicon glyphicon-info-sign"></span></a></td>
             </tr> 
            </c:forEach>   
        </table>
        
   </div>

</div>
<%@include file="/WEB-INF/views/footer.jsp" %>