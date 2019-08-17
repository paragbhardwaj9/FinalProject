<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grocery List</title>
<script>
   function check() {
      var retVal = confirm("Do you want to delete Item");
      if(!retVal){
         return false;
      }
   }
</script>
</head>
<body>
  <c:choose>
     <c:when test="${glist.size()>0}">
      <h2><center>Online Grocery Shop</center></h2>
  <h3><center>Available Items</center></h3>
  <table border="2" align="center" bgcolor="cyan">
   <tr>
      <td><b>Grocery Id</b></td>
      <td><b>Name</b></td>
      <td><b>Price(Rs)</b></td>
      <td><b>Quantity</b></td>
      <td><b>Unit</b></td>
      <td><b>Category</b></td>
      <td><b>Description</b></td>
      <td colspan="2"><b>Action</b></td>
   </tr>
     <c:forEach var="gitem" items="${glist}">
    <tr>
   <td>${gitem.id}</td> 
   <td>${gitem.name}</td>
   <td>${gitem.price}</td>
   <td>${gitem.quantity}</td>
   <td>${gitem.unit}</td>
   <td>${gitem.category}</td>
   <td>${gitem.description}</td>
   <td><a href="editGrocery.obj?grocid=${gitem.id}">Edit Grocery</a></td>
   <td><a href="deleteGrocery.obj?grocid=${gitem.id}" onclick="return check()">Delete Item</a></td>
</tr>
</c:forEach>   
  </table>
     </c:when>
     <c:otherwise>
       <h3><center>No Data Found</center></h3>
     </c:otherwise>
  </c:choose>
</body>
</html>