<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários Cadastrados</title>
<link rel="stylesheet" type="text/css"
	href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="menu.jsp"/>
	<center>
		<div>
			<hr>
			<h3>Usuários Cadastrados</h3>
			<hr>
			

			<table border="0">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100" HEIGHT="30">Matrícula</th>
					<th WIDTH="100">Nome</th>
					<th WIDTH="50">Perfil</th>
					<th>Ações</th>
				</tr>

				<jsp:useBean id="dao" class="br.ifpe.dao.UsuarioDao" />

				<c:forEach var="usuario" items="${dao.listar()}">
					<tr>
						<td WIDTH="130" HEIGHT="30" BGCOLOR="#8dc37a">${usuario.matricula}</td>
						<td WIDTH="300" BGCOLOR="#b1e89f">${usuario.nome}</td>
						<td BGCOLOR="#8dc37a">${usuario.perfil}</td>
						<td><a href="removerUsuario?id=${usuario.id}">Remover</a></td>
					</tr>

					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>
				</c:forEach>

			</table>
			<a href="/CRAD/paginaInicial" class="btn btn-danger"role="button">Voltar</a> &nbsp;
		</div>
	</center>

</body>
</html>