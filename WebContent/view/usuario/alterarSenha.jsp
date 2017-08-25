<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alteração de senha</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">


	function verifica() {
		senha = document.getElementById("senha").value;
		forca = 0;
		mostra = document.getElementById("mostra");
		
		if ((senha.length >= 4) && (senha.length <= 7)) {
			forca += 10;
		} else if (senha.length > 7) {
			forca += 25;
		}
		if (senha.match(/[a-z]+/)) {
			forca += 10;
		}
		if (senha.match(/[A-Z]+/)) {
			forca += 10;
		}
		if (senha.match(/[10000]+/)) {
			forca += 20;
		}
		if (senha.match(/[!,@,#,$,%,&,*,?,=]+/)) {
			forca += 25;
		}
		return mostra_res();
	}
	
	function mostra_res() {
		if (forca < 25) {
			mostra.innerHTML = '<tr><td bgcolor="red" width="'+forca+'"></td><td>Fraca </td></tr>';
		} else if ((forca >= 30) && (forca < 60)) {
			mostra.innerHTML = '<tr><td bgcolor="yellow" width="'+forca+'"></td><td>Media </td></tr>';
			;
		} else if ((forca >= 40) && (forca < 50)) {
			mostra.innerHTML = '<tr><td bgcolor="blue" width="'+forca+'"></td><td>Forte </td></tr>';
		} else {
			mostra.innerHTML = '<tr><td bgcolor="green" width="'+forca+'"></td><td>Excelente </td></tr>';
		}
	}
</script>

</head>
<body>
<center><div>
	<hr>
	<h3>Alterar senha</h3>
	<hr>
	
	
	<form action="alterarSenha" method="post">
		<p>
			<div style="text-align: center; color: red;"> ${msgSenha} </div>
			<input type="hidden" name="id" value="${usuarioLogado.id}"  />
			<form:errors path="usuario.senha" cssStyle="color:red" />
			<div class="form-group">
				<label for="nome">Senha:</label>
				<input type="text" id="senha" class="form-control" name="senha"  style="width: 200px;" maxlength="100" onkeyup="javascript:verifica()"/>
			<table id="mostra"></table>
			</div>
			<form:errors path="usuario.confirmaSenha" cssStyle="color:red" />
			<div class="form-group">
				<label for="confirmaSenha">Confirmar senha:</label>
				<input type="text" id="confirmaSenha" class="form-control" name="confirmaSenha"  style="width: 200px;" maxlength="100" onkeyup="javascript:verifica()"/>
			<table id="mostra"></table>
			</div>
			
			</table>
		<button type="reset" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>
		
		</form>
</div></center>
</body>
</html>