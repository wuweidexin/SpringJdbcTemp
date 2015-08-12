<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
          data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">轻应用开发样例</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/views/jsp/tiketVerification.jsp">Tiket验证方案</a></li>
            <li><a href="${pageContext.request.contextPath}/views/jsp/jsbradge.jsp">JsBradge</a></li>
            <li><a href="#about">组织管理</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>