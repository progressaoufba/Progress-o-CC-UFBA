package br.com.progressao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws  IOException {
		PrintWriter out = response.getWriter();

		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Primeira servlet de Lucas");
		out.println("</body>");
		out.println("</html>");
	}
}
