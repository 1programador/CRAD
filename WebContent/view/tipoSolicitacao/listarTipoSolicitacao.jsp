<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Tipo de Solicitação</title>

<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="view/css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="view/css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="view/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body>

<c:import url="../menu/menu.jsp"/>



<center>
		<div>
			<hr>
			<h3>Tipos de Solicitações</h3>
			<hr>
			
			<div style="text-align: center; color: Green;"> ${mensagemExclusao} </div>			
			<div style="text-align: center; color: Green;"> ${mensagem} </div>

			<div>

				<label for="descricao">Descrição:</label> <br />
				<form action="pesquisarTipoSolicitacao">
					<input type="text" id="descricao" name="descricao" class="form-control" >
					<button type="reset" class="btn btn-danger">Limpar</button>
					
					<button type="submit" class="btn btn-success">Pesquisar</button>
					<br>
					<br>
				</form>

			</div>

			<table border="1">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100">Descrição</th>
					<th WIDTH="100">Documentos</th>
					<th WIDTH="100">Complementos</th>
					<th WIDTH="100">Anexo</th>
					<center><th WIDTH="100" colspan="5">Ações</th></center>
				</tr>

			<jsp:useBean id="dao" class="br.ifpe.dao.TipoSolicitacaoDao" />

			<c:forEach var="tipoSolicitacao" items="${listarTipoSolicitacao}">
					
					<tr>			
<td WIDTH="130" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.descricao}</td>
<td WIDTH="80" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.listaDocumentos}</td>
<td WIDTH="80" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.temComplemento eq true ? "sim" : "não"}</td>
<td WIDTH="80" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.temAnexo eq true ? "sim" : "não"}</td>
					
<td WIDTH="100" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}><a href="removerTipoSolicitacao?id=${tipoSolicitacao.id}" style="color: #BDB76B" >${tipoSolicitacao.excluido eq true ? "Desativar" : "Ativar"}</a>
<td WIDTH="100" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}><a href="exibirAlterarTipo?id=${tipoSolicitacao.id}" style="color: #BDB76B	">Alterar</a>
						</td>
					</tr>
			</c:forEach>
		
		
			
			</table>
			<br>
			<div style="text-align: center; color: Red;"> ${mensagemNãoEncontrada} </div>
			<br>
			<a href="/CRAD/home" class="btn btn-danger" role="button">Voltar</a> &nbsp;
		</div>
	</center>


</body>
</html>