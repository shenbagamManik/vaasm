<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vaasm_style.css">

<div id="header">
  <h1><a href="#00"><img src="images/VAASM_LOGO_2.png" width="60" height="60" alt="logo" class="captionated" /></a><a href="#00"><img src="images/title.png" width="550" height="60" alt="logo" class="captionated" /></a><a><span>Find:</span><input type="text" /><input type="image" src="images/search_icon.gif" class="submit" /></a>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
        Hello
           <a href="${pageContext.request.contextPath}/accountInfo">
                ${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">    Logout</a>
 
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
		<!--  <form method="post" action="">
		
		<span>Find:</span>
		<input type="text" />input type="image" src="images/search_button.gif" class="submit" />
		
		</form>  -->
  </h1>
  <div id="header_search">
		
	</div> 
</div>







<%-- <div id="page_header">
	<div id="page_title">
	<h1>
	<img src="images/header_logo.gif" width="25" height="26" alt="" />
	<span><img src="images/pageTitle.png" width="25" height="26" alt="" /></span>
	</h1>
	
	</div>
	
	 <div id="header_search">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
        Hello
           <a href="${pageContext.request.contextPath}/accountInfo">
                ${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout"><img src="images/logout.jpg" width="70" height="20" alt="" /></a>
 
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login"><img src="images/LOGIN.jpg" width="70" height="20" alt="" /></a>
        </c:if>
		<form method="post" action="">
		<div>
		<h3><span>Find:</span></h3>
		<input type="text" />
		<input type="image" src="images/search_button.gif" class="submit" />
		</div>
		</form>
	</div> 
</div> --%>

 
<%--  <div class="header-container">
 
    <div class="site-name">Online Shop</div>
 
    <div class="header-bar">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        Hello
           <a href="${pageContext.request.contextPath}/accountInfo">
                ${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a>
 
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
    </div>
</div>  --%>