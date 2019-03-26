package com.prueba.softcaribbean;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	static Logger logger = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {

		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warn message");
		logger.fatal("This is fatal message");
		logger.error("This is error message");

		new SpringApplicationBuilder(Application.class).headless(false).web(false).run(args);
	}

}