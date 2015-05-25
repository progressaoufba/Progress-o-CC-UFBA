<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 
<%@page import="br.com.progressao.controller.*"%>
<%@page import="br.com.progressao.model.*"%>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>


<html lang="pt-br">
<head>
<meta charset="utf-8">

<title>UFBA - Sistema de Progressão dos Docentes</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<style>
	.processo{
  		width: auto; 
    	left: auto; 
    	margin: -190px 0 0px -150px; 
    	padding:190px;
	}

	.formulario{
		display: none;
	}

	.tabela{
		display: block;
	}
		
	.cadastro{
		width: 900px;
		left: 900%;
		margin: -100px 0 0 -130px;
		padding:150px;
	}

	.footer {
	    position: relative;
	    bottom:0;
	    width:100%;
	    font-size: 14px;
	    padding-top: 50px;
	    padding-bottom: 15px;
	    background-color: #000000;
	    color: #bdc3c7;
	}

</style>
<script> 
		window.onload=function(){
			document.getElementById("mostrar_listagem_processos").onclick=function(){
				document.getElementsByClassName("tabela")[0].style.display="block";
				document.getElementsByClassName("formulario")[0].style.display="none";
			};
			document.getElementById("mostrar_cadastro_processo").onclick=function(){
				document.getElementsByClassName("formulario")[0].style.display="block";
				document.getElementsByClassName("tabela")[0].style.display="none";
			};
		};
</script>

<body>
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
  		<div class="container">
  			<img src="img/logo.png">
  		</div>
	</nav>

	<div class="container">
		<div class="processo">
			<ul class="nav nav-tabs" role="tablist">
				<li id="mostrar_listagem_processos"><a href="#">Pontos da progressão</a></li>
	        	<li  id="mostrar_cadastro_processo"><a href="#">Enviar Curriculo Lattes</a></li>
	      	</ul>
	      	<div class="formulario">
	      		<br>
	      		<form enctype="multipart/form-data"  method="POST"  action="adicionar_processo"> 
  					<fieldset>
    					<legend>Currículo Lattes(XML)</legend>

				
						
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<label> Anexar arquivo
									<input type="file" name="arquivo" class="filestyle" data-size="sm">
								</label>
							</div>
						</div>
						
					<!--	<legend>Esclarecimentos</legend>
						<textarea name="esclarecimento" class="form-control"  rows="5"></textarea>
    				-->
    					
   						
   						<button type="submit" class="btn btn-default btn-lg">
  							<span class="glyphicon glyphicon-floppy-disk"></span> Enviar
						</button>
  						<button type="button" class="btn btn-default btn-lg">
  							<span class="glyphicon glyphicon-remove"></span> Cancelar
						</button>
						
  					</fieldset>
				</form>
			
	      	</div>
	      	
	      	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		      
		      <jsp:useBean id="listaDeProcessos" class="br.com.progressao.model.ListaDeProcessos" scope="request"/>
	      		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	      	<div class="tabela">     
		       
		        <table class="table table-striped">
		        	
		        	<thead>
		              <tr>
		                <th>Login Realizado com Sucesso</th>
		              </tr>
		            </thead>
		            
		            <tbody>
		             
   					<c:if test="${ not empty listaDeProcessos.listaDeProcessosUser}">
		              <c:forEach items="${listaDeProcessos.listaDeProcessosUser}" var="processo">
		              <tr>
		                <c:if test="${not empty listaDeProcessos.listagemFalsa}">
		                	<td><c:out value="${processo.id}" /></td>
		                </c:if>
		                <c:if test="${not empty listaDeProcessos.listagemFalsa}">
		                	<td><c:out value="${processo.dataAtual.getTime()}" /></td>
		                </c:if> 
		                 <c:if test="${not empty listaDeProcessos.listagemFalsa}">
		                <td>-</td>
		                 </c:if> 
		                <c:if test="${not empty listaDeProcessos.listagemFalsa}">
		                <td>Em andamento</td> 		<!-- falta esses dois campos na tabela  -->
		                 </c:if> 
		               <c:if test="${not empty listaDeProcessos.listagemFalsa}">
		                <td>ainda nao finalizado</td> <!-- falta esses dois campos na tabela  -->
		              	</c:if>
		              </tr>
		           	</c:forEach>   
		         </c:if>
		    
		           </tbody>
		            
		            </table>
		   </div>
	    </div>
    </div>
	

<footer class="footer">
	<div class="container">
		<address>
			<strong>UFBA - Universidade Federal da Bahia</strong><br>
			Avenida Ademar de Barros, S/N - Campus de Ondina <br> CEP
			40.170-110 Salvador-Bahia.<br> Telefone: 3283-6124 / Fax: 3283-6123
		</address>
	</div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.js" charset="utf-8"></script>
<script src="js/bootstrap.min.js"></script>


</body>
</html>
