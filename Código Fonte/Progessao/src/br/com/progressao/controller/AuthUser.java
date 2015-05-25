package br.com.progressao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.progressao.model.ListaUser;
import br.com.progressao.model.User;

@WebServlet("/view/after_login")
public class AuthUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		long cpf;
		String CPF;
		String senha;
		CPF=request.getParameter("cpf");
		senha=request.getParameter("senha");
		cpf = Long.parseLong(CPF);
		User user = new User(cpf,senha);
		System.out.println(user.isValido());
		validarUser(user);
		List<User> processosUser = obterUsuarioCpf(cpf);

		
		if(user.isValido() == false){
			response.sendRedirect("../view/index.html");
			System.out.println("fail");
		}else{
			System.out.println("teste");
			HttpSession session = request.getSession(); 
			session.setAttribute("User", user);
			
			ListaUser listaDeUsuarios = new ListaUser();
			
			if(processosUser.isEmpty()){
				User user1 = new User(0," "," ", "");
				listaDeUsuarios.setListagemFalsa("");
				processosUser.add(user1);
				listaDeUsuarios.setListaDeProcessosUser(processosUser);
			}else{
				listaDeUsuarios.setListagemFalsa("t");
				listaDeUsuarios.setListaDeProcessosUser(processosUser);
			}

			RequestDispatcher rd;
			
			request.setAttribute("listaDeUsuarios", listaDeUsuarios);
			rd = getServletContext().getRequestDispatcher("/view/after_login.jsp"); 
			rd.forward(request, response); 
		}
	} 		

	private static long validarUser(User user){
		UserBDD banco = new UserBDD();
		
		List<User> usuarios = banco.getLista();

		for (User usuario : usuarios ) {

			if(user.getCpf() == usuario.getCpf() && user.getPassword().equals(usuario.getPassword()))
				user.setValido(true);
		}
		return user.getCpf();
	}
	
	private static List<User> obterUsuarioCpf(long cpfUser) {
		UserBDD userbdd = new UserBDD();
		List<User> todosUsuarios = userbdd.getLista();
		List<User> ListagemUser = new ArrayList<User>();
		for (User  user : todosUsuarios) {

			if(cpfUser == user.getCpf()){
				System.out.println("cpfUser: "+ cpfUser);
				ListagemUser.add(user);
			}
		}
		
			return ListagemUser;
	}
}
