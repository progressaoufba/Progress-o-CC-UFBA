package br.com.progressao.controller;

import java.io.IOException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUser extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws  IOException{
		boolean isSession;
		isSession = SessionUser.isSessionUser(request,response);
		if(isSession == false){
			response.sendRedirect("view/index.html");		
		}
	}
	
	
	private static boolean isSessionUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		if(session != null){
			String usuarioAutenticado = (String) session.getAttribute("usuario_autenticado");
			//Long idUsuarioAutenticado = (Long) session.getAttribute("id_usuario_autenticado");
			if (usuarioAutenticado == null) 
				return false;
		}else
			return false;
		return true;
	}
		
	
}
