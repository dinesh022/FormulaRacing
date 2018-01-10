 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>


<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            
            <p class="lead">Fill the below information to edit the product</p> 
        </div>
        
        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="post" commandName="product"
        enctype = "multipart/form-data">
        <form:hidden path="productId" value="${product.productId}"/>
        <div class="form-group">
             <label for="name">Name</label>
           <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
        </div>
        
       
       
       <div class="form-group">
             <label for="description">Description</label>
           <form:textarea path="productDescription" id="description" class="form-control" value="${product.productDescription}"/>
        </div>
       
        <div class="form-group">
             <label for="price">Price</label>
           <form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>
        </div>
       
     <div class="form-group">
            <label for = "condition">Condition</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                               value="new"/>New</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                               value="used"/>Used</label>
      
       </div>
       
        <div class="form-group">
            <label for = "status">Status</label>
            <label class = "checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                               value="available"/>Available</label>
            <label class = "checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                               value="soldout"/>Soldout</label>
       </div>
       
       <div class="form-group">
            <label for = "unitinstock">UnitInStock</label>
            <form:input path="unitinStock" id="unitinstock" class="form-Control" value="${product.unitinStock}"/>
       </div>
       
       <div class="form-group">
            <label for = "manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control" value="${product.productManufacturer}"/>
       </div>
       
       <div class="form-group">
            <label class = "control-label" for="productImage" >Upload picture</label>
            <form:input path="productImage" id="productImage" type="file"  class="form:input-large"/>
       </div>
       
       
       <br><br>
       <input type="submit"  value="submit"  class = "btn btn-default">
       <a href = "<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
       
        </form:form>
     </div>
</div>   
        
<%@include file="/WEB-INF/views/footer.jsp" %>