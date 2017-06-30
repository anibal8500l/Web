<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Reserva de canchas Sport Club</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="icon" type="image/png" href="images/logo.png"/>
</head>
<body class="homepage">
<div id="page-wrapper">
    <div id="header-wrapper">
        <header id="header" class="container">
            <div id="logo">
                <h1><a href="index.jsp"><img src=images/logo.png style="width:200px"></a></h1>
                <span>by Innovative Mind</span>
            </div>
            <nav id="nav">
                <ul>
                    <li class="current"><a href="index.jsp">Inicio</a></li>
                    <li>
                        <a href="eventos.jsp">Eventos</a>
                        <ul>
                            <li><a href="eventos.jsp">Eventos Próximos</a></li>
                            <li><a href="e_crear.jsp">Crear Evento</a></li>
                        </ul>
                    </li>
                    <li><a href="reserva.jsp">Reservas</a></li>
                    <li><a href="contacto.jsp">Públicar Cancha</a></li>
                    <li><a href="iniciar.jsp">Iniciar Sesión</a></li>
                </ul>
            </nav>

        </header>
    </div>

    <div id="features-wrapper">
        <div class="container">
            <div class="row">


                <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService"/>

                <c:forEach var="court" items="${service.courts}">
                    <div class="4u 12u(medium)">
                        <section class="box feature">
                            <a class="image featured"><img src="images/courts/court<c:out value="${court.id}"/>.jpg"
                                                           alt=""/></a>
                            <div class="inner">
                                <header>
                                    <h2>nombre <c:out value="${service.getSportCenter(court.id).name}"/></h2>
                                </header>
                                <p>addres <c:out value="${service.getSportCenter(court.id).address}" /><br><br></p>

                                <center><a href="iniciar.jsp" class="button icon fa-file-text-o">reservar</a></center>
                            </div>
                        </section>

                    </div>
                </c:forEach>

            </div>
        </div>
    </div>

</div>

<div id="footer-wrapper">
    <footer id="footer" class="container">
        <div id="copyright">
            <ul class="menu">
                <li style="color: #000">&copy;innovativemind. Todos los derechos reservados</li>
                <li style="color: #000">Diseño por: Innovative Mind SAC</li>
            </ul>
        </div>
    </footer>
</div>

</div>


<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.dropotron.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>

