<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usu�rio</title>
<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="/view/menu/menu.jsp" />
<center><div>
	<hr>
	<h3>Alterar dados do usu�rio</h3>
	<hr>
	
	<form action="alterar" method="post" enctype="multipart/form-data">
		<p>
		
			<input type="hidden" name="id" value="${usuario.id}" />
			
			<form:errors path="usuario.nome" style="text-align: center; color: red;"/> <!--valida��o fuciona, porem n�o exibe a msg-->
			<div class="form-group">
		<label for="nome">Nome:*</label>
	<input type="text" id="nome" class="form-control"name="nome" value="${usuario.nome}" style="width: 200px;" maxlength="100" />
</div>
			
	<form:errors path="usuario.matricula" style="text-align: center; color: red;"/> <!--valida��o fuciona, porem n�o exibe a msg-->
		
			<div style="text-align: center; color: red;"> ${mensagemJaExiste} </div>
			<div class="form-group">
		<label for="matricula">Matricula:*</label>
	<input type="text" id="matricula" class="form-control"name="matricula" value="${usuario.matricula}" style="width: 200px;" maxlength="100" />
</div>
	
		<div class="form-group">
			<label for="perfil">Perfil:*</label>
			
			<select id="perfil" name="perfil" class="form-control" style="width: 200px;" >
			
			<c:forEach items="${listaPerfil}" var="p">
				<option value="${p}" <c:if test="${p eq usuario.perfil}">selected="selected"</c:if>>
					${p}
				</option>
</c:forEach>
			
			</select>
			</div>
		
		
	
			<button type="reset" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>
		
	</form>
</div></center>

</body>
</html>