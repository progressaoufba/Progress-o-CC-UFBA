package br.com.progressao.model;

import java.util.List;
import java.lang.*;

public class ListaUser {

	private List<User> listaDeProcessosUser;
	private String listagemFalsa;

	public ListaUser() {

	}

	public String getListagemFalsa() {
		return listagemFalsa;
	}

	public void setListagemFalsa(String listagemfalsa) {
		this.listagemFalsa = listagemfalsa;
	}

	public List<User> getListaDeProcessosUser() {
		return listaDeProcessosUser;
	}

	public void setListaDeProcessosUser(List<User> l) {
		listaDeProcessosUser = l;
	}
	
}
