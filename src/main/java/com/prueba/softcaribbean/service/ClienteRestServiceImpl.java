package com.prueba.softcaribbean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.util.Constantes;
import com.prueba.softcaribbean.util.JsonTransformer;
import com.prueba.softcaribbean.util.Mensaje;

@Component
public class ClienteRestServiceImpl implements ClienteRestService {

	private static final String api = Constantes.URL + "/api/cliente/";

	@Autowired
	private RestTemplate restTemplate;

	public Cliente buscarPorId(int id) {
		return this.restTemplate.getForObject(api + "/{id}", Cliente.class, id);
	}

	@Override
	public Mensaje crear(Object object) {
		// TODO Auto-generated method stub

		return this.restTemplate.postForObject(api, (Cliente) object, Mensaje.class);

	}

	@Override
	public Mensaje actualizar(Object object) {
		// TODO Auto-generated method stub
		HttpEntity<Cliente> requestEntity = new HttpEntity<Cliente>((Cliente) object, null);

		ResponseEntity<String> mensaje = restTemplate.exchange(api, HttpMethod.PUT, requestEntity, String.class);

		return JsonTransformer.fromJSON(mensaje.getBody().toString(), Mensaje.class);

	}

}
