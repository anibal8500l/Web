<%-- 
    Document   : _sportCenterForm
    Created on : 18-nov-2016, 20:39:05
    Author     : ThinkUser001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<form action="SportCenter" method="post">
    CODIGO: <input type="text" name="id" value="${sportCenter.id}"
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    Nombre del equipo: <input type="text" name="name" value="${sportCenter.name}" />
    <br />
    Direccion: <input type="text" name="address" value="${sportCenter.address}" />
    <br />
    telefono: 
    <input type="text" name="phone" value="${sportCenter.phone}" />
    imagen: 
    <input type="text" name="image" value="${sportCenter.image}" />
    Descripcion: 
    <input type="text" name="description" value="${sportCenter.description}" />
    User: 
    <input type="text" name="userId" value="${sportCenter.userId.getId()}" />
    <br />
    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>
