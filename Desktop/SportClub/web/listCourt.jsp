<%-- 
    Document   : listCourt
    Created on : 19-nov-2016, 1:02:27
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de canchas</title>
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
                Tipo
            </td>
            <td>
                Imagen
            </td>
            <td>
                Precio
            </td>
            <td>
                Calificacion:
            </td>
            <td>
                Sporcenter id
            </td>
        </tr>

        <c:forEach var="court" items="${service.courts}">
            <tr>
                <td>
                    <c:out value="${court.id}" />
                </td>
                <td>
                    <c:out value="${court.type}" />
                </td>
                <td>
                    <c:out value="${court.image}" />
                </td>
                <td>
                    <c:out value="${court.price}" />
                </td>
                <td>
                    <c:out value="${court.score}" />
                </td>
                <td>
                    <c:out value="${court.sportCenterId.getId()}" />
                </td>
                <td>
                    <a href="Court?action=edit&id=<c:out value="${court.id}"/>">Editar</a>
                </td>
                <td>
                    <a href="Court?action=delete&id=<c:out value="${court.id}"/>">Eliminar</a>
                </td>
            </c:forEach>
        </tr>

    </table>
    <a href="Court?action=new">nuevo evento</a>
    </body>
</html>
