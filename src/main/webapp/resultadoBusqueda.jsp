<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Resultados de la Búsqueda</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px 0; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

<h2>Resultados de la Búsqueda</h2>

<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>DNI</th>
        <th>Sexo</th>
        <th>Categoría</th>
        <th>Años</th>
        <th>Acción</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listaResultados}" var="emp">
        <tr>
            <td>${emp.nombre}</td>
            <td>${emp.dni}</td>
            <td>${emp.sexo}</td>
            <td>${emp.categoria}</td>
            <td>${emp.anyos}</td>
            <td>
                <a href="EmpleadoController?option=verFormModificar&dni=${emp.dni}">
                    Modificar
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="buscarEmpleado.jsp">Volver a la búsqueda</a>
<br>
<a href="index.jsp">Volver al Menú Principal</a>

</body>
</html>