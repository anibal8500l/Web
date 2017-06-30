<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Usuarios</title>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    
    <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService" />
    <table border="0" cellpadding="8" cellspacing="3">
        <tr>
            <td>
            Codigo
        </td>
        <td>
            Username
        </td>
        <td>
            Nombre
        </td>
        <td>
            Apellido
        </td>
        <td>
            Password
        </td>
        <td>
            @Email
        </td>
        <td>
            Tipo
        </td>
        </tr>

        <c:forEach var="user" items="${service.users}">
        <tr>
        <td>
            <c:out value="${user.id}" />
        </td>
        <td>
            <c:out value="${user.userName}" />
        </td>
        <td>
            <c:out value="${user.firstName}" />
        </td>
        <td>
            <c:out value="${user.lastName}" />
        </td>
        <td>
            <c:out value="${user.password}" />
        </td>
        <td>
            <c:out value="${user.email}" />
        </td>
        <td>
            <c:out value="${user.role}" />
        </td>
        <td>
            <a href="User?action=edit&id=<c:out value="${user.id}"/>">Editar</a>
        </td>
        <td>
            <a href="User?action=delete&id=<c:out value="${user.id}"/>">Eliminar</a>
        </td>
    </c:forEach>
        </tr>
        
    </table>
    <a href="User?action=new">nuevo Usuario</a>
</body>
</html>