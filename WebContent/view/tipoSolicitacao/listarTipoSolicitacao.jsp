<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Tipo de Solicita��o</title>

<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

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
			<h3>Tipos de Solicita��es</h3>
			<hr>
			
			<div style="text-align: center; color: Green;"> ${mensagemExclusao} </div>			
			<div style="text-align: center; color: Green;"> ${mensagem} </div>

			<div>

				<label for="descricao">Descri��o:</label> <br />
				<form action="pesquisarTipoSolicitacao">
					<input type="text" id="descricao" name="descricao" class="form-control" style="width: 200px;" maxlength="100">
					<br>
					<button type="reset" class="btn btn-danger">Limpar</button>
					
					<button type="submit" class="btn btn-success">Pesquisar</button>
					<br>
					<br>
				</form>

			</div>

			<table border="1" class="table">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100">Descri��o</th>
					<th WIDTH="100">Documentos</th>
					<th WIDTH="100">Complementos</th>
					<th WIDTH="100">Anexo</th>
					<th WIDTH="100" colspan="5">A��es</th>
				</tr>

		<!--  <jsp:useBean id="dao" class="br.ifpe.dao.TipoSolicitacaoDao" />  -->

			<c:forEach var="tipoSolicitacao" items="${listarTipoSolicitacao}">
					
					<tr>			
<td WIDTH="130" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.descricao}</td>
<td WIDTH="80" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.listaDocumentos}</td>
<td WIDTH="80" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.temComplemento eq true ? "sim" : "n�o"}</td>
<td WIDTH="80" HEIGHT="30" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${tipoSolicitacao.temAnexo eq true ? "sim" : "n�o"}</td>
					
<td WIDTH="100" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}><a href="removerTipoSolicitacao?id=${tipoSolicitacao.id}" style="color: #BDB76B" >${tipoSolicitacao.excluido eq true ? "Desativar" : "Ativar"}</a>
<td WIDTH="100" ${tipoSolicitacao.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}><a href="exibirAlterarTipo?id=${tipoSolicitacao.id}" style="color: #BDB76B	">Alterar</a>
						</td>
					</tr>
			</c:forEach>
		
		
			
			</table>
			<br>
			<div style="text-align: center; color: Red;"> ${mensagemNaoEncontrada} </div>
			
		<!-- <button onclick="voltarPagina()" class="btn">Voltar</button> &nbsp; -->
		</div>
	</center>


</body>
</html>