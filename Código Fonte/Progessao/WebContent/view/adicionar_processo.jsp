<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>UFBA - Sistema de Abertura de Processos</title>
		<!-- BOOTSTRAP -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/signin.css">
		<!--<script type="text/javascript" src="js/url_index.js"></script>-->
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  			<div class="container">
  				<img src="img/logo.png">
  			</div>
		</nav>
						
		<div class="container">
			<div class="alert alert-success" role="alert"><h3>Processo adicionado com sucesso. </h3></div>
			<p>
  				<button type="button" onclick="redirecionar();" class="btn btn-default btn-lg">
  					<span class="glyphicon glyphicon-log-out"></span> Sair
  				</button>

  				<button type="button" onclick="pdfview();" class="btn btn-default btn-lg">
  					<span class="glyphicon glyphicon-list-alt"></span> Gerar PDF
  				</button>
			</p>
   		</div>
				
		<footer class="footer">
			<div class="container">
				<address>
					<strong>UFBA - Universidade Federal da Bahia</strong><br>
					Avenida Ademar de Barros, S/N - Campus de Ondina <br>
					CEP 40.170-110 Salvador-Bahia.<br>
					Telefone: 3283-6124 / Fax: 3283-6123
				</address>
			</div>
		</footer>
		<script type="text/javascript">
			function redirecionar() {
				location.href = "index.html";
			}
			
			function pdfview() {
				location.href = "Exibir";
			}
		</script>
	</body>
</html>