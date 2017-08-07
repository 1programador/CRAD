<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acompanhar Solicitação</title>
</head>
<body>

<c:import url="../menu/menu.jsp"/>



<center>
		<div>
			<hr>
			<h3></h3>
			<hr>
			
		<!-- <div style="text-align: center; color: Green;"> ${} </div>			
			<div style="text-align: center; color: Green;"> ${} </div> -->

			<table border="0">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100">Descrição</th>
					<th WIDTH="100">Status</th>
					<th WIDTH="100">Nome</th>
					<th WIDTH="100">Data</th>
					<th>Ações</th>
				</tr>

			<!--	<jsp:useBean id="dao" class="br.ifpe.dao.TipoSolicitacaoDao" /> 

				<c:forEach var="tipoSolicitacao" items="${listarTipoSolicitacao}">
					<tr>
						<td WIDTH="100" BGCOLOR="#b1e89f">${tipoSolicitacao.id}</td>
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#8dc37a">${tipoSolicitacao.descricao}</td>
						<td WIDTH="80" BGCOLOR="#b1e89f">${tipoSolicitacao.documentos}</td>
					
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="removerTipoSolicitacao?id=${tipoSolicitacao.id}">Remover</a>
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="exibirAlterarTipo?id=${tipoSolicitacao.id}">Alterar</a>
						</td>
					</tr>

					
				</c:forEach>
		-->
			</table>
			<a href="/CRAD/home" class="btn btn-danger"role="button">Voltar</a> &nbsp;
		</div>
	</center>
</body>
</html>