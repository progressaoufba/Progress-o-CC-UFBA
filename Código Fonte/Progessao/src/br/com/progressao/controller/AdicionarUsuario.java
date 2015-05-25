package br.com.progressao.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.progressao.model.User;

@WebServlet("/view/adicionar_processo")
public class AdicionarUsuario extends HttpServlet {
	//private String local_arquivo = "C:\\Users\\lukas_000\\Documents\\Workspace\\progressao\\WebContent\\arquivos_anexos\\";
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		//HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("User");
		response.sendRedirect("../view/adicionar_processo.jsp");
	}

	public void colocarBDD(User user) {
		User usuario = new User(user.getCpf(), user.getNome(),user.getEmail(),user.getPassword() );
		UserBDD usuariobd = new UserBDD();
		usuariobd.adiciona(usuario);
	}

	public String dadosFormulario(HttpServletRequest req,
			HttpServletResponse resp, String nomefile, User user,
			Calendar calendar) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		boolean colocarBanco = false;
		if (isMultipart) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = (List<FileItem>) upload
						.parseRequest(req);
				for (FileItem item : items) {
				}
				if (colocarBanco) {
					colocarBDD(user);
					System.out.println("Dados USUARIO");
					UserBDD userBanco = new UserBDD();
					List<User> usuarios = userBanco.getLista();	
					User user1 = new User();
					for (User usuario : usuarios ) {
						if(usuario.getCpf() == user.getCpf() ){
						user1.setNome(usuario.getNome());
						user1.setEmail(usuario.getEmail());						
						}						
					}
							
							
					System.out.println(user1.getNome() + "\n" + user1.getCpf() + "\n");
				}
					

			} catch (Exception e) {
				System.out.println(
						"ocorreu um problema ao fazer o upload: "
								+ e.getMessage());
			}

			
			
		}
		return "Sim";
	}

}