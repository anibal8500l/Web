<%-- 
    Document   : listSportCenter
    Created on : 18-nov-2016, 18:31:57
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sportcenter</title>
    </head>
    <body>
        <h1>Lista de sportcenter!</h1>
        <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService" />
    
        <table border="0">
            <tr>
            <td>
            Codigo
        </td>
        <td>
            nombre
        </td>
        <td>
            direccion
        </td>
        <td>
            telefono
        </td>
        <td>
            image
        </td>
        <td>
            descripcion
        </td>
        <td>
            id creador
        </td>
        </tr>
        
        <c:forEach var="sportCenter" items="${service.sportCenters}">
            <tr>
                <td>
                    <c:out value="${sportCenter.id}" />
                </td>
                <td>
                    <c:out value="${sportCenter.name}" />
                </td>
                <td>
                    <c:out value="${sportCenter.address}" />
                </td>
                <td>
                    <c:out value="${sportCenter.phone}" />
                </td>
                <td>
                    <c:out value="${sportCenter.image}" />
                </td>
                <td>
                    <c:out value="${sportCenter.description}" />
                </td>
                <td>
                    <c:out value="${sportCenter.userId.getId()}" />
                </td>
                <td>
                    <a href="SportCenter?action=edit&id=<c:out value="${sportCenter.id}"/>">Editar</a>
                </td>
                <td>
                    <a href="SportCenter?action=delete&id=<c:out value="${sportCenter.id}"/>">Eliminar</a>
                </td>
        </c:forEach>
            </tr>
        </table>
        <a href="SportCenter?action=new">nuevo SportCenter</a>
    
    </body>
</html>
