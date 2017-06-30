
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Reserva de canchas Sport Club</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="icon" type="image/png" href="images/logo.png" />
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
                    <h2 style="color: #fff">¡Bienvenido a Sport Club!</h2>
                    <br><p style="color: #fff; font-size:30px;">Recuerda que puedes crear eventos y participar de ellos</p>
                </div>
                <div class="5u 12u(medium)">
                    <br><br> <ul>
                    <li><a href="e_crear.jsp" class="button big icon fa-arrow-circle-right">Ver Eventos</a></li>
                </ul>
                </div>
            </div>
        </div>
    </div>

    <br><br>
    <div class="container">
        <section id="contentt">
            <form action="User" method="post">
                <br><h1 style="color:#277CD5;font-size:25px">Crear Cuenta</h1><br>
                <center>
                    <div>
                        <input type="text" placeholder="Nombres" required id="name" name="firstName"/>
                    </div>
                    <div>
                        <input type="text" placeholder="Apellidos" required id="lastname" name="lastName"/>
                    </div>
                    <div>
                        <input type="text" placeholder="E-mail" required id="email" name="email"/>
                    </div>
                    <div>
                        <input type="text" placeholder="Nombre Usuario" required id="username" name="userName" />
                    </div>
                    <div>
                        <input type="password" placeholder="Nueva Contraseña" required id="password" name="password"/>
                    </div>
                </center>
                <div>
                    <input type="hidden" name="action" value="<c:out value="${action == 'edit' ? 'update' : 'create'}"/>"/>
                    <br><input type="submit" value="Crear"/><br>
                </div>
            </form><!-- form -->
            <br>
        </section><!-- content -->
    </div><!-- container -->
</body>

<script src="formulario/js/index.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.dropotron.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

<br><br><div id="main-wrapper">
    <div class="container">
        <div class="row 200%">
            <div class="4u 12u(medium)">

                <div id="sidebar">
                    <section class="widget thumbnails">
                        <h3>Populares</h3>
                        <div class="grid">
                            <div class="row 50%">
                                <div class="6u"><a href="reservas.jsp" class="image fit"><img src="images/pic04.jpg" alt="" /></a></div>
                                <div class="6u"><a href="reservas.jsp" class="image fit"><img src="images/pic05.jpg" alt="" /></a></div>
                                <div class="6u"><a href="reservas.jsp" class="image fit"><img src="images/pic06.jpg" alt="" /></a></div>
                                <div class="6u"><a href="reservas.jsp" class="image fit"><img src="images/pic07.jpg" alt="" /></a></div>
                            </div>
                        </div>
                        <a href="reserva.jsp" class="button icon fa-file-text-o">Ver más</a>
                    </section>
                </div>

            </div>
            <div class="8u 12u(medium) important(medium)">

                <div id="content">
                    <section class="last">
                        <h2>Deporte en todo Lima</h2>
                        <p>Esto es <strong>Sport Club</strong>, una pagina donde podrás encontrar canchas de Fútbol, Voley o Basquet en cualquier distrito de Lima, como:
                        <p style="text-align: justify;">Ate, Barranco, Bellavista, Breña, Chorrilos, Chosica, Comas, Huachipa, Independencia, Jesus Maria, La Molina, La Victoria
                            Lima,, Lince, Los Olivos, Lurin, Magdalena del Mar, Mala, Miraflores, Pachacamac, Pueblo Libre, Puente Piedra, Punta Negra, Rimac, San Borja, San Isidro, San Juan de Lurigancho, San Juan de Miraflores, San Luis, San Martin de Porres, San Miguel, Surco, Surquillo, Villa Maria del triunfo</p>
                        <a href="reserva.jsp" class="button icon fa-arrow-circle-right">Ver Canchas</a><br><br>
                        <a href="contacto.jsp" class="button icon fa-arrow-circle-right">Pública aquí tu cancha</a>
                    </section>
                </div>

            </div>
        </div>
    </div>
</div>

<div id="footer-wrapper">
    <footer id="footer" class="container">
        <div id="copyright">
            <ul class="menu">
                <li style="color: #000">&copy;innovativemind. Todos los derechos reservados</li><li style="color: #000">Diseño por: Innovative Mind SAC</li>
            </ul>
        </div>
    </footer>
</div>

</div>
</body>
</html>

