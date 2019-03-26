package com.prueba.softcaribbean;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.util.Constantes;
import com.prueba.softcaribbean.util.JsonTransformer;
import com.prueba.softcaribbean.util.Mensaje;

public class ClienteRestTest {

	private static final String api = Constantes.URL + "/api/cliente";

	@Test
	public void crear() {

		Cliente cliente = new Cliente();
		cliente.setCliente("Joan");
		cliente.setNombre("Sebastian");
		cliente.setDireccion("Calle 39");
		cliente.setMail("setoba1192@gmail.com");
		cliente.setFechaRegistro(new Timestamp(new Date().getTime()));

		cliente.setUsuario("1234");
		cliente.setActivo("1");
		cliente.setTelefono("3112392124");
		cliente.setContacto("Prueba");
		cliente.setLogo("Logo");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ResponseErrorHandler() {

			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				// TODO Auto-generated method stub
				HttpStatus status = response.getStatusCode();
				return status == HttpStatus.NOT_FOUND || status == HttpStatus.BAD_REQUEST;
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				// TODO Auto-generated method stub
				String responseString = IOUtils.toString(response.getBody(), "UTF-8");

				Mensaje mensaje = JsonTransformer.fromJSON(responseString, Mensaje.class);
				System.out.println(mensaje);

			}
		});

		Mensaje mensaje = restTemplate.postForObject(api, cliente, Mensaje.class);

		System.out.println(mensaje);
		assertNotNull(mensaje);
	}

	@Test
	public void actualizar() {

		Cliente cliente = new Cliente();
		cliente.setCliente("Joan");
		cliente.setNombre("Sebastian");
		cliente.setDireccion("Calle 39");
		cliente.setMail("setoba1192@gmail.com");
		cliente.setFechaBaja(new Timestamp(new Date().getTime()));

		cliente.setUsuario("1234");
		cliente.setActivo("1");
		cliente.setTelefono("3112392124");
		cliente.setContacto("Prueba");
		cliente.setLogo("Logo");

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Cliente> requestEntity = new HttpEntity<Cliente>(cliente, null);

		ResponseEntity<String> mensaje = restTemplate.exchange(api, HttpMethod.PUT, requestEntity, String.class);

		JsonTransformer.fromJSON(mensaje.getBody().toString(), Mensaje.class);

		assertNotNull(mensaje);
	}

}
