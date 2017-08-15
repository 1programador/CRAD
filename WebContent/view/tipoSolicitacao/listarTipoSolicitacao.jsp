<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Tipo de Solicita��o</title>

<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<c:import url="../menu/menu.jsp"/>



<center>
		<div>
			<hr>
			<h3>Tipos de Solicita��es</h3>
			<hr>
			
			<div style="text-align: center; color: Green;"> ${mensagemExclusao} </div>			
			<div style="text-align: center; color: Green;"> ${mensagem} </div>

			<table border="1">
				<tr BGCOLOR="#CCCCCC" ">
					<th WIDTH="100">Id</th>
					<th WIDTH="100">Descri��o</th>
					<th WIDTH="100">Documentos</th>
					<th WIDTH="100">Complementos</th>
					<th WIDTH="100">Anexo</th>
					<center><th WIDTH="100" colspan="5">           A��es</th></center>
				</tr>

				<jsp:useBean id="dao" class="br.ifpe.dao.TipoSolicitacaoDao" />

				<c:forEach var="tipoSolicitacao" items="${listarTipoSolicitacao}">
					<tr>
						<td WIDTH="100" HEIGHT="30" BGCOLOR="#b1e89f">${tipoSolicitacao.id}</td>
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#8dc37a">${tipoSolicitacao.descricao}</td>
						<td WIDTH="80" HEIGHT="30" BGCOLOR="#b1e89f">${tipoSolicitacao.listaDocumentos}</td>
						<td WIDTH="80" HEIGHT="30" BGCOLOR="#b1e89f">${tipoSolicitacao.temComplemento eq true ? "sim" : "n�o"}</td>
						<td WIDTH="80" HEIGHT="30" BGCOLOR="#b1e89f">${tipoSolicitacao.temAnexo eq true ? "sim" : "n�o"}</td>
					
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="removerTipoSolicitacao?id=${tipoSolicitacao.id}">Remover</a>
						<td WIDTH="100" BGCOLOR="#b1e89f"><a href="exibirAlterarTipo?id=${tipoSolicitacao.id}">Alterar</a>
						</td>
					</tr>

					
				</c:forEach>

			</table>
			<a href="/CRAD/home" class="btn btn-danger" role="button">Voltar</a> &nbsp;
		</div>
	</center>


</body>
</html>