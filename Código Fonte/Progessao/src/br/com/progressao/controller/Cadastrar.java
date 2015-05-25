package br.com.progressao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.progressao.model.User;


@WebServlet("/view/cadastro_ok")
public class Cadastrar extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		long cpf;
		String CPF;
		String senha1;
		String senha2;
		String nome;
		String email;
		
		CPF=request.getParameter("cpf");
		senha1=request.getParameter("senha");
		senha2=request.getParameter("senha2");
		nome=request.getParameter("nome");
		email=request.getParameter("email");
		cpf = Long.parseLong(CPF);
		
		System.out.println(cpf + "\n" + senha1 + "\n" + senha2 + "\n" + nome);
		
		if(senha1.equals(senha2)){
			response.sendRedirect("../view/cadastro_ok.html");
			User user = new User(cpf,nome,email,senha1);
			UserBDD banco = new UserBDD();
			banco.adiciona(user);
			System.out.println("OK");
		
		}
		else{
			response.sendError(response.SC_BAD_REQUEST,"ERROR");

		}
	}
}
