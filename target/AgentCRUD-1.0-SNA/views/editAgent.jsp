<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Update Details</title>
    </head>
  
        <h3>Update The Agent Details!</h3>
        <c:url value="/agent/editAgent" var="action"></c:url> 
        <form:form method="POST" action="${action}" modelAttribute="agent">
     
            <table>
                <tr>
                    <td><form:label path="agentId">ID</form:label></td>
                    <td><form:input path="agentId" value="${agent.agentId}"/></td> 
               </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name" value="${agent.name}"/></td>
                </tr>
                <tr>
                    <td><form:label path="phone">Phone</form:label></td>
                    <td><form:input path="phone" value="${agent.phone}"/></td>
                </tr>
                <tr>
                    <td><form:label path="fax">Fax</form:label></td>
                    <td><form:input path="fax" value="${agent.fax}"/></td>
                </tr>
               <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" value="${agent.email}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit!"/></td>
                </tr>
            </table>
        </form:form>
    
	
</html>