<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%
 		String path = request.getContextPath();
 		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
 		
 		String ticket = request.getParameter("ticket");
	%>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
	<script type="text/javascript" src="<%=basePath%>views/js/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>views/js/xtjs.js" > </script>
	
		<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="<%=basePath%>views/bootstrap-3.3.5-dist/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） 
	<link rel="stylesheet" href="./views/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
	-->
	<link href="<%=basePath%>views/css/starter-template.css" rel="stylesheet">
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="<%=basePath%>views/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>views/js/index.js?201508121154" > </script>
	
</head>

<body>
	<jsp:include page="/views/jsp/head.jsp" />
    <div class="container">

      <div class="starter-template">
      	
        <div class="btn-group-vertical" role="group" aria-label="...">
        	<div>JSP中直接获取得到的ticket</div> 
        	<input type="text" id="ticket" value="<%=ticket%>"/>
        	<div>accesstoken</div> 
      		<input type="text" id="accesstoken"/>
        	<button type="button" class="btn btn-default" id="ticketByJs">通过JS获取Ticket</button>  			
  			<button type="button" class="btn btn-default" id="accessToken">获取AccessToken</button>
  			<button type="button" class="btn btn-default" id="validAccessToken">校验AccessToken</button>
  			<button type="button" class="btn btn-default" id="getcontext">获取上下文</button>
		</div>
      </div>
	
    </div>
</body>

</html>