<%-- 
    Document   : listEvent
    Created on : 16-nov-2016, 18:31:47
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de eventos</title>
    </head>
    <body>
        <h1>Lista de eventos!</h1>
        
        <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService" />
    <table border="0" cellpadding="8" cellspacing="3">
        <tr>
            <td>
            Codigo
        </td>
        <td>
            descripcion
        </td>
        <td>
            Fecha inicio
        </td>
        <td>
            Fecha termino
        </td>
        <td>
            Id equipo 1
        </td>
        <td>
            Id equipo 2
        </td>
        <td>
            id creador
        </td>
        <td>
            id cancha
        </td>
        </tr>

        <c:forEach var="event" items="${service.events}">
        <tr>
        <td>
            <c:out value="${event.id}" />
        </td>
        <td>
            <c:out value="${event.description}" />
        </td>
        <td>
            <c:out value="${event.dateIn}" />
        </td>
        <td>
            <c:out value="${event.dateOut}" />
        </td>
        <td>
            <c:out value="${event.team1Id.getId()}" />
        </td>
        <td>
            <c:out value="${event.team2Id.getId()}" />
        </td>
        <td>
            <c:out value="${event.userCreatorId.getId()}" />
        </td>
        <td>
            <c:out value="${event.courtId.getId()}" />
        </td>
        <td>
            <a href="Event?action=edit&id=<c:out value="${event.id}"/>">Editar</a>
        </td>
        <td>
            <a href="Event?action=delete&id=<c:out value="${event.id}"/>">Eliminar</a>
        </td>
    </c:forEach>
        </tr>
        
    </table>
    <a href="Event?action=new">nuevo evento</a>
    </body>
</html>
