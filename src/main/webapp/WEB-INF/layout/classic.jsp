<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	
<!DOCTYPE html>

<html>

<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- Latest compiled and minified CSS -->

<link rel="stylesheet" 
		href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >

<!-- Optional theme -->

<link rel="stylesheet" 
		href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" >

	
<script 
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>		

<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  
<script 
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	
<title><tiles:getAsString name="title"></tiles:getAsString></title>
	
</head>
<body>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>
${current}

<div class="container">

<!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/" />'>PLATCONGELE</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
              
              
              <security:authorize access="hasRole('ROLE_ADMIN')">
                <li class="${current == 'users' ? 'active' : ''}"><a href='<spring:url value="/users.html"/>'>Users</a></li>
                <li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html" />'>Register</a></li>
              </security:authorize>
              <security:authorize access="! isAuthenticated()">
              	<li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html"/>'>Login</a></li>
              </security:authorize>
              
              <security:authorize access="isAuthenticated()">
              	<li class="${current == 'account' ? 'active' : ''}"><a href='<spring:url value="/account.html" />'>Mon compte</a></li>
                <li><a href='<spring:url value="/logout"/>'>Logout</a></li>
              </security:authorize>
               
            </ul>
            
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
</div> <!-- /container -->
  <tiles:insertAttribute name="body"/>
  
  <b/></b>
  
  <tiles:insertAttribute name="footer" />
   <footer class=" container site-footer ">
 	<div class="row">
    	<div class="col-md-5">
    		<h4>Contactez-nous</h4>
    		<address>
    			#4707,Victorin,<br>
    			Montreal,<br>
    			Quebec.
    		</address>
    	</div>
    </div>
    <div class="bottom-footer">
    	<div class="col-md-5">
    		&copy;PlatsCongeles
    	</div>
    	<div class="col-md-7">
    		<ul class="footer-nav">
    			<li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
    			
    			<security:authorize access="! isAuthenticated()">
              		<li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html"/>'>Login</a></li>
             	</security:authorize>
    			
    			<security:authorize access="isAuthenticated()">
                	<li><a href='<spring:url value="/logout"/>'>Logout</a></li>
                </security:authorize>
    			
    		</ul>
    	</div>
    </div>
 </footer>
  
  	
  

  
  
	
</body>
</html>