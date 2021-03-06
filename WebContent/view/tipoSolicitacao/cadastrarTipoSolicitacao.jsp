<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Tipo de Solicita��o</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js"></script>

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
<c:import url="/view/menu/menu.jsp" />

<center><div>
	<hr>
	<h3>Cadastrar Tipo de Solicita��o</h3>
	<hr>
	
		<div style="text-align: center; color: green;"> ${mensagemSucesso} </div>
		<div style="text-align: center; color: red;"> ${mensagemJaExiste} </div>
	
	<form action="incluirTipoSolicitacao" method="post" enctype="multipart/form-data">
		<p>
			<form:errors path="tipoSolicitacao.descricao" style="text-align: center; color: red;"/>
			<div class="form-group">
				<label for="descricao">Descri��o:*</label>
				<input type="text" id="descricao" class="form-control"name="descricao" style="width: 200px;" maxlength="100" />
			</div>
			
			<form:errors path="tipoSolicitacao.temComplemento" style="text-align: center; color: red;"/> 
			<div class="form-group">
				<label for="anexo">Complemento:*</label>
				<label>Sim</label><input type="radio" name="temComplemento" value="true"  />
				<label>N�o</label><input type="radio" name="temComplemento" value="false" />
			</div>
		
	 	<form:errors path="tipoSolicitacao.temAnexo" style="text-align: center; color: red;"/> 
			<div class="form-group">
				<label for="anexo">Anexo:*</label>
				<label>Sim</label><input type="radio" name="temAnexo" id="radioTrue" value="true" onchange="mostrar()"/>
				<label>N�o</label><input type="radio" name="temAnexo"id="radioFalse" value="false" onchange="esconder()"/>
			</div>
			
			<div class="form-group" id="mostrar" style="height:100px;width:300px;border:1px;visibility:hidden;">
			
				<label for="listaDocumentos">Documentos:</label>
			<select multiple class="form-control" style="width: 390px;" name="listaDocumentos">
  				<option value="a">1-Atestado M�dico</option>
  				<option value="b">2-C�pia da CTPS - Identifica��o e Contrato</option>
  				<option value="c">3-Declara��o de Tranfer�ncia do �rg�o</option>
  				<option value="d">4-Declara��o da Empresa com o respectivo hor�rio</option>
  				<option value="e">5-Guia de Transfer�ncia</option>
  				<option value="f">6-Hist�rico Escolar do Ensino Fundamental (original)</option>
  				<option value="g">7-Hist�rico Escolar do Ensino M�dio (original)</option>
  				<option value="h">8-Hist�rico Escolar do Ensino Superior (original)</option>
  				<option value="i">9-Hist�rico Escolar do Ensino T�cnico</option>
  				<option value="j">10-Ementas das disciplinas cursadas com Aprova��o</option>
  				<option value="k">11-Declara��o de Unidade Militar</option>
			</select>
			</div>
	
			
	
			<button type="reset" class="btn btn-danger" role="button">Limpar &nbsp;</button>
		<button type="submit" class="btn btn-success"> &nbsp; Cadastrar &nbsp; </button>
		
	</form>
</div></center>

</body>
</html>