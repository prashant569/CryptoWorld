<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<spring:url value="/login" var="LoginAndRegisterUrl" />
<spring:url value="register" var="registerUrl" />
<spring:url value="/" var="loginUrl" />
<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/home" var="homeUrl" />
<spring:url value="/coinMarketCap" var="coinMarketCapUrl" />

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${homeUrl}">Home</a>
    </div>
    <ul class="nav navbar-nav">
		 <li><a href="${coinMarketCapUrl}">CoinMarketCap</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
   		
	   	<security:authorize access="isAuthenticated()">
	   		<li id="username"><a> Welcome <security:authentication property="principal.username" /> </a></li>
	   		<li><a href="${logoutUrl}"> <button type="submit" class='btn btn-default btn-sm'><span class='glyphicon glyphicon-log-out'></span>Log out</button></a></li>
		</security:authorize>

    	
    	<security:authorize access="!isAuthenticated()">
	   			<li><a href="${registerUrl}"><span class="glyphicon glyphicon-user"></span>Register </a></li>
	   			<li><a href="${loginUrl}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	   	</security:authorize>

    </ul>
  </div>
</nav>


