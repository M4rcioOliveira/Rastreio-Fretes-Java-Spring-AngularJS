package com.mtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mtech.model.Evento;
import com.mtech.service.EventoService;

@RestController
@CrossOrigin(origins = "*")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@GetMapping("/track/evento/{code}")
	public ResponseEntity<List<Evento>> getTrackByCode(@PathVariable String code)
			throws JsonMappingException, JsonProcessingException, UnirestException {

		List<Evento> evento = eventoService.getEventos(code);

		return evento != null ? ResponseEntity.ok().body(evento) : ResponseEntity.notFound().build();

	}

}
