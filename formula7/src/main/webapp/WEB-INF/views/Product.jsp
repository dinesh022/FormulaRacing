<%@ page language="java" import="com.niit.model.Product" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product</title>
</head>
<jsp:include page="header.jsp" />

<body>
	  
		
		<form:form action="InsertProduct" modelAttribute="product" enctype="multipart/form-data">
	
		
		<table align="center"class="table table-striped table-hover">
			<tr>
				<td  align="center" colspan="2">Product Detail</td>
			</tr>	
	
				 <tr>
					<td></td>
					
					<td><form:input path="productId" type="hidden"/></td>
				</tr>
		
			<tr>
				<td>Product Name</td>
				<td><form:input path="productName" class="col-xs-6"/></td>
			</tr>
	
			<tr>
				<td>Product Desc</td>
				<td><form:textarea path="productDesc" class="col-xs-6"/></td>
			</tr>
	
	
			<tr>
				<td>Product Stock</td>
				<td><form:input path="stock" class="col-xs-6"/></td>
			</tr>
	
	
			<tr>
				<td>Product Price</td>
				<td><form:input path="price" class="col-xs-6"/></td>
			</tr>
	
	
			<tr>
				<td>Category</td>
				<td >
					<form:select path="catId" class="col-xs-6">
					<form:option value="0" label="---Select---" class="col-xs-6"/>
					<form:options items="${categoryList}" class="col-xs-6"/>
					</form:select>
				</td>
			</tr>



			<tr>
				<td>Supplier</td>
				<td >
					<form:select path="supplierId" class="col-xs-6">
					<form:option value="0" label="---Select---" class="col-xs-6"/>
					<form:options items="${supplierList}" class="col-xs-6"/>
					</form:select>
				</td>
			</tr>
	
	
			<tr>
				<td>Product Image</td>
				<td><input type="file" name="file" /></td>
			</tr> 
	
	
			<tr>
				<td colspan="2">
					<center><input type="submit" value="Insert" class="btn btn-primary"/></center>
				</td>
			</tr>
	
		</table>
		</form:form>


<table class="table table-striped table-hover">
				<tr bgcolor="bg-gray">
					<td>Product ID</td>
					<td>Product Name</td>
					<td>Product Description</td>
					<td>Product Stock</td>
					<td>Product Price</td>
					<td>Category</td>
					<td>Supplier</td>
					<td>Product Image</td>
					<td>Action</td>
				</tr>
	
	
		<c:forEach items="${productList}" var="product" varStatus="loopCounter">
			<tr bgcolor="#fefbd8">
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.productDesc}</td>
				<td>${product.stock}</td>
				<td>${product.price}</td>
				<td>${product.catId}</td>
				<td>${product.supplierId}</td>
				<td>${product.image}</td>
				<td>
			
						<a href="<c:url value="deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
						<a href="<c:url value="updateProduct/${product.productId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
				</td>
			</tr>
		</c:forEach></table>

	</body>
</html>