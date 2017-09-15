<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acompanhar Solicitação</title>

<script type="text/javascript">

function voltarPagina() {
	window.location.href = "http://localhost:8080/CRAD/home"
}

</script>
</head>
<body>

<c:import url="../menu/menu.jsp"/>



<center>
		<div>
			<hr>
			<h3>Acompanhar Solicitação</h3>
			<hr>
			<c:if test="${usuarioLogado.perfil eq 'CRAD'}">
				
				<form action="pesquisarSolicitacao">
			
					<div class="form-group">
			<label for="tipoSolicitacao">Tipo de solicitação:*</label>
			<select id="tipoSolicitacao" name="tipoSolicitacao" class="form-control" style="width: 200px;" >
			
				<option value="">Selecione uma opção</option>
				<c:forEach items="${listaTipoSolicitacaoAtiva}" var="obj"> <!-- esta varievel "var='obj'" pode ter qualquer nome   -->
					<option value="${obj.id}">${obj.descricao}</option>
				</c:forEach>
			
			</select>
			</div>

				<div class="form-group">
 		<label for="usuario">Nome do Usuario:</label>		
 		<select id="usuario" name="usuario" class="form-control" style="width: 200px;" >  			
 			
 			<option value="">Selecione uma opção</option>
 		<c:forEach items="${listarUsuarioAtivo}" var="usuario"> <!-- esta varievel "var='usuario'" pode ter qualquer nome   -->
 				<option value="${usuario.id}">${usuario.nome}</option>
 			
 			</c:forEach>
 			</select>
			</div>
				
					<button type="reset" class="btn btn-danger">Limpar</button> &nbsp; &nbsp;
					<button type="submit" class="btn btn-success">Pesquisar</button><br><br>
			</form>
		</c:if>
		
			<div style="text-align: center; color: green;">${mensagem}</div>
			<div style="text-align: center; color: Green;"> ${mensagemExclusao} </div>	
		<br>
			<table border="1" class="table">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100">Descrição</th>
					<th WIDTH="100">Status</th>
					<th WIDTH="100">Nome</th>
					<th WIDTH="200">Data</th>
					<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'ALUNO'}">
					<th WIDTH="100" colspan="2">Ações</th>
					</c:if>
					<c:if test="${usuarioLogado.perfil eq 'CRAD'}">
					<th WIDTH="100" >Encaminhar</th>
					</c:if>
					<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'PROFESSOR'}">
					<th colspan="2">Feedback</th>
					</c:if>
				</tr>

				<c:forEach var="solicitacao" items="${listarSolicitacao}">
					<tr>
						<td WIDTH="100" BGCOLOR="#b1e89f">${solicitacao.tipoSolicitacao.descricao}</td>
						<c:if test="${solicitacao.status eq 'PENDENTE'}">
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#b1e89f">${solicitacao.status}</td>
						</c:if>
						<c:if test="${solicitacao.status eq 'INDEFERIDO'}">
						<td WIDTH="130" HEIGHT="30" BGCOLOR="red">${solicitacao.status}</td>
						</c:if>
						<c:if test="${solicitacao.status eq 'DEFERIDO'}">
						<td WIDTH="130" HEIGHT="30" BGCOLOR="green">${solicitacao.status}</td>
						</c:if>
						<c:if test="${solicitacao.status eq 'ANALISE'}">
						<td WIDTH="130" HEIGHT="30" BGCOLOR="orange">${solicitacao.status}</td>
						</c:if>
						<td WIDTH="80" BGCOLOR="#b1e89f">${solicitacao.usuario.nome}</td>
			<td WIDTH="80" BGCOLOR="#b1e89f"><fmt:formatDate pattern="dd-MM-yyyy hh:mm" value="${solicitacao.dataHora}"/></td>
						
						
						<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'ALUNO'}">
					 	<td WIDTH="100" BGCOLOR="#b1e89f"><a href="removerSolicitacao?id=${solicitacao.id}">Remover</a>
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="exibirAlterarSolicitacao?id=${solicitacao.id}">Alterar</a>
						</td>
						</c:if>
						<c:if test="${usuarioLogado.perfil eq 'CRAD' }">
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="encaminharPara?id=${solicitacao.id}">Encaminhar</a></td>
						</c:if>
						
						<form action="updateStatus">
						<input type="hidden" name="id" id="id" value="${solicitacao.id}">
						<input type="hidden" name="status" id="status" value="DEFERIDO">
						<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'PROFESSOR' }">
						<td><button type="submit" class="btn btn-info">Deferido</button></td>
						</c:if>
						</form>
						<form action="updateStatus">
						<input type="hidden" name="id" id="id" value="${solicitacao.id}">
						<input type="hidden" name="status" id="status" value="INDEFERIDO">
						<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'PROFESSOR' }">
						<td><button type="submit" class="btn btn-warning">Indeferido</button></td>
						</c:if>
						</form>
					</tr>
					
					
				</c:forEach>	
			</table>
			
			<c:if test="${usuarioLogado.perfil eq 'CRAD'}">
			<br><div style="text-align: center; color: Red;"> ${mensagemNaoEncontrada} </div><br>
			</c:if>
			
			<br><button onclick="voltarPagina()" class="btn">Voltar</button> &nbsp;
		</div>
	</center>
</body>
</html>