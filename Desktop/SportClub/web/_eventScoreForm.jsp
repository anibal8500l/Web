<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="EventScore" method="post">
    ID <input type="text" name="id" value="${eventScore.id}" 
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    equipo1 <input type="text" name="scoreTeam1" value="${eventScore.scoreTeam1}" />
    <br />
    equipo 2: <input type="text" name="scoreTeam2" value="${eventScore.scoreTeam2}" />
    <br />

    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>
    
    