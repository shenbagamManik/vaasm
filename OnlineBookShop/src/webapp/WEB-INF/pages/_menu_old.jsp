<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vaasm_style.css">

<div id="navigation">
  <ul>
    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/productList">Product List</a></li>
    <li><a href="${pageContext.request.contextPath}/shoppingCart">My Cart</a></li>
    <li><a href="#about/">About</a></li>
    <li><a href="#contact/">Contact</a></li>
  </ul>
  <security:authorize  access="hasAnyRole('ROLE_MANAGER','ROLE_EMPLOYEE')">
     <a href="${pageContext.request.contextPath}/orderList">
         Order List
     </a>
     |
   </security:authorize>
   
   <security:authorize  access="hasRole('ROLE_MANAGER')">
         <a href="${pageContext.request.contextPath}/product">
                        Create Product
         </a>
         |
   </security:authorize>
</div>
 
 <%-- <div id="page_menu">
	<ul id="menu">
		<li><a href="${pageContext.request.contextPath}/"><span>Home&nbsp;&nbsp;</span>
			<img src="images/menu_home.png" width="40" height="17" alt="Home" /></a></li>
		<!-- <li><a href=""><span>Bestsellers&nbsp;&nbsp;</span>
			<img src="images/menu_bestsellers.gif" width="59" height="14" alt="Bestsellers" /></a></li>
		<li><a href=""><span>Magazines&nbsp;&nbsp;</span>
			<img src="images/menu_magazines.gif" width="57" height="14" alt="Magazines" /></a></li>
		<li><a href=""><span>Bargain&nbsp;&nbsp;</span>
			<img src="images/menu_bargain.gif" width="40" height="14" alt="Bargain" /></a></li>
		<li><a href=""><span>New Releases&nbsp;&nbsp;</span>
			<img src="images/menu_releases.gif" width="75" height="14" alt="New Releases" /></a></li> -->		
		<li><a href=""><span>E-Books&nbsp;&nbsp;</span>
			<img src="images/menu_ebooks.png" width="60" height="17" alt="E-Books" /></a></li>
		<li><a href=""><span>New Releases&nbsp;&nbsp;</span>
			<img src="images/menu_kindelversion.png" width="85" height="17" alt="Kindel Books" /></a></li>
		<li><a href=""><span>Contact&nbsp;&nbsp;</span>
			<img src="images/menu_contacts.png" width="55" height="17" alt="Contact" /></a></li>
	</ul>
</div> --%>


 <%-- <div class="menu-container">
  
   <a href="${pageContext.request.contextPath}/">Home</a>
   |
   <a href="${pageContext.request.contextPath}/productList">
      Product List
   </a>
   |
   <a href="${pageContext.request.contextPath}/shoppingCart">
      My Cart
   </a>
   |
   <security:authorize  access="hasAnyRole('ROLE_MANAGER','ROLE_EMPLOYEE')">
     <a href="${pageContext.request.contextPath}/orderList">
         Order List
     </a>
     |
   </security:authorize>
   
   <security:authorize  access="hasRole('ROLE_MANAGER')">
         <a href="${pageContext.request.contextPath}/product">
                        Create Product
         </a>
         |
   </security:authorize>
  
</div>  --%>