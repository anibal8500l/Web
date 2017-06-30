<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="Court" method="post">
    CODIGO: <input type="text" name="id" value="${court.id}" 
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    TIPO: <input type="text" name="type" value="${court.type}" />
    <br />
    Imagen: <input type="text" name="image" value="${court.image}" />
    <br />
    Precio: <input type="text" name="price" value="${court.price}" />
    <br />
    Calificacion: <input type="text" name="score" value="${court.score}" />
    <br />
    Sporcenter id: <input type="text" name="sportCenterId" value="${court.sportCenterId.getId()}" />

    <br />
    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>
