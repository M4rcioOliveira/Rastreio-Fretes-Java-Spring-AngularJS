package com.mtech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mtech.model.Evento;
import com.mtech.model.Track;

@Service
public class EventoService {

	@Autowired
	private TrackService trackService;

	// Método responsável por pegar o status e montar o objeto evento que será
	// consumido no front;
	public List<Evento> getEventos(String code) throws JsonMappingException, JsonProcessingException, UnirestException {

		Track track = null;

		if (code.equalsIgnoreCase("CR123456789BR")) {
			track = trackService.getTrackByCodeExample(code);
		} else {
			track = trackService.getTrackByCode(code);
		}

		List<Evento> eventos = new ArrayList<>();

		for (Evento e : track.getEventos()) {

			e.setCode(code.toUpperCase());

			if (e.getStatus().toLowerCase().contains("postado")) {
				e.setImagem("https://uploaddeimagens.com.br/images/004/248/883/original/postado.png?1670034424");
			} else if (e.getStatus().toLowerCase().contains("encaminhado")) {
				e.setImagem("https://uploaddeimagens.com.br/images/004/248/882/original/acaminho.png?1670034365");
			} else if (e.getStatus().toLowerCase().contains("entregue")) {
				e.setImagem("https://uploaddeimagens.com.br/images/004/248/884/original/entregue.png?1670034454");
			} else if (e.getStatus().toLowerCase().contains("saiu para entrega")) {
				e.setImagem(
						"https://uploaddeimagens.com.br/images/004/248/877/original/saidaparaentrega.png?1670034298");
			}

			else if (e.getStatus().toLowerCase().contains("não efetuada")
					|| e.getStatus().toLowerCase().contains("ausente")) {
				e.setImagem("https://uploaddeimagens.com.br/images/004/248/872/original/nao-entregue.png?1670034155");
			}

			else if (e.getStatus().toLowerCase().contains("coletado")) {
				e.setImagem("https://uploaddeimagens.com.br/images/004/249/325/original/coletado.png?1670087343");
			}

			else {
				e.setImagem("https://uploaddeimagens.com.br/images/004/248/885/original/generico.png?1670034495");
			}

			eventos.add(e);

		}
		return eventos;

	}

}
