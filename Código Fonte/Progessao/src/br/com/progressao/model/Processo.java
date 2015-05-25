package br.com.progressao.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.ArrayList; 

public class Processo implements Serializable {
	private int id_opcao;
	private String extra;
	private String arquivo;
	private long id;
	private String exclarecimentos;
	private long cpf;
	private Calendar dataAtual;	

	public Processo(){
		
	}
	
	public Processo(int opcao,String arquivo,String exclarecimentos,long cpf, Calendar dataAtual){
		this.id_opcao = opcao;
		this.extra = " ";
		this.arquivo = arquivo;
		this.exclarecimentos = exclarecimentos;
		this.cpf = cpf;
		this.dataAtual = dataAtual;
		this.id = 0;
	}
	
	public Processo(int opcao,String extra,String arquivo,String exclarecimentos,long cpf, Calendar dataAtual){
		this.id_opcao = opcao;
		this.extra = extra;
		this.arquivo = arquivo;
		this.exclarecimentos = exclarecimentos;
		this.cpf = cpf;
		this.dataAtual = dataAtual;
		this.id = 0;
	}	
	
	public int getId_opcao() {
		return id_opcao;
	}


	public void setId_opcao(int id_opcao) {
		this.id_opcao = id_opcao;
	}


	public String getExtra() {
		return extra;
	}


	public void setExtra(String extra) {
		this.extra = extra;
	}


	public String getArquivo() {
		return arquivo;
	}


	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEsclarecimentos() {
		return exclarecimentos;
	}


	public void setEsclarecimentos(String esclarecimentos) {
		this.exclarecimentos = esclarecimentos;
	}


	public long getCpf() {
		return cpf;
	}


	public void setCpf(long cpf) {
		this.cpf = cpf;
	}


	public Calendar getDataAtual() {
		return this.dataAtual;
	}


	public void setDataAtual(Calendar dataAtual) {
		this.dataAtual = dataAtual;
	}
}
