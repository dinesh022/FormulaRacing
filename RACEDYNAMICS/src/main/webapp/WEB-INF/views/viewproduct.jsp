<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Product Specification</h1>
            
            <p class="lead">Description about the product</p> 
        </div>
        <div class = "container">
             <div class = "row">
                 <div class = "col-md-5">
                    <img src = "#" alt="image" style="width:100%; height:300px"/>
                 </div>
             
             <div class = "col-md-5">
                  <h3>${product.productName}</h3>
                  <p>${product.productDescription}</p>
                  <p>${product.productManufacturer}</p>
                  <p>${product.productCondition}</p>
                  <p>${product.productPrice}INR</p>
             <form action="addToCart/${customerId}/${product.productId}">
			<input type="submit" value="Add to Cart" class="btn btn-primary">

						</form>


             </div>
             
             </div>       
        </div>
       
        
   </div>

</div>
