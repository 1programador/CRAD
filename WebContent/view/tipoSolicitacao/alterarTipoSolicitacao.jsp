<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar tipo de Solicitação</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

	function mostrar(){
	
		var radioTrue = document.getElementById("radioTrue").value;
		
      	if(radioTrue == "true"){
            document.getElementById("mostrar").style.visibility ="visible";
        }
	}
    
	function esconder(){
		
		var radioFalse = document.getElementById("radioFalse").value;
		
	  	if(radioFalse == "false"){
	   		document.getElementById("mostrar").style.visibility = "hidden";
	  	}    
 	}
	    
</script>

</head>
<body>
<center>
<c:import url="/view/menu/menu.jsp" />

<div style="text-align: center; color: red;"> ${mensagemAlterarJaExiste} </div>
	
	<form action="alterarTipo" method="post">
		<p>
		
			<input type="hidden" name="id" value="${tipoSolicitacao.id}" />
			
			<form:errors path="tipoSolicitacao.descricao" style="text-align: center; color: red;"/>
		<div class="form-group">
			<label for="descricao">Descrição:*</label>
			<input type="text" id="descricao" class="form-control"name="descricao" value="${tipoSolicitacao.descricao}" style="width: 200px;" maxlength="100" />
		</div>

			<div class="form-group">
				<label for="temComplemento" >Complemento:*</label>
				<label>Sim</label><input type="radio" name="temComplemento" value="true" 
				<c:if test="${tipoSolicitacao.temComplemento eq true}"> checked="checked" </c:if> > 
				<label>Não</label><input type="radio" name="temComplemento" value="false"
				<c:if test="${tipoSolicitacao.temComplemento eq false}"> checked="checked" </c:if> >
			</div>
			
			<form:errors path="tipoSolicitacao.temAnexo" style="text-align: center; color: red;"/> 
			<div class="form-group">
				<label for="temAnexo">Anexo:*</label>
				<label>Sim</label><input type="radio" name="temAnexo" id="radioTrue" value="true" onchange="mostrar()"
				<c:if test="${tipoSolicitacao.temAnexo eq true}">checked="checkd" </c:if> >
				<label>Não</label><input type="radio" name="temAnexo"id="radioFalse" value="false" onchange="esconder()"
				<c:if test="${tipoSolicitacao.temAnexo eq false}"> checked="checked" </c:if> >
			</div>
				
<div class="form-group" id="mostrar" style="height:100px;width:300px;border:1px;visibility:hidden;">
			
<label for="listaDocumentos">Documentos:</label>
	<select multiple class="form-control" style="width: 390px;" name="listaDocumentos">
  				<option value="a">1-Atestado Médico</option>
  				<option value="b">2-Cópia da CTPS - Identificação e Contrato</option>
  				<option value="c">3-Declaração de Tranferência do Órgão</option>
  				<option value="d">4-Declaração da Empresa com o respectivo horário</option>
  				<option value="e">5-Guia de Transferência</option>
  				<option value="f">6-Histórico Escolar do Ensino Fundamental (original)</option>
  				<option value="g">7-Histórico Escolar do Ensino Médio (original)</option>
  				<option value="h">8-Histórico Escolar do Ensino Superior (original)</option>
  				<option value="i">9-Histórico Escolar do Ensino Técnico</option>
  				<option value="j">10-Ementas das disciplinas cursadas com Aprovação</option>
  				<option value="k">11-Declaração de Unidade Militar</option>
			</select>
		</div>


		<button type="reset" class="btn btn-danger" role="button">Cancelar &nbsp; </button>
		<button type="submit" class="btn btn-success"> &nbsp; Alterar &nbsp;</button>

	<c:if test="${tipoSolicitacao.temAnexo eq true}">
		<script type="text/javascript">
			mostrar();
		</script>
	</c:if>

</form>
</center>
</body>
</html>