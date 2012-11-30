<%-- 
    Document   : lista
    Created on : 29/11/2012, 16:12:19
    Author     : alan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cidades</title>
    </head>
    <body>
        <h1>Lista de Cidades</h1>
        
        <a href="cria.htm" >Nova Cidade</a>
        <br>
        
        <ul>
        <c:forEach var="cidade" items="${lista}">
            <li>
                <a href="edita.htm?id=${cidade.id}">${cidade.id}</a>
                - ${cidade.nome} - 
                <a href="delete.htm?id=${cidade.id}" 
                   onclick="return confirm('Confirma remover?')" >Remove</a> </li>
        </c:forEach>
        </ul>
        
    </body>
</html>