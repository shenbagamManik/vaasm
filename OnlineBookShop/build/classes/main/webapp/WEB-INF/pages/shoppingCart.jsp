<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vaasm_style.css">
 
</head>
<body>
 <div class="productlist">
   <jsp:include page="_header_old.jsp" />
  
   <jsp:include page="_menu_old.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   
 
   <c:if test="${empty cartForm or empty cartForm.cartLines}">
       <h2>There is no items in Cart</h2>
       <a href="${pageContext.request.contextPath}/productList">Show
           Product List</a>
   </c:if>
 
   <c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
       <form:form method="POST" modelAttribute="cartForm"
           action="${pageContext.request.contextPath}/shoppingCart">
 <div class="productlist_books">
           <c:forEach items="${cartForm.cartLines}" var="cartLineInfo" varStatus="varStatus">
               <div class="pl_column">
               <img src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}" width="150" height ="200"/>
                   <ul>
                      
                       <li>Code: ${cartLineInfo.productInfo.code} <form:hidden
                               path="cartLines[${varStatus.index}].productInfo.code" />
 
                       </li>
                       <li>Name: ${cartLineInfo.productInfo.name}</li>
                       <li>Price: 
                      
                         <fmt:formatNumber value="${cartLineInfo.productInfo.price}" type="currency"/>
                        
                       </span></li>
                       <li>Quantity: <form:input
                               path="cartLines[${varStatus.index}].quantity" /></li>
                       <li>Subtotal:
                         <span class="subtotal">
                        
                            <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                      
                         </span>
                       </li>    
                       <li>  <span><a href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?code=${cartLineInfo.productInfo.code}"> Delete </a></span>
                                  
                   </ul>
                   
               </div>
           </c:forEach>
         </div>  
           <div class="productlist_menu" >
           
           <%-- <a href="${pageContext.request.contextPath}/shoppingCartCustomer">Enter
               Customer Info</a> --%>
             <a href="${pageContext.request.contextPath}/shoppingCartCustomer">Place Order</a> 
          <a href="${pageContext.request.contextPath}/productList">Continue
               Buy</a>
          
            
            </div>
       </form:form> 
   </c:if>
 </div><!--End of product list div  -->
 
    <div class="footer">
  <jsp:include page="_footer_old.jsp" />
  </div>>
 
</body>
</html>