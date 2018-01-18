<%@include file="/WEB-INF/views/header.jsp" %>
     	

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
