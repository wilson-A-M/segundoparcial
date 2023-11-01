<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Almacen"%>
<%
    List<Almacen> almacen = (List<Almacen>) request.getAttribute("almacen");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Registro de estudiantes</title>
        <style>
            .box {
                margin: auto;
                width: 50%;
                padding: 10px;
                border: 1px solid #ccc;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="box">
            <h3>SEGUNDO PARCIAL TEM-742</h3>
            <p>Nombre: ZULEMA MITA MENDOZA</p>
            <p>CI:10064079</p>
        </div>
        <h1>Gestion de productos</h1>
        <a href="Inicio?action=add">Nuevo producto</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${almacen}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar???'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>    
    </body>
</html>
