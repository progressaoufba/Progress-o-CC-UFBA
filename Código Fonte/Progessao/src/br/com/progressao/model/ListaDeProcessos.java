package br.com.progressao.model;

import java.util.List;
import java.lang.*;

public class ListaDeProcessos {

	private List<Processo> listaDeProcessosUser;
	private String listagemFalsa;

	public ListaDeProcessos() {

	}

	public String getListagemFalsa() {
		return listagemFalsa;
	}

	public void setListagemFalsa(String listagemfalsa) {
		this.listagemFalsa = listagemfalsa;
	}

	public List<Processo> getListaDeProcessosUser() {
		return listaDeProcessosUser;
	}

	public void setListaDeProcessosUser(List<Processo> l) {
		listaDeProcessosUser = l;
	}
	
}
