<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"  href="view/menu/teste.css" />
<link rel="stylesheet" type="text/css"href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"src="view/bootstrap/js/bootstrap.min.js"></script>
<!--[if lte IE 8]>
 <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
 <![endif]-->  

</head>
<body>

<center>

<h1>CRAD</h1>
		
		<nav>
	  		<ul class="menu" id="menu">
			<li><a href="/CRAD/home">Home</a></li>
			   <li><a href="#">Usuário</a>
		         	<ul>
		                  <li><a href="/CRAD/cdu">Cadastrar</a></li>
		                  <li><a href="/CRAD/lu">Pesquisar</a></li>
		       		</ul>
				</li>
				
			 <li><a href="#">Tipo de Solicitação</a>
	         	<ul>
	                  <li><a href="/CRAD/cds">Cadastrar</a></li>
	                  <li><a href="/CRAD/listarSolicitacao">Pesquisar</a></li>                    
	       		</ul>
			</li>
		    
            <li><a href="#">Solicitação</a>
      	        <ul>
	                  <li><a href="/CRAD/rs">Registrar</a></li>
	                  <li><a href="/CRAD/as">Acompanhamento</a></li>                    
	       		</ul>
			</li>

		<li><a href="#">Logout</a></li>               
</ul>
</nav>
</center>


</body>
</html>