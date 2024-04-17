package com.mtech.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mtech.model.Track;

@Service
public class TrackService {

	private static final String TRACK_RESULT_EXAMPLE = "{\"codigo\":\"CR123456789BR\",\"servico\":\"Sedex\",\"host\":\"teste\",\"quantidade\":6,\"eventos\":[{\"data\":\"18/10/2022\",\"hora\":\"16:33\",\"local\":\"FARROUPILHA/RS\",\"status\":\"Objeto entregue ao destinatário\",\"subStatus\":[]},{\"data\":\"18/10/2022\",\"hora\":\"08:47\",\"local\":\"FARROUPILHA/RS\",\"status\":\"Objeto saiu para entrega ao destinatário\",\"subStatus\":[]},{\"data\":\"17/10/2022\",\"hora\":\"11:06\",\"local\":\"CAXIAS DO SUL/RS\",\"status\":\"Objeto encaminhado\",\"subStatus\":[\"Origem: Unidade de Tratamento - CAXIAS DO SUL/RS\",\"Destino: Unidade de Distribuição - FARROUPILHA/RS\"]},{\"data\":\"14/10/2022\",\"hora\":\"06:43\",\"local\":\"VALINHOS/SP\",\"status\":\"Objeto encaminhado\",\"subStatus\":[\"Origem: Unidade de Tratamento - VALINHOS/SP\",\"Destino: Unidade de Tratamento - CAXIAS DO SUL/RS\"]},{\"data\":\"13/10/2022\",\"hora\":\"15:25\",\"local\":\"FRANCA/SP\",\"status\":\"Objeto encaminhado\",\"subStatus\":[\"Origem: Agência dos Correios - FRANCA/SP\",\"Destino: Unidade de Tratamento - RIBEIRAO PRETO/SP\"]},{\"data\":\"13/10/2022\",\"hora\":\"09:24\",\"local\":\"FRANCA/SP\",\"status\":\"Objeto postado\",\"subStatus\":[]}],\"time\":1.463,\"ultimo\":\"2022-12-04T23:33:00.000Z\"}";

	private static final String USER = "";

	private static final String TOKEN = "";

	public Track getTrackByCode(String code) throws UnirestException, JsonMappingException, JsonProcessingException {

		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.get("https://api.linketrack.com/track/json?user=" + USER + "&token=" + TOKEN + "&codigo=" + code)
				.asString();

		ObjectMapper objectMapper = new ObjectMapper();

		Track track = objectMapper.readValue(response.getBody(), Track.class);

		return track;

	}

	public Track getTrackByCodeExample(String code)
			throws UnirestException, JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		Track track = objectMapper.readValue(TRACK_RESULT_EXAMPLE, Track.class);

		return track;

	}

}
