<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários Cadastrados</title>
<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

function voltarPagina() {
	window.location.href = "http://localhost:8080/CRAD/home"
}

</script>

</head>
<body>
<c:import url="/view/menu/menu.jsp" />
	<center>
		<div>
			<hr>
			<h3>Usuários Cadastrados</h3>
			<hr>
			
			<form action="pesquisarUsuario">
			
					<div class="form-group">
				<label for="nome">Nome:</label>
					<input type="text" id="nome" name="nome" class="form-control" style="width: 200px;">
					</div>
					<div class="form-group">		
				<label for="nome">Matricula:</label>
					<input type="text" id="matricula" name="matricula" class="form-control" style="width: 200px;">
				</div>
				
					<button type="reset" class="btn btn-danger">Limpar</button> &nbsp; &nbsp;
					<button type="submit" class="btn btn-success">Pesquisar</button><br><br>
			</form>
			
			<div style="text-align: center; color: green;"> ${mensagemAlterarSucesso} </div>
			
			<div style="text-align: center; color: Green;"> ${mensagemExclusao} </div>			
			<div style="text-align: center; color: Green;"> ${mensagem} </div>
			<table border="1">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100" HEIGHT="30">Matrícula</th>
					<th WIDTH="100">Nome</th>
					<th WIDTH="100">Perfil</th>
					<th colspan="2">Ações</th>
				</tr>

				<jsp:useBean id="dao" class="br.ifpe.dao.UsuarioDao" />

				<c:forEach var="usuario" items="${listaUsuario}">
					<tr>
						<td WIDTH="130" HEIGHT="30" ${usuario.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${usuario.matricula}</td>
						<td WIDTH="130" HEIGHT="30" ${usuario.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${usuario.nome}</td>
						<td WIDTH="130" HEIGHT="30" ${usuario.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}>${usuario.perfil}</td>
						
						<td WIDTH="100" ${usuario.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}><a href="removerUsuario?id=${usuario.id}" style="color: #BDB76B" >${usuario.excluido eq true ? "Desativar" : "Ativar"}</a>
						<td WIDTH="100" ${usuario.excluido eq true ? "BGCOLOR='#b1e89f'" : "BGCOLOR='#d9534f'"}><a href="exibirAlterarUsuario?id=${usuario.id}" style="color: #BDB76B	">Alterar</a>
						</td>
					</tr>

				</c:forEach>

			</table>
			<br>
			<button onclick="voltarPagina()" class="btn">Voltar</button> &nbsp;
		</div>
	</center>

</body>
</html>