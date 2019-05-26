<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> -->
<!DOCTYPE html>
<html>
<head>
	    <title>Admin Board</title>	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Admin Board</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	    <link type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	    <link type="text/css" href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet"/>
	    <link type="text/css" href="${pageContext.request.contextPath}/resources/images/icons/css/font-awesome.css" rel="stylesheet"/>
	    <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'/>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css"/>
	    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
	    
	    <%-- <script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.9.1.min.js" type="text/javascript"></script> --%>
	    
        <script src="${pageContext.request.contextPath}/resources/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        
        <script src="${pageContext.request.contextPath}/resources/scripts/datatables/jquery.table2excel.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/scripts/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="home-container" style="width: 100vw; height: 100%; display: inline-block;">
		<div class="header-container">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div class="content-container">
			<div class="wrapper" style="height: 80vh;">
				<div class="row" style="height: 100%; width: 100%;">
	                <div class="span3">
						<div class="menu-container" style="height: 83vh; background-color: black;">
							<tiles:insertAttribute name="menu"></tiles:insertAttribute>
						</div>
					</div>
					<div  class="span9">
						<div class="container" style="width: 82vw;">
							<tiles:insertAttribute name="body"></tiles:insertAttribute>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-container" >
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>

</html>