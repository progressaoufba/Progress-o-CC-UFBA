package br.com.progressao.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.progressao.jdbc.ConnectionFactory;
import br.com.progressao.model.User;

public class UserBDD {
	// a conexÃ£o com o banco de dados
	private Connection connection;
	
	public UserBDD() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(User usuario) {
	    String sql = "insert into usuario " +
	            "(cpf, nome, senha, email)" +
	            " values (?,?,?,?)";

	    try {
	        // prepared statement para inserção
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setLong(1,usuario.getCpf());
	        stmt.setString(2,usuario.getNome());
	        stmt.setString(3,usuario.getPassword());
	        stmt.setString(4,usuario.getEmail());

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<User> getLista() {
	     try {
	         List<User> usuarios = new ArrayList<User>();
	         PreparedStatement stmt = this.connection.
	                 prepareStatement("select * from usuario");
	         ResultSet rs = stmt.executeQuery();
	 
	         
	         while (rs.next()) {
	             // criando o objeto Contato
	             User usuario = new User();
	             usuario.setCpf(rs.getLong("cpf"));
	             usuario.setNome(rs.getString("nome"));
	             usuario.setEmail(rs.getString("email"));
	             usuario.setPassword(rs.getString("senha"));

	             // adicionando o objeto à lista
	             usuarios.add(usuario);
	         }
	         rs.close();
	         stmt.close();
	         return usuarios;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
}