<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alteração de senha</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<center><div>
	<hr>
	<h3>Alterar senha</h3>
	<hr>
	
	<div style="text-align: center; color: red;"> ${msg} </div>
	<form action="alterarSenha" method="post">
		<p>
		
			<input type="hidden" name="id" value="${usuarioLogado.id}" />
			
			
			<div class="form-group">
				<label for="nome">Senha:</label>
				<input type="text" id="senha" class="form-control" name="senha"  style="width: 200px;" maxlength="100" />
			</div>
			
		<button type="reset" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>
		
		</form>
</div></center>
</body>
</html>