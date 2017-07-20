<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Tipo de Solicitação</title>
<link rel="stylesheet" type="text/css"
	href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="menu.jsp"/>



<center>
		<div>
			<hr>
			<h3>Tipos de Solicitações</h3>
			<hr>
			
			<div style="text-align: center; color: red;"> ${mensagemExclusao} </div>			

			<table border="0">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100" HEIGHT="30">Id</th>
					<th WIDTH="100">Descrição</th>
					<th WIDTH="50">Documentos</th>
				</tr>

				<jsp:useBean id="dao" class="br.ifpe.dao.TipoSolicitacaoDao" />

				<c:forEach var="tipoSolicitacao" items="${dao.listar()}">
					<tr>
						<td WIDTH="300" BGCOLOR="#b1e89f">${tipoSolicitacao.id}</td>
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#8dc37a">${tipoSolicitacao.descricao}</td>
						<td WIDTH="300" BGCOLOR="#b1e89f">${tipoSolicitacao.documentos}</td>
					
					</tr>

					
				</c:forEach>

			</table>
			<a href="/CRAD/paginaInicial" class="btn btn-danger"role="button">Voltar</a> &nbsp;
		</div>
	</center>


</body>
</html>