package br.com.progressao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.progressao.model.User;

@WebFilter("/view/processos_aluno.html")
public class MeuFiltro implements Filter { 
	  public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException { 
		  HttpServletRequest req = (HttpServletRequest) request;
	      HttpSession session = req.getSession();
	      User user = (User)session.getAttribute("User");
		  
		 System.out.println("passou pelo filtro");
	     //UserBDD banco = new UserBDD();
		 //String CPF;
	     //List<User> usuarios = banco.getLista();
	     
	    
	     /*
	     for (User usuario : usuarios ) {
	    	 CPF = String.valueOf(usuario.getCpf());
	    	 if(request.getParameter("cpf")!=null && request.getParameter("senha")!= null && request.getParameter("cpf").equals(CPF) && request.getParameter("senha").equals(usuario.getPassword())){
	    		 //request.getRequestDispatcher("/view/processos_aluno.html").forward(request,response);
	    		 //juntar o cpf de user com de processo
	    		 System.out.println(usuario.getCpf());
	    		
	    		 break;
	    	 }
	    	 else{
	    		 redirect = true;
	    		 //Locale  locale = new Locale();
	    		 //response.setLocale("http://localhost:8080/progressao/view/index.html");
	    		 System.out.println(request.getAttribute(""));
	    		 //request.getRequestDispatcher("/view/index.html").;
	    	 }
	     } */
	     System.out.println("final de um filtro");
	     if(user == null)
	    	 request.getRequestDispatcher("/view/index.html").forward(request,response);	
	     else
	    	 chain.doFilter(request, response);
	  }

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub
	
} 
}