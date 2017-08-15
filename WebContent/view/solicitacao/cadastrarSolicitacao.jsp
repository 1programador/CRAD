<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Solicitação</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js">
</script>
</head>

<body>
<c:import url="/view/menu/menu.jsp" />

<center>
	<hr>
	<h3>Registrar Solicitação</h3>
	<hr>
			<div style="text-align: center; color: green;">${mensagemSucessoSolicitacao}</div>

	<form action="registrarSolicitacao" method="POST" enctype="multipart/form-data">
			
			<form:errors path="solicitacao.usuario" style="text-align: center; color: red;"/>
			<div class="form-group">
			<label for="usuario">Usuario:*</label><select id="usuario" name="usuario" class="form-control" style="width: 200px;" >
			
				<option value="">Selecione uma opção</option>
				<c:forEach items="${listaUsuario}" var="usuario">
					<option value="${usuario.id}">${usuario.nome}</option>
				</c:forEach>
			
			</select>
			</div>
			
			<form:errors path="solicitacao.tipoSolicitacao" style="text-align: center; color: red;"/>
		<div class="form-group">
			<label for="tipoSolicitacao">Tipo de solicitação:*</label>
			<select id="tipoSolicitacao" name="tipoSolicitacao" class="form-control" style="width: 200px;" >
			
				<option value="">Selecione uma opção</option>
				<c:forEach items="${listaTipoSolicitacao}" var="obj">
					<option value="${obj.id}">${obj.descricao}</option>
				</c:forEach>
			
			</select>
			</div>
			
			<div class="form-group">
				<label for="file">Anexos:</label>
				<input type="file" id="file" name="file" class="form-control" style="width: 200px;"/>
			</div>
			
			<div class="form-group">
				<label for="complemento">Complemento:</label>
				<textarea name="complemento" id="complemento" cols="4" rows="5" class="form-control" maxlength="255" style="width: 200px;"></textarea>
				
			</div>
			
			
			<button type="reset" class="btn btn-danger" role="button">Limpar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Cadastrar &nbsp;</button>
			
	</form>
	
</center>
</body>
</html>