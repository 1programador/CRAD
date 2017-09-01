<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Usuário</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js">
</script>

</head>
<body>
<c:import url="/view/menu/menu.jsp" />
<center><div>
	<hr>
	<h3>Cadastrar Usuário</h3>
	<hr>
	
	<div style="text-align: center; color: green;"> ${mensagemSucesso} </div>
	<div style="text-align: center; color: red;"> ${mensagemJaExiste} </div>
	
	
	<form action="incluirUsuario" method="post" enctype="multipart/form-data">
		<p>
			<form:errors path="usuario.nome" style="text-align: center; color: red;"/>
			<div class="form-group">	
		<label for="nome">Nome:*</label>
	<input type="text" id="nome" class="form-control"name="nome" style="width: 200px;" maxlength="100" />
</div>
		
		<form:errors path="usuario.matricula" style="text-align: center; color: red;"/>
			<div class="form-group">
		<label for="matricula">Matricula:*</label>
	<input type="text" id="matricula" class="form-control"name="matricula" style="width: 200px;" maxlength="100" />
</div>
	
		<form:errors path="usuario.perfil" style="text-align: center; color: red;"/>
		<div class="form-group">
			<label for="perfil">Perfil:*</label><select id="perfil" name="perfil" class="form-control" style="width: 200px;" >
			
			<option value="">Selecione uma opção</option>
			<option value="ALUNO">ALUNO</option>
			<option value="PROFESSOR">PROFESSOR</option>
			<option value="CRAD">CRAD</option>
			
			</select>
			</div>
		
		
	
			<button type="reset" class="btn btn-danger" role="button">Limpar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Cadastrar &nbsp;</button>
		
	</form>
</div></center>
</body>
</html>