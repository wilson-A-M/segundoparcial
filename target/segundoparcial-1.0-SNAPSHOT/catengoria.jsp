<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.categoria"%> <!-- Asegúrate de tener la clase Categoria en el paquete correcto -->
<%
    List<categoria> categorias = (List<categoria>) request.getAttribute("categorias");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Categorías</title>
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
            <p>Nombre: Zulema Magali Mita Mendoza</p>
            <p>CI: 10064079</p>
        </div>
        <h1>Lista de Categorías</h1>
        <a href="categoria?action=add">Nueva categoría</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Categoría</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="categoria" items="${categorias}">
                <tr>
                    <td>${categoria.id}</td>
                    <td>${categoria.categoria}</td>
                    <td><a href="Categoria?action=edit&id=${categoria.id}">Editar</a></td>
                    <td><a href="Categoria?action=delete&id=${categoria.id}" onclick="return(confirm('¿Está seguro de eliminar?'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>    
    </body>
</html>
