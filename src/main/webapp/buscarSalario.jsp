<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar Salario</title>
</head>
<body>

<h2>Consultar Salario de Empleado</h2>

<form action="EmpleadoController" method="GET">

    <input type="hidden" name="option" value="calcularSalario">

    <label for="dni">Introduce el DNI del empleado:</label>
    <input type="text" id="dni" name="dni">

    <input type="submit" value="Buscar Salario">
</form>

<br>
<a href="index.jsp">Volver al Menú Principal</a>

</body>
</html>