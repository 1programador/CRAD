<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Serviço</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="menu.jsp"/>
<center><div>
	<hr>
	<h3>Cadastrar Servico</h3>
	<hr>
	
		<div style="text-align: center; color: red;"> ${mensagemServico} </div>
	
	
	<form action="incluirTipoSolicitacao" method="post" enctype="multipart/form-data">
		<p>
			<div class="form-group">
				<label for="descricao">Descrição:*</label>
				<input type="text" id="descricao" class="form-control"name="descricao" style="width: 200px;" maxlength="100" />
			</div>
		
		
			<div class="form-group">
				<label for="anexo">Anexo:*</label>
				<label>Sim</label><input type="radio" name="anexo" value="true"  />
				<label>Não</label><input type="radio" name="anexo" value="false" />
			</div>
	
			<div class="form-group">
				<label for="anexo">Complemento:*</label>
				<label>Sim</label><input type="radio" name="complemento" value="true"  />
				<label>Não</label><input type="radio" name="complemento" value="false" />
			</div>
				
		
		
	
			<a href="/CRAD/paginaInicial" class="btn btn-danger"role="button">Cancelar</a> &nbsp;
		<button type="submit" class="btn btn-success"> &nbsp; Cadastrar &nbsp;
		</button>
	</form>
</div></center>

</body>
</html>