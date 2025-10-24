<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Nóminas</title>
</head>
<body>

<h1>Menú Principal</h1>

<nav>
    <ul>
        <li>
            <%--
              Este enlace llama a tu servlet (EmpleadoController)
              y le pasa el parámetro "option=listar".
            --%>
            <a href="EmpleadoController?option=listarEmpleados">
                Mostrar Información de Empleados
            </a>
        </li>

    </ul>
</nav>

</body>
</html>