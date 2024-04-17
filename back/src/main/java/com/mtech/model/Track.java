package com.mtech.model;

import java.util.ArrayList;

public class Track {

	private String codigo;
	private String host;
	private String time;
	private String quantidade;
	private ArrayList < Evento > eventos = new ArrayList < Evento > ();
	private String servico;
	private String ultimo;
	
	public Track() {}
	
	

	public Track(String codigo, String host, String time, String quantidade, ArrayList<Evento> eventos, String servico,
			String ultimo) {
		super();
		this.codigo = codigo;
		this.host = host;
		this.time = time;
		this.quantidade = quantidade;
		this.eventos = eventos;
		this.servico = servico;
		this.ultimo = ultimo;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getUltimo() {
		return ultimo;
	}

	public void setUltimo(String ultimo) {
		this.ultimo = ultimo;
	}
	

	
	
	
	
}
