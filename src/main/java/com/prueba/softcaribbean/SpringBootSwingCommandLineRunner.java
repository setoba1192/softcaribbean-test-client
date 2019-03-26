package com.prueba.softcaribbean;

import java.awt.EventQueue;
import java.awt.Toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba.softcaribbean.exception.ExceptionHandler;
import com.prueba.softcaribbean.ui.ClienteFrame;

/**
 * This CommandLineRunner fires off at runtime and boots up our GUI.
 */
@Component
public class SpringBootSwingCommandLineRunner implements CommandLineRunner {
	private final ClienteFrame controller;

	@Autowired
	public SpringBootSwingCommandLineRunner(ClienteFrame controller) {
		this.controller = controller;
	}

	public void run(String... args) {
		// This boots up the GUI.
		EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		queue.push(new ExceptionHandler());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				controller.setVisible(true);
			}
		});
	}
}