package br.com.progressao.model;

public class User {
	
	
	private long cpf;
	private String nome;
	private String email;
	private String password;
	private boolean valido;
	
	public User(long cpf, String nome, String email, String password){
		this(cpf,password);
		this.nome = nome;
		this.email = email;
	}
	
	
	public User(long cpf,String password){
		this.cpf=cpf;
		this.password=password;
		this.valido=false;
	}
	
	public User(){
		this.valido=false;
	}
	
	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
}
