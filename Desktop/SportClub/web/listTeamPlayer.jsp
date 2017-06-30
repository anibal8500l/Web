<%-- 
    Document   : listTeamPLayer
    Created on : 20-nov-2016, 12:33:52
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de TeamPlayer</title>
    </head>
    <body>
        <h1>Lista de TeamPlayer!</h1>
        <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService" />
        
        <table>
            <tr>
                <td>
                    team_player_id
                </td>
                <td>
                    team_id
                </td>
                <td>
                    user_id
                </td>
            </tr>
            <c:forEach var="teamPlayer" items="${service.teamPlayers}">
                <tr>
                    <td>
                        <c:out value="${teamPlayer.id}" />
                    </td>
                    <td>
                        <c:out value="${teamPlayer.teamId.getId()}" />
                    </td>
                    <td>
                        <c:out value="${teamPlayer.userId.getId()}" />
                    </td>
                    <td>
                        <a href="TeamPlayer?action=edit&id=<c:out value="${teamPlayer.id}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="TeamPlayer?action=delete&id=<c:out value="${teamPlayer.id}"/>">Eliminar</a>
                    </td>
            </c:forEach>
                </tr>
        </table>
        <a href="TeamPlayer?action=new">nuevo evento</a>
    </body>
</html>
