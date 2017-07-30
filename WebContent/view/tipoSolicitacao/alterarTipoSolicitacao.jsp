<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar tipo de Solicitação</title>
<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<center>
<c:import url="/view/menu/menu.jsp" />

<div style="text-align: center; color: red;"> ${mensagemJaExiste} </div>
	
	<form action="alterarTipo" method="post">
		<p>
		
			<input type="hidden" name="id" value="${tipoSolicitacao.id}" />
			
			<form:errors path="tipoSolicitacao.id" style="text-align: center; color: red;"/> <!--validação fuciona, porem não exibe a msg-->

<div class="form-group">
		<label for="descricao">descricao:*</label>
	<input type="text" id="descricao" class="form-control"name="descricao" value="${tipoSolicitacao.descricao}" style="width: 200px;" maxlength="100" />
</div>


<div class="form-group">
		<label for="documentos">Documentos:*</label>
	<input type="text" id="documentos" class="form-control"name="documentos" value="${tipoSolicitacao.documentos}" style="width: 200px;" maxlength="100" />
</div>


		<button type="reset" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>

</form>
</center>
</body>
</html>