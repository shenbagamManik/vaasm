<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Enter Customer Information</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vaasm_style.css">
 
</head>
<body>
<div class="customer_information">
<jsp:include page="_header_old.jsp" />
<jsp:include page="_menu_old.jsp" />
 
<div class="page-title">Enter Customer Information</div>
 <div class="table_design">
 
     
   <form:form method="POST" modelAttribute="customerForm"
       action="${pageContext.request.contextPath}/shoppingCartCustomer">
       
 
       <table >
           <tr class="container"><td>Name *</td></tr>
           <tr class="container">
           	<td><form:input path="name" placeholder="Your name.."/></td>
           	<td><font color="red"><form:errors path="name" /></font></td>
           </tr>
 			<tr class="container"><td>Email *</td></tr>
           <tr class="container">             
               <td><form:input path="email" placeholder="Your Email.."/></td>
               <td><font color="red"><form:errors path="email"  /></font></td>
           </tr>
 			<tr class="container"><td>Phone *</td></tr>
           <tr class="container">               
               <td><form:input path="phone" placeholder="Your Mobile Number.."/></td>
               <td><font color="red"><form:errors path="phone" /></font></td>
           </tr>
 			<tr class="container"><td>Address *</td></tr>
           <tr class="container">              
               <td><form:input path="address" placeholder="Your Address.."/></td>
               <td><font color="red"><form:errors path="address" /></font></td>
           </tr>  			
           <tr >              
               <td align="center"><input type="submit" value="Submit" class="button"/> <input type="reset" value="Reset" class="button"/></td>
           </tr>
      </table>
 
   </form:form>
   
 </div>
 </div>
   <jsp:include page="_footer.jsp" />
 
 
</body>
</html>