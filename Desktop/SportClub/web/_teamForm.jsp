<%-- 
    Document   : _teamForm
    Created on : 18-nov-2016, 11:14:01
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="Team" method="post">
    CODIGO: <input type="text" name="id" value="${team.id}"
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    Nombre del equipo: <input type="text" name="name" value="${team.name}" />
    <br />
    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>