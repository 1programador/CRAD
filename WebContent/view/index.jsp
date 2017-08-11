<%@ page language="java" contentType="text/html; charset=iso-8859-1"   pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRAD</title>

<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<p>
<center><h3>Informe sua matrícula para acessar o sistema.</h3></center>
</p>
<div style="color: red;" align="center"> <h3> ${msg} </h3> </div>
<p>
	<center>
		<form action="efetuarLogin" method="post">
	<div class="form-group">
		<label for="matricula">Matrícula:*</label>
		<input type="text" id="mtricula" name="matricula" class="form-control" style="width: 200px;" maxlength="100" />
	</div>

		<button type="submit" class="btn btn-success"> &nbsp; Entrar &nbsp;
		</button>
		</form>
		</center>

</body>
</html>