<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Agent</title>
    </head> 
        <h1><spring:message code="addagentform.header" /> </h1>      
        <form:form method="POST" action="/AgentCRUD/agent/addAgent" modelAttribute="agent">    
            <table>   
                <tr>
                    <td><form:label path="agentId"><spring:message code="label.agentId" /></form:label></td>
                    <td><form:input path="agentId"/></td> 
                    <td style="color:red"><form:errors path="agentId"/> </td>
               </tr>
                <tr>
                    <td><form:label path="name"><spring:message code="label.name" /></form:label></td>
                    <td><form:input path="name" /></td>
                    <td style="color:red"><form:errors path="name"/> </td>
                </tr>
                <tr>
                    <td><form:label path="phone"><spring:message code="label.phone" /></form:label></td>
                    <td><form:input path="phone"/></td>
                    <td style="color:red"><form:errors path="phone"/> </td>
                </tr>
                <tr>
                    <td><form:label path="fax"><spring:message code="label.fax" /></form:label></td>
                    <td><form:input path="fax"/></td>
                    <td style="color:red"> <form:errors path="fax"/> </td>
                </tr>
                <tr>
                    <td><form:label path="email"><spring:message code="label.email" /></form:label></td>
                    <td><form:input path="email"/></td>
                    <td style="color:red"> <form:errors path="email"/> </td>
                </tr>
                <tr>
                    <spring:message code="submit.button" var="labelSubmit"></spring:message>
                    <td><input type="submit" value="${labelSubmit}"/></td>
                </tr>
            </table>
        </form:form>	
</html>