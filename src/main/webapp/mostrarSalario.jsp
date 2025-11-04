<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salario Calculado</title>
</head>
<body>
<h2>Salario del Empleado</h2>

<p>El salario calculado para el empleado con DNI <strong>${dniConsultado}</strong> es:</p>

<h3>${salarioCalculado} €</h3>

<br>
<a href="buscarSalario.jsp">Consultar otro DNI</a>
<br>
<a href="index.jsp">Volver al Menú Principal</a>
</body>
</html>