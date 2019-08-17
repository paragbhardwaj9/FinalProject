<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Grocery Form</title>
</head>
<body>
  <h1>Edit Grocery Form</h1>
  <form:form action="updateGrocery.obj" modelAttribute="grocery">
      <table border="1" >
         <tr>
            <td>Item ID</td>
            <td><form:input path="id" readonly="true" /> 
            <form:errors path="id" /></td>
         </tr>
         <tr>
            <td>Item Name</td>
            <td><form:input path="name" /> 
            <form:errors path="name" /></td>
         </tr>
         <tr>
            <td>Price(Rs)</td>
            <td><form:input path="price"/> 
               <form:errors path="price" /> </td>
         </tr>
         <tr>
            <td>Category</td>
            <td><form:select path="category">
                  <form:option value="Select"></form:option>
                  <form:options items="${clist}" />
                 </form:select> 
               <form:errors path="category" /> </td>
         </tr>
         <tr>
            <td>Quantity</td>
            <td><form:input path="quantity"/> 
               <form:errors path="quantity" /> </td>
         </tr>
         <tr>
            <td>Unit</td>
            <td><form:input path="unit"/> 
               <form:errors path="unit" /> </td>
         </tr>
         <tr>
            <td>Description</td>
            <td><form:input path="description"/> 
               <form:errors path="description" /> </td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value="Update Grocery"> </td>
         </tr>
         <tr>
            <td colspan="2"><a href ="goHome.obj">Go Home</a></td>
         </tr>
   </table>
  </form:form>
</body>
</html>
