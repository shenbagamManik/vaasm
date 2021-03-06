<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vaasm_style.css">
 
</head>
<body>
 <div class="productlist">
   <jsp:include page="_header_old.jsp" />
   <jsp:include page="_menu_old.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
  <!--  <div class="page-title">Product List</div> -->
 
<div class="row">
  <c:forEach items="${paginationProducts.list}" var="prodInfo">
  <div class="pl_column">
 
    <img src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}" width="150" height ="200"/>
    <ul>
    <li>Code: ${prodInfo.code}</li>
    <li>Name: ${prodInfo.name}</li>
    <li>Price: <fmt:formatNumber value="${prodInfo.price}" type="currency"/></li>
    <li><span><a href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">Buy Now</a></span>  </li>
    <li><span>
    <security:authorize  access="hasRole('ROLE_MANAGER')">
    <a style="color:red;" href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">Edit Product</a> 
    </security:authorize>    
    </span></li>
    </ul>
    
     <!-- For Manager edit Product -->
     
   
  </div> 
    </c:forEach>
  </div>
  
<%-- </div>
       <div class="product-preview-container">
       <p><a href></a></p>
           <column>
              <li></li>
               <li>Code: ${prodInfo.code}</li>
               <li>Name: ${prodInfo.name}</li>
               <li>Price: <fmt:formatNumber value="${prodInfo.price}" type="currency"/></li>
               <li><a
                   href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
                       Buy Now</a></li>
               <!-- For Manager edit Product -->
               <security:authorize  access="hasRole('ROLE_MANAGER')">
                 <li><a style="color:red;"
                     href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">
                       Edit Product</a></li>
               </security:authorize>
           </ul>
       </div>
 
   </c:forEach>
   <br/>
   --%>
 
    <c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="productList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if> 
 </div>
  <div class="footer">
  <jsp:include page="_footer_old.jsp" />
  </div>
 
</body>
</html>