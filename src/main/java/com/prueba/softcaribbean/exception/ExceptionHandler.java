package com.prueba.softcaribbean.exception;

import java.awt.AWTEvent;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class ExceptionHandler extends EventQueue {

	private static final Logger logger = Logger.getLogger(ExceptionHandler.class);

	protected void dispatchEvent(AWTEvent newEvent) {

		try {
			super.dispatchEvent(newEvent);
		} catch (Throwable t) {
			t.printStackTrace();
			String message = t.getMessage();

			System.out.println("Clase: " + t.getClass().getName());
			if (message == null || message.length() == 0) {
				message = "Fatal: " + t.getClass();
			}

			if (t instanceof ObjetoNoEncontradoException) {

				ObjetoNoEncontradoException exception = (ObjetoNoEncontradoException) t;
				logger.warn(exception.getMessage());
				JOptionPane.showMessageDialog(exception.getContainer(), exception.getMessage(), "Información",
						JOptionPane.WARNING_MESSAGE);

			} else

			if (t instanceof ValidacionDominioException) {

				ValidacionDominioException exception = (ValidacionDominioException) t;
				logger.warn(exception.getMessage());
				JOptionPane.showMessageDialog(exception.getContainer(), exception.getMessage(), "Información",
						JOptionPane.WARNING_MESSAGE);

			} else {

				logger.fatal(message);
				JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.ERROR_MESSAGE);

			}
		}
	}
}