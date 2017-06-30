<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="TeamPlayer" method="post">
    ID <input type="text" name="id" value="${teamPlayer.id}" 
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    team_id <input type="text" name="teamId" value="${teamPlayer.teamId.getId()}" />
    <br />
    user_id: <input type="text" name="userId" value="${teamPlayer.userId.getId()}" />
    <br />

    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>
</html>
