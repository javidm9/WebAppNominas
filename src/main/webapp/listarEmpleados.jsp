<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de Empleados</title>
    <style>

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
    </style>
</head>
<body>

<h2>Información de los Empleados</h2>

<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>DNI</th>
        <th>Sexo</th>
        <th>Categoría</th>
        <th>Años</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${listaDeEmpleados}" var="empleado">
        <tr>
            <td>${empleado.nombre}</td>
            <td>${empleado.dni}</td>
            <td>${empleado.sexo}</td>
            <td>${empleado.categoria}</td>
            <td>${empleado.anyos}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>

<a href="${pageContext.request.contextPath}/index.jsp">Volver al Menú Principal</a>

</body>
</html>