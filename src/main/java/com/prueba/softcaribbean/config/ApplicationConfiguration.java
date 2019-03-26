package com.prueba.softcaribbean.config;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.prueba.softcaribbean.util.JsonTransformer;
import com.prueba.softcaribbean.util.Mensaje;

@Configuration
@ComponentScan(basePackages = "com.prueba.softcaribbean")
public class ApplicationConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

		RestTemplate restTemplate = restTemplateBuilder.errorHandler(new ResponseErrorHandler() {

			@Override
			public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
				// TODO Auto-generated method stub

				HttpStatus status = clientHttpResponse.getStatusCode();
				return status == HttpStatus.NOT_FOUND || status == HttpStatus.BAD_REQUEST ;
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {

				String responseString = IOUtils.toString(response.getBody(), "UTF-8");

				Mensaje mensaje = JsonTransformer.fromJSON(responseString, Mensaje.class);

				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, mensaje.getMensaje(), "Error", JOptionPane.WARNING_MESSAGE);
				return;

			}
		}).build();

		return restTemplate;
	}

}