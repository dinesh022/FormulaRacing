<%@ page language="java" contentType="text/html" import="com.niit.model.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supplier</title>


</head>
<jsp:include page="header.jsp" />

<body>
	  
	
			<!-- <form action="AddSupplier" method="post">-->

	<form:form action="AddSupplier" modelAttribute="supplier">
				<table align="center"class="table table-striped table-hover">
			<tr>
				<td align= "center" colspan="2">Supplier Module</td>
			</tr>
			
			
	 
			 <tr>
				<td></td>
					<!-- <td><input type="text" name="catName"/></td> -->
				<td><form:input path="supplierId" type="hidden"/></td>
			</tr>
		
			<tr>
				<td>Supplier Name</td>
				<!-- <td><input type="text" name="supplierName"/></td> -->
				<td><form:input path="supplierName"/></td>
			</tr>
		
			<tr>
				<td >Supplier Address</td>
				<!-- <td><input type="text" name="supplierAddress"/></td> -->
				<td><form:input path="supplierAddress"/></td>
			</tr>
	
		<tr>
			<td colspan="2">
				<center><input type="submit" value="Insert" class="btn btn-success"/>
				</center>
			</td>
		</tr>
	</table>
	</form:form>


<table class="table table-striped table-hover">
	<tr bgcolor="bg-gray">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${supplierList}" var="supplier">
		<tr bgcolor="#fefbd8">
			<td>${supplier.supplierId}</td>
			<td>${supplier.supplierName}</td>
			<td>${supplier.supplierAddress}</td>
			<td>
			
				<a href="<c:url value="deleteSupplier/${supplier.supplierId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
				<a href="<c:url value="updateSupplier/${supplier.supplierId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
			</td>
		</tr>
	</c:forEach>

</table>
		

</body>
</html>