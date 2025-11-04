<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar Empleado a Modificar</title>
</head>
<body>

<h2>Buscar Empleado para Modificar</h2>

<p>Introduce un DNI o un nombre (o parte del nombre) para buscar.</p>

<form action="EmpleadoController" method="GET">

    <input type="hidden" name="option" value="buscarEmpleados">

    <label for="filtro">Criterio de búsqueda:</label>
    <%-- El 'name' ahora es "filtro" --%>
    <input type="text" id="filtro" name="filtro" required>

    <input type="submit" value="Buscar">
</form>

<br>
<a href="index.jsp">Volver al Menú Principal</a>

</body>
</html>