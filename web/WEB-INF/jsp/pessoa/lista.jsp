<%-- 
    Document   : listaPessoa
    Created on : 24/11/2012, 11:28:43
    Author     : Cesumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pessoas</title>
    </head>
    <body>
        <h1>Lista de Pessoas</h1>
        
        <a href="cria.htm" >Nova Pessoa</a>
        <br>
        
        <ul>
        <c:forEach var="pessoa" items="${lista}">
            <li>
                <a href="edita.htm?id=${pessoa.id}">${pessoa.id}</a>
                - ${pessoa.nome} - 
                <a href="delete.htm?id=${pessoa.id}" 
                   onclick="return confirm('Confirma remover?')" >Remove</a> </li>
        </c:forEach>
        </ul>
        
    </body>
</html>
