 <!-- http://localhost:8081/ContactManager_springmvc-jdbc_servlet_jsp_jstl_maven_junit/ -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit Contact</title>
</head>
<body>

	<div align="center"> 
	<h1>New/Edit Contact</h1>
		<form:form action="save" method="post" modelAttribute="contact" > 
		<table cellpadding="2"> 
    	<form:hidden path="id" /> <%-- differentiate the contact form in new mode value of id is empty, in edit mode is not empty, in MainController: contact.getId() == null --%>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" /></td>
	        </tr>
	   </table>
	</form:form>
	</div>
</body>
</html>