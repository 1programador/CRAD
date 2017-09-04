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
			
			<div style="text-align: center; color: Green;"> ${mensagemExclusao} </div>	

			<table border="1">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100">Descrição</th>
					<th WIDTH="100">Status</th>
					<th WIDTH="100">Nome</th>
					<th WIDTH="200">Data</th>
					<th WIDTH="100" colspan="2">Ações</th>
					<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'PROFESSOR'}">
					<th WIDTH="100">Encaminhar</th>
					</c:if>
				</tr>

				<c:forEach var="solicitacao" items="${listarSolicitacao}">
					<tr>
						<td WIDTH="100" BGCOLOR="#b1e89f">${solicitacao.tipoSolicitacao.descricao}</td>
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#8dc37a">${solicitacao.status}</td>
						<td WIDTH="80" BGCOLOR="#b1e89f">${solicitacao.usuario.nome}</td>
			<td WIDTH="80" BGCOLOR="#b1e89f"><fmt:formatDate pattern="dd-MM-yyyy hh:mm" value="${solicitacao.dataHora}"/></td>
						
						
						
					 	<td WIDTH="100" BGCOLOR="#b1e89f"><a href="removerSolicitacao?id=${solicitacao.id}">Remover</a>
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="?id=">Alterar</a>
						</td>
						<c:if test="${usuarioLogado.perfil eq 'CRAD' || usuarioLogado.perfil eq 'PROFESSOR'}">
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="encaminharPara">Encaminhar</a></td>
						</c:if>
					</tr>
					
					
				</c:forEach>
		
			</table>
			<br>
			<button onclick="voltarPagina()" class="btn">Voltar</button> &nbsp;
		</div>
	</center>
</body>
</html>