<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Encaminhar Solicitação</title>
</head>
<body>
<c:import url="../menu/menu.jsp"/>


<center>
	<hr>
	<h3>Registrar Solicitação</h3>
	<hr>
			
			<div style="text-align: center; color: green;">${mensagemSucessoEncaminhar}</div>

	<form action="registrarEncaminhamento" method="POST">
	
	<input type="hidden" name="id" id="id" value="${solicitacao.id}">
	<input type="hidden" name="usuario" id="usuario" value="${usuario.id}">
	<input type="hidden" name="status" id="status" value="ANALISE">
			
			<div class="form-group">
 		
 		<label for="usuario">Nome:</label>		
 		<select id="usuarioEncaminhado" name="usuarioEncaminhado" class="form-control" style="width: 200px;" >
  			
 			<option value="">Selecione uma opção</option>
 		<c:forEach items="${listarUsuarioAtivo}" var="usuario"> <!-- esta varievel "var='usuario'" pode ter qualquer nome   -->
 				<option value="${usuario.id}">${usuario.nome}</option>
 			
 			</c:forEach>
 			</select>
 			</div>
 			
 			<div class="form-group">
				<label for="complemento">Parecer:</label>
				<textarea name="parecer" id="parecer" cols="4" rows="5" class="form-control" maxlength="255" style="width: 200px;"></textarea>
			</div>
		
			
			
		<button type="submit" class="btn btn-success"> &nbsp; Enviar &nbsp;</button>
			
	</form>
	
</center>

</body>
</html>