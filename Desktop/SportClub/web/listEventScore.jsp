<%-- 
    Document   : listEventScore
    Created on : 20-nov-2016, 2:56:40
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de scores</title>
    </head>
    <body>
        <h1>Lista de scores!</h1>

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
            </tr>

            <c:forEach var="eventScores" items="${service.eventScores}">
                <tr>
                    <td>
                        <c:out value="${eventScores.id}" />
                    </td>
                    <td>
                        <c:out value="${eventScores.scoreTeam1}" />
                    </td>
                    <td>
                        <c:out value="${eventScores.scoreTeam2}" />
                    </td>
                    <td>
                        <a href="EventScore?action=edit&id=<c:out value="${eventScores.id}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="EventScore?action=delete&id=<c:out value="${eventScores.id}"/>">Eliminar</a>
                    </td>
                </c:forEach>
            </tr>
        </table>
        <a href="EventScore?action=new">nuevo score</a>
    </body>
</html>
