<%-- 
    Document   : form
    Created on : 29/11/2012, 16:12:09
    Author     : alan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Cidade</title>
        
        <style>
.msgErro {
	color: #ff0000;
}
 
.blocoErro {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
        
    </head>
    <body>
        <h1>Formulario de Cidade</h1>
        
        <a href="lista.htm" >Lista de Cidades</a>
        <br><br>
        
        <form:form action="salva.htm" commandName="cidade">
            <form:errors path="*" cssClass="blocoErro" element="div" />
            Id: <form:input path="id" value="${cidade.id}"/><br>
            Nome: <form:input path="nome" value="${cidade.nome}"/><br>
            <form:errors path="nome" cssClass="msgErro"/><br><br>
            <input type="submit" value="Salva" />
        </form:form>
            
    </body>
</html>