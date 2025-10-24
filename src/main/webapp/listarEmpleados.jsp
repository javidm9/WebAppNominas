<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  1. IMPORTANTE: Importamos la librería de etiquetas JSTL (Core)
  Esto nos da acceso a <c:forEach>, <c:if>, etc.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de Empleados</title>
    <style>
        /* Un poco de estilo para que la tabla se vea bien */
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
    <%--
      2. ESTA ES LA MAGIA:
      "items"  -> Es el nombre de la variable que pusimos en el servlet:
                   request.setAttribute("listaDeEmpleados", ...);

      "var"    -> Es el nombre que le damos a cada objeto 'Empleado'
                   dentro del bucle (como en un 'for-each' de Java).
    --%>
    <c:forEach items="${listaDeEmpleados}" var="empleado">
        <tr>
                <%--
                  3. Accedemos a las propiedades usando los getters.
                  "${empleado.nombre}" es lo mismo que llamar a empleado.getNombre()
                --%>
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
<%--
  Usamos request.getContextPath() para crear un enlace robusto
  que funcione aunque cambies el nombre de tu app.
  (Aunque href="index.jsp" también funcionaría)
--%>
<a href="${pageContext.request.contextPath}/index.jsp">Volver al Menú Principal</a>

</body>
</html>