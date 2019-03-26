package com.prueba.softcaribbean.exception;

import java.awt.Container;

public class ValidacionDominioException extends RuntimeException {

	private Container container;
	/**
	 * 
	 */
	private static final long serialVersionUID = -6659405421519686252L;

	public ValidacionDominioException(String message, Container container) {
		super(message);
		this.container = container;

	}

	public ValidacionDominioException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}
}
