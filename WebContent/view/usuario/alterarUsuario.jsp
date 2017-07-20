<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usuário</title>
<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="/view/menu/menu.jsp" />
<center><div>
	<hr>
	<h3>Alterar dados do usuário</h3>
	<hr>
	
	<form action="alterar" method="post" enctype="multipart/form-data">
		<p>
		
			<input type="hidden" name="id" value="${usuario.id}" />
			
			<div class="form-group">
		<label for="nome">Nome:*</label>
	<input type="text" id="nome" class="form-control"name="nome" value="${usuario.nome}" style="width: 200px;" maxlength="100" />
</div>
		
		
			<div class="form-group">
		<label for="matricula">Matricula:*</label>
	<input type="text" id="matricula" class="form-control"name="matricula" value="${usuario.matricula}" style="width: 200px;" maxlength="100" />
</div>
	
		
		<div class="form-group">
			<label for="perfil">Perfil:*</label>
			
			<select id="perfil" name="perfil" class="form-control" style="width: 200px;" >
			<option value="">Selecione uma opção</option>
			<option value="ALUNO">Aluno</option>
			<option value="PROFESSOR">Professor</option>
			<option value="COORDENADOR">Coordenador</option>
			
			</select>
			</div>
		
		
	
			<button type="reset" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>
		
	</form>
</div></center>

</body>
</html>