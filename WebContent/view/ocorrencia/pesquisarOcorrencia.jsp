<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pesquisar Ocorrencia</title>
<script type="text/javascript">

function voltarPagina() {
	window.location.href = "http://localhost:8080/CRAD/home"
}

</script>
</head>
<body>

<c:import url="../menu/menu.jsp"/>

<center>
		<div>
			<hr>
			<h3>Pesquisar Ocorrencia</h3>
			<hr>	

			<table border="1">
				<tr BGCOLOR="#CCCCCC">
					<th WIDTH="100">Nº  Solicitaco</th>
					<th WIDTH="100">Ação</th>
					<th WIDTH="100">Usuario</th>
					<th WIDTH="100">Data e Hora</th>
				</tr>

				<c:forEach var="listarOcorrencia" items="${listarOcorrencia}">
					<tr>
						<td WIDTH="100" BGCOLOR="#b1e89f">${listarOcorrencia.id}</td>
						<td WIDTH="100" BGCOLOR="#b1e89f">${listarOcorrencia.acao}</td>
						<td WIDTH="80" BGCOLOR="#b1e89f">${listarOcorrencia.usuario.nome}</td>
						<td WIDTH="80" BGCOLOR="#b1e89f"><fmt:formatDate pattern="dd-MM-yyyy hh:mm" value="${listarOcorrencia.dataHora}"/></td>
					</tr>
					
					
				</c:forEach>
		
			</table>
			<br>
			<button onclick="voltarPagina()" class="btn">Voltar</button> &nbsp;
		</div>
	</center>

</body>
</html>