<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="User" method="post">
    CODIGO: <input type="text" name="id" value="${user.id}" 
                   <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : ''}"/>
                   <c:out value="${action == 'new' ? 'readonly=\"readonly\"' : ''}"/> />
    <br />
    Usuario: <input type="text" name="userName" value="${user.userName}" />
    <br />
    Nombre: <input type="text" name="firstName" value="${user.firstName}" />
    <br />
    Apellido: <input type="text" name="lastName" value="${user.lastName}" />
    <br />
    @email: <input type="text" name="email" value="${user.email}" />
    <br />
    Password:
    <input type="password" name="password" value="${user.password}" />
    <br />
    Tipo: <input type="text" name="role" value="${user.role}" />
    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
    <input type="submit"/>
</form>
    
    