<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários Cadastrados</title>
<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="/view/menu/menu.jsp" />
	<center>
		<div>
			<hr>
			<h3>Usuários Cadastrados</h3>
			<hr>
			
			<form action="pesquisarUsuario">
				<p>	Nome: <br />
					<input type="text" id="nome" name="nome">
				</p>		
				<p>	Matricula: <br />
					<input type="text" id="matricula" name="matricula">
				</p>
				
					<button type="reset" class="btn btn-danger">Limpar</button> &nbsp; &nbsp;
					<button type="submit" class="btn btn-success">Pesquisar</button><br><br>
			</form>
			
			<div style="text-align: center; color: green;"> ${mensagemAlterarSucesso} </div>

			<table border="0">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100" HEIGHT="30">Matrícula</th>
					<th WIDTH="100">Nome</th>
					<th WIDTH="100">Perfil</th>
					<th>Ações</th>
				</tr>

				<jsp:useBean id="dao" class="br.ifpe.dao.UsuarioDao" />

				<c:forEach var="usuario" items="${listaUsuario}">
					<tr>
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#8dc37a">${usuario.matricula}</td>
						<td WIDTH="300" BGCOLOR="#b1e89f">${usuario.nome}</td>
						<td BGCOLOR="#8dc37a">${usuario.perfil}</td>
						
						<td><a href="removerUsuario?id=${usuario.id}">Remover</a>
						<a href="exibirAlterarUsuario?id=${usuario.id}">Alterar</a>
						</td>
					</tr>

				</c:forEach>

			</table>
			<a href="/CRAD/home" class="btn btn-danger"role="button">Voltar</a> &nbsp;
		</div>
	</center>

</body>
</html>