<%@ page language="java" contentType="text/html" import="com.niit.model.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Category</title>
		</head>
	
<body>
	
			<!-- <form action="AddCategory" method="post">-->
	
		<form:form action="AddCategory" modelAttribute="category">
		<table align="center"class="table table-striped table-hover">
		
			<tr>
				<td  align="center" colspan="2">Category Module</td>
			</tr>
		     
		     <tr>
				<td></td>
					
				<td><form:input path="catId" type="hidden"/></td>
			</tr>
		
	
			<tr>
				<td>Category Name</td>
				
				<td><form:input path="catName"/></td>
			</tr>
	
			
	
			<tr>
				<td colspan="2">
				
					<center><input type="submit" value="Insert" class="btn btn-success"/>
				
					
					</center>
				</td>
			</tr>
		</table>
		</form:form><br/>

		
		
		<table class="table table-striped table-hover">
		
			<tr bgcolor="bg-gray">
				<td>Category ID</td>
				<td>Category Name</td>
				
				<td>Operation</td>
			</tr>
	
	
		<c:forEach items="${categoryList}" var="category">
			<tr bgcolor="#fefbd8">
				<td>${category.catId}</td>
				<td>${category.catName}</td>
				
				<td>
						<a href="<c:url value="deleteCategory/${category.catId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
						<a href="<c:url value="editCategory/${category.catId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
				</td>
			</tr>
		</c:forEach>

		</table><br>

	</body>
</html>