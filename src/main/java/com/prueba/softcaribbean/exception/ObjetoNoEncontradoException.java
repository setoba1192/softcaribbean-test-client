package com.prueba.softcaribbean.exception;

import java.awt.Container;

public class ObjetoNoEncontradoException extends RuntimeException {

	private Container container;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4140091136626098777L;

	public ObjetoNoEncontradoException(String message, Container container) {
		super(message);

		this.container = container;

	}

	public ObjetoNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

}
