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
                <h1><a href="index_SP.jsp"><img src=images/logo.png style="width:200px"></a></h1>
                <span>by Innovative Mind</span>
            </div>
            <nav id="nav">
                <ul>
                    <li class="current"><a href="index_SP.jsp">Inicio</a></li>
                    <li>
                        <a href="eventos.jsp">Eventos</a>
                        <ul>
                            <li><a href="eventos.jsp">Eventos Próximos</a></li>
                            <li><a href="e_crear.jsp">Crear Evento</a></li>
                        </ul>
                    </li>
                    <li><a href="reserva.jsp">Reservas</a></li>
                    <li><a href="contacto.jsp">Publicar Cancha</a></li>
                    <li><a href="iniciar.jsp">Iniciar Sesión</a></li>
                </ul>
            </nav>

        </header>
    </div>

    <div id="banner-wrapper">
        <div id="banner" class="box container" style="background-image: url(images/eventos.jpg)">
            <div class="row">
                <div class="7u 12u(medium)">
                    <h2 style="color: #fff">¡Bienvenido!</h2>
                    <p style="color: #fff">¿Quieres saber sobre nuestro próximos eventos? o ¿Reservar una cancha?</p>
                </div>
                <div class="5u 12u(medium)">
                    <ul>
                        <li><a href="reserva.jsp" class="button big icon fa-arrow-circle-right">Reservar</a></li>
                        <li><a href="eventos.jsp" class="button big icon fa-arrow-circle-right">Ver Eventos</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div id="features-wrapper">
        <div class="container">
            <div class="row">
                <div class="4u 12u(medium)">

                    <section class="box feature">
                        <a href="pic01.jsp" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
                        <div class="inner">
                            <header>
                                <a href="pic01.jsp"><h2>Descentralizado: ¿Qué equipo lleva más hinchas al estadio?</h2></a>
                                <p>Mira en esta nota la tabla de recaudación del Descentralizado 2016 disputadas ya 39 fechas</p>
                            </header>
                            <p>¿Qué equipo llevó más gente al estadio el 2016? ¿Cuál ganó más? Universitario de Deportes, Alianza Lima o FBC melgar.</p>
                        </div>
                    </section>

                </div>
                <div class="4u 12u(medium)">

                    <section class="box feature">
                        <a href="pic02.jsp" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                        <div class="inner">
                            <header>
                                <a href="pic02.jsp"><h2>Perú venció 3-0 a Chile en el Sudamericano Sub 20 de Vóley</h2></a>
                                <p>La selección peruana de vóley derrotó 3-0 a Chile por el Sudamericano Sub 20 en Brasil y ya tiene dos triunfos</p>
                            </header>
                            <p>La selección peruana de vóley derrotó 3-0 a Chile por el Sudamericano Sub 20 de Brasil y ya tiene dos triunfos. El objetivo de la bicolor es ganar el título.</p>
                        </div>
                    </section>

                </div>
                <div class="4u 12u(medium)">

                    <section class="box feature">
                        <a href="pic03.jsp" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
                        <div class="inner">
                            <header>
                                <a href="pic03.jsp"><h2>¿Cuál fue el mejor equipo de la Liga Nacional de Básquet 2016?</h2></a>
                                <p>Te respondemos esta y otras preguntas sobre otros deportes en nuestra sección Aló DT</p>
                            </header>
                            <p>¿Cuál fue el mejor equipo de la Liga Nacional de Básquet 2016? (Arthur, San Borja) </p>
                        </div>
                    </section>

                </div>
            </div>
        </div>
    </div>

    <div id="main-wrapper">
        <div class="container">
            <div class="row 200%">

                <div class="8u 12u(medium) important(medium)">

                    <div id="content">
                        <section class="last">
                            <h2>Deporte en todo Lima</h2>
                            <p>Esto es <strong>Sport Club</strong>, una pagina donde podrás encontrar canchas de Fútbol, Voley o Basquet en cualquier distrito de Lima, como:
                            <p style="text-align: justify;">Ate, Barranco, Bellavista, Breña, Chorrilos, Chosica, Comas, Huachipa, Independencia, Jesus Maria, La Molina, La Victoria
                                Lima,, Lince, Los Olivos, Lurin, Magdalena del Mar, Mala, Miraflores, Pachacamac, Pueblo Libre, Puente Piedra, Punta Negra, Rimac, San Borja, San Isidro, San Juan de Lurigancho, San Juan de Miraflores, San Luis, San Martin de Porres, San Miguel, Surco, Surquillo, Villa Maria del triunfo</p>
                            <a href="reserva.jsp" class="button icon fa-arrow-circle-right">Ver Canchas</a><br><br>
                            <a href="contacto.jsp" class="button icon fa-arrow-circle-right">Publica aquí tu cancha</a>
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


<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.dropotron.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>

