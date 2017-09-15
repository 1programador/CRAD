<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Solicitação</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js">
</script>
<script type="text/javascript">

function voltarPagina() {
	window.location.href = "http://localhost:8080/CRAD/as"
}

</script>
</head>

<body>
<c:import url="/view/menu/menu.jsp" />

<center>
	<hr>
	<h3>Alterar Solicitação</h3>
	<hr>
	
			

	<form action="alterarSolicitacao" method="POST">
			
			
			
			
			
			<div class="form-group">
			<c:if test="${usuarioLogado.perfil eq 'ALUNO'}">
			<label for="usuario">Nome:</label>
			<input type="text" id="nome" name="nome" value="${usuarioLogado.nome}" class="form-control" style="width: 200px;" disabled/>
			<input type="hidden" id="usuario" name="usuario" value="${usuarioLogado.id}" class="form-control" style="width: 200px;"/>
			</c:if>
			</div>
			
			
	 		
	 		<div class="form-group">
	 		<c:if test="${usuarioLogado.perfil eq 'CRAD'}">
	 		<label for="usuario">Nome:</label>		
	 		<select id="usuario" name="usuario" class="form-control" style="width: 200px;" >
	 			
 					<c:forEach items="${listarUsuarioAtivo}" var="usuario"> <!-- esta varievel "var='usuario'" pode ter qualquer nome   -->
 				<option value="${usuario.id}" <c:if test="${usuario.id eq solicitacao.usuario.id}">selected="selected"</c:if>>
 				${usuario.nome}
 				</option>
 			
 			</c:forEach>
 			</select>
 			</c:if>
			</div>
			
			
			
			<div class="form-group">
			<label for="tipoSolicitacao">Tipo de solicitação:</label>
			  <select id="tipoSolicitacao" name="tipoSolicitacao" class="form-control" style="width: 200px;" >
				
				<c:forEach items="${listaTipoSolicitacaoAtiva}" var="obj"> 
					<option value="${obj.id}"<c:if test="${obj.id eq solicitacao.tipoSolicitacao.id}">selected="selected"</c:if>>
					${obj.descricao}
					</option>
				</c:forEach> 	
			
			</select>
			</div>
				
				
			<div class="form-group">
				<label for="complemento">Complemento:</label>
				<textarea name="complemento" id="complemento" cols="4" rows="5" class="form-control" maxlength="255" style="width: 200px;" >${solicitacao.complemento}</textarea>	
			</div>
			
			<input type="hidden" name="id" value="${solicitacao.id}" />
						
			<button type="reset" onclick="voltarPagina()" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
			<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>
			<br>
			<br>
	</form>
	
</center>
</body>
</html>