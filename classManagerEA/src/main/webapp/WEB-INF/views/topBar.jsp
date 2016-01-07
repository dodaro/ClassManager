	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header pull-left">
				<a id="menu-toggle" href="#" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				</a>
	  			<a class="navbar-brand" href="#">
	  				Class Manager
	  			</a>
			</div>			
			<div class="navbar-header pull-right">
        		<a class="nav-bar-button logout" href="./db_init"><span class="glyphicon glyphicon-log-out"></span>InitDB</a>
            	<c:if test="${empty user}">
<!--             		<button type="button" class="btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->
            		<a id="login-button" class="nav-bar-button login" href="#"><span class="glyphicon glyphicon-log-out" ></span>Login</a>
    				<a class="nav-bar-button logout" href="aldo"><span class="glyphicon glyphicon-log-out"></span>Aldo Login</a>
				</c:if>
				<c:if test="${not empty user}">
					<a class="nav-bar-button logout" href="#"><span class="glyphicon glyphicon-log-out"></span><spring:message code="welcome.springmvc" text="default text" /> ${user}</a>
    				<a class="nav-bar-button logout" href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if>
            </div>
	  	</div>
	</nav>