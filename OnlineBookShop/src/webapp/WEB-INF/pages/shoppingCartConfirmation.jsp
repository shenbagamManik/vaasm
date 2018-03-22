<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart Confirmation</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vaasm_style.css">
</head>
<body>
<div class="shopping_confirm">
  <jsp:include page="_header_old.jsp" />
 
  <jsp:include page="_menu_old.jsp" />
 
  <%-- <fmt:setLocale value="en_US" scope="session"/> --%>
 
  <div class="page-title">Order Confirmation</div>
 <div class="shopping_confirm">
 	<div class="shopping_confirm_top">
 	 <h3>Customer Information:</h3>
      <ul class="ul_top">
          <li> ${myCart.customerInfo.name}</li>
          <li> ${myCart.customerInfo.email}</li>
          <li> ${myCart.customerInfo.phone}</li>
          <li> ${myCart.customerInfo.address}</li>
      </ul>
      
 	</div>
 	<div class="shopping_confirm_middle">
 	<h3>Cart Summary:</h3>
 	
 	
      <ul class="ul_middle_top">
          <li>Items Selected: ${myCart.quantityTotal}</li>
          <li>Total Cost:
          <span class="total">
            <fmt:formatNumber value="${myCart.amountTotal}" type="currency"/>
          </span></li>          
      </ul>
      
       <c:forEach items="${myCart.cartLines}" var="cartLineInfo">
          <div class="clearfix">
              <ul>
                  <li><img class="img2"
                      src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}"  width="50" height="100"/></li>                  
                  <li class= "ul_middle_text">${cartLineInfo.productInfo.name}</li>
                  <li class= "ul_middle_text">
                     <fmt:formatNumber value="${cartLineInfo.productInfo.price}" type="currency"/>
                  
                  </li>
                  <li class= "ul_middle_text"> ${cartLineInfo.quantity}</li>
                  <li class= "ul_middle_text">
                    
                       <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                    
                  </li>
              </ul>
          </div>
      </c:forEach></div>
 	<div class="shopping_confirm_bottom">
 	 <form method="POST"
      action="${pageContext.request.contextPath}/shoppingCartConfirmation">
 
      <!-- Edit Cart -->
      <a class="navi-item"
          href="${pageContext.request.contextPath}/shoppingCart">Edit Cart</a>
 
      <!-- Edit Customer Info -->
      <a class="navi-item"
          href="${pageContext.request.contextPath}/shoppingCartCustomer">Edit
          Customer Info</a>
 
      <!-- Send/Save -->
      <input type="submit" value="Send" class="button-send-sc" />
  </form>
 	</div>
 </div>
 
 </div>
  <%-- <div class="customer-info-container">
      <h3>Customer Information:</h3>
      <ul>
          <li>Name: ${myCart.customerInfo.name}</li>
          <li>Email: ${myCart.customerInfo.email}</li>
          <li>Phone: ${myCart.customerInfo.phone}</li>
          <li>Address: ${myCart.customerInfo.address}</li>
      </ul>
      <h3>Cart Summary:</h3>
      <ul>
          <li>Quantity: ${myCart.quantityTotal}</li>
          <li>Total:
          <span class="total">
            <fmt:formatNumber value="${myCart.amountTotal}" type="currency"/>
          </span></li>
      </ul>
  </div>
 
  <form method="POST"
      action="${pageContext.request.contextPath}/shoppingCartConfirmation">
 
      <!-- Edit Cart -->
      <a class="navi-item"
          href="${pageContext.request.contextPath}/shoppingCart">Edit Cart</a>
 
      <!-- Edit Customer Info -->
      <a class="navi-item"
          href="${pageContext.request.contextPath}/shoppingCartCustomer">Edit
          Customer Info</a>
 
      <!-- Send/Save -->
      <input type="submit" value="Send" class="button-send-sc" />
  </form>
 
  <div class="container">
 
      <c:forEach items="${myCart.cartLines}" var="cartLineInfo">
          <div class="product-preview-container">
              <ul>
                  <li><img class="product-image"
                      src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}" /></li>
                  <li>Code: ${cartLineInfo.productInfo.code} <input
                      type="hidden" name="code" value="${cartLineInfo.productInfo.code}" />
                  </li>
                  <li>Name: ${cartLineInfo.productInfo.name}</li>
                  <li>Price: <span class="price">
                     <fmt:formatNumber value="${cartLineInfo.productInfo.price}" type="currency"/>
                  </span>
                  </li>
                  <li>Quantity: ${cartLineInfo.quantity}</li>
                  <li>Subtotal:
                    <span class="subtotal">
                       <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                    </span>
                  </li>
              </ul>
          </div>
      </c:forEach>
 
  </div>
 </div> --%>
<%--  <jsp:include page="_footer.jsp" /> --%>
 
</body>
</html>