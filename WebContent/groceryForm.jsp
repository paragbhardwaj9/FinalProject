<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<style>
  .err{
    color:red; 
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grocery Form</title>
</head>
<body>
	<h1>Grocery Form</h1>
	${grocery}
	 <form:form action="submitGrocery.obj" modelAttribute="grocery">
      <table border="1" >
         <tr>
            <td>Item Name</td>
            <td><form:input path="name" /> 
            <form:errors class="err" path="name" /></td>
         </tr>
         <tr>
            <td>Price(Rs)</td>
            <td><form:input path="price"/> 
               <form:errors class="err" path="price" /> </td>
         </tr>
         <tr>
            <td>Category</td>
            <td><form:select path="category">
                  <form:option value="Select"></form:option>
                  <form:options items="${clist}" />
                 </form:select> 
               <form:errors class="err" path="category" /> </td>
         </tr>
         <tr>
            <td>Quantity</td>
            <td><form:input path="quantity"/> 
               <form:errors class="err" path="quantity" /> </td>
         </tr>
         <tr>
            <td>Unit</td>
            <td><form:input path="unit"/> 
               <form:errors class="err" path="unit" /> </td>
         </tr>
         <tr>
            <td>Description</td>
            <td><form:input path="description"/> 
               <form:errors class="err" path="description" /> </td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value="Add Grocery"> </td>
         </tr>
         <tr>
            <td colspan="2"><a href ="goHome.obj">Go Home</a></td>
         </tr>
   </table>
  </form:form>
</body>
</html>