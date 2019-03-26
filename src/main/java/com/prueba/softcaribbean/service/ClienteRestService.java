package com.prueba.softcaribbean.service;

import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.util.Mensaje;

public interface ClienteRestService {

	public Cliente buscarPorId(int id);

	public Mensaje crear(Object object);
	
	public Mensaje actualizar(Object object);


}
