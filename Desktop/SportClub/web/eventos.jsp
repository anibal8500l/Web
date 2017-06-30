<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <div id="banner-wrapper">
        <div id="banner" class="box container" style="background-image: url(images/eventos.jpg)">
            <div class="row">
                <div class="7u 12u(medium)">
                    <br>
                    <h2 style="color: #fff">Eventos Sport Club</h2>
                </div>
                <br>
                <div class="5u 12u(medium)">
                    <ul>
                        <li><a href="e_crear.jsp" class="button big icon fa-arrow-circle-right">Crear Evento </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <br><br><br>
    <div id="features-wrapper">
        <div class="container">
            <div class="row">


                <jsp:useBean id="service" class="com.sportclub.innovativemind.SpService"/>

                <c:forEach var="events" items="${service.events}">
                    <div class="4u 12u(medium)">

                        <section class="box feature">
                            <a class="image featured"><img src="images/evento<c:out value="${events.id}" />.jpg"
                                                           alt=""/></a>
                            <div class="inner">
                                <header>

                                    <br/>
                                    <h2><c:out value="${events.description}"/></h2>
                                    <p><br> Fecha: <c:out value="${events.dateIn}"/>

                                        <br> hora: 02:00 PM

                                        <br> lugar: <c:out value="${service.getSportCenter(
                                service.getCourt(
                                    events.courtId.id
                                ).sportCenterId.id
                            ).address}"/>
                                        <br/>

                                    </p>
                                </header>
                                <center><a href="e_participar.jsp" class="button icon fa-file-text-o">Participar</a>
                                </center>
                            </div>
                        </section>

                    </div>
                </c:forEach>


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

