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
     	

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="<c:url value="/resources/images/1.jpg"/> alt="first">
    </div>
    <div class="item">
      <img src="<c:url value="/resources/images/2.jpg"/> alt="second">
    </div>

    <div class="item">
     <img src="<c:url value="/resources/images/3.jpg"/> alt="third">
    </div>
  </div>
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<footer class="container">
        
        <p>&copy; FORMULA 007 Company, Inc. RACE DYNAMICS; <a href="#">Privacy</a>; <a href="#">Terms</a></p>
      </footer>
   </body>
</html>
