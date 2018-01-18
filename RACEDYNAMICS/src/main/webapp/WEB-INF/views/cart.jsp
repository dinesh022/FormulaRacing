s<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container-wrapper">
<div class="container">
<section>
       <div class="jumbotron">
       <div class="container">
       <h1>Cart</h1>
       <p>All the selected products in your cart</p>
       </div>
       </div>
</section>   

<section class="container" ng-app="cartApp">
<div ng=controller = "cartCtrl" ng-init = "initCartId('${cartId}')"></div>
    <div>
         <a class="btn-btn-danger pull-left" ng-click="Clear Cart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
    </div>  
    
   <table class= "table table-hover">
    <tr>
        <th>Product</th>
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    
    <c:forEach items="${Listcart}" var="cart">    
    
    
 
        <td>${cart.pname}</td>
        <td>${cart.price}</td>
        <td>${cart.quantity}</td>
        
      
        <td>${cart.quantity*cart.price}</td>


    <tr>
        <th></th>
        <th></th>
        <th>Grand Total</th>
        <th> <td>${cart.quantity*cart.price}</td></th>
        <th></th>
    <tr>
     </c:forEach>
   </table>
   
   <a href  = "<spring:url value="/productList"/>class="btn-btn-default">Continue Shopping</a> 
   </div>
</section>
</div>
</div>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/footer.jsp" %>
    
    