<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<html>
    <head>
        <title>FORMULA 007</title>
</head>
<body>
    <nav class= "navbar navbar-inverse">
        <div class="site header container">
           <div class="row justify-content-between"> 
             <div class="col-8 offset-2 col-lg-4 offset-lg-0">
             <img src="<c:url value="/resources/images/Logo.png"/>class="img-fluid mx auto d-block"></img>
        </div>
        <ul class="nav navbar-nav navbar-right">
        <c:if test="${pageContext.request.userPrincipal.name !=null}">
                <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == 'darkknight@gmail.com'}">
                <li><a href="<c:url value="/admin"/>">Admin</a></li>
        </c:if>       
                <li><a  href="<c:url value="/" />">Home</a></li>
                <li><a  href="<c:url value="/productList"/>">Products</a></li>
                
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li><a  href="Register">Register</a></li>
                <li><a href="<c:url value="/login"/>">Login</a></li>
                </c:if>
                </ul>
                
        </div>
        </div>
        </nav>