<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="Event" method="post">
    CODIGO: <input type="text" name="id" value="${event.id}" 
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    Fecha Inicio: <input type="date" name="dateIn" value="${event.dateIn}" />
    <br />
    Fecha de fin: <input type="date" name="dateOut" value="${event.dateOut}" />
    <br />
    Descripcion: <input type="text" name="description" value="${event.description}" />
    <br />
    Equipo 1: <input type="text" name="team1Id" value="${event.team1Id.getId()}" />
    <br />
    Equipo 2: <input type="text" name="team2Id" value="${event.team2Id.getId()}" />
    <br />
    Creador: <input type="text" name="userCreatorId" value="${event.userCreatorId.getId()}" />
    <br />
    Cancha: <input type="text" name="courtId" value="${event.courtId.getId()}" />
    <br />
    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>
