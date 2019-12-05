<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="allagents.title" /></title>
    </head>
    <body>
             <spring:message code="welcome.message" /> 

        <br>
        <table style="width:100%" border="1">
            <tr>
             
             <th align="left"><spring:message code="label.agentId" /></th>
             <th align="left"><spring:message code="label.name" /></th>
             <th align="left"><spring:message code="label.fax" /></th>
             <th align="left"><spring:message code="label.phone" /></th>
             <th align="left"><spring:message code="label.email" /></th>
             <th align="left"><spring:message code="label.actions" /></th>
            </tr>
            <c:forEach items="${agentList}" var="agent"> 
                <tr>
                    <td>${agent.agentId}</td>
                    <td>${agent.name}</td>
                    <td>${agent.fax}</td>
                    <td>${agent.phone}</td>
                    <td>${agent.email}</td>
                    <td>
                        <a href="\AgentCRUD\agent\delete?id=${agent.agentId}" onclick="return confirm('Are you sure to delete this agent?')"><spring:message code="label.delete" /> </a>
                        <spring:url value="/agent/edit?id=${agent.agentId}" var="editURL"/>
                        <a href="${editURL}"><spring:message code="label.edit" /></a>
                        <a href="\AgentCRUD\agent\add"><spring:message code="label.insert" /></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>