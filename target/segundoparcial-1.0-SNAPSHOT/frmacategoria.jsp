<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${categoria.id==0}">
                Nuevo registro
            </c:if> 
            <c:if test="${categoria.id!=0}">
                Editar registro
            </c:if> 
        </h1>
        <form action="Inicio" method="POST">
            <input type="hidden" name="id" value="${categoria.id}"/>
            <table>
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${categoria.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
