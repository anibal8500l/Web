<%-- 
    Document   : listTeam
    Created on : 17-nov-2016, 22:34:55
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Equipos</title>
    </head>
    <body>
        <h1>Lista de Equipos!!!</h1>
        
        <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService" />
        
        <table>
            <tr>
                <td>
                    Codigo del Equipo
                </td>
                <td>
                    Nombre del equipo
                </td>
            </tr>
            <c:forEach var="team" items="${service.teams}">
                <tr>
                    <td>
                        <c:out value="${team.id}" />
                    </td>
                    <td>
                        <c:out value="${team.name}" />
                    </td>
                    <td>
                        <a href="Team?action=edit&id=<c:out value="${team.id}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="Team?action=delete&id=<c:out value="${team.id}"/>">Eliminar</a>
                    </td>
            </c:forEach>
                </tr>
        </table>
        <a href="Team?action=new">nuevo evento</a>
    </body>
</html>
