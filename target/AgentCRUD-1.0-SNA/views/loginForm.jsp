<%-- 
    Document   : loginForm
    Created on : 26-Feb-2019, 18:35:27
    Author     : MTimos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form method="POST" action="/AgentCRUD/addAgent" modelAttribute="agent">
     
            <table>
               <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" value="${email}"/></td>
                </tr>
                 <tr>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
