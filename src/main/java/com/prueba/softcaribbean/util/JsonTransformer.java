package com.prueba.softcaribbean.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by JACS1 on 18/11/2016.
 */

public class JsonTransformer {

	public static String toJson(Object data) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			return objectMapper.writeValueAsString(data);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static <T> List<T> fromJsonArray(String json, Class<T> clazz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			return objectMapper.readValue(json,
					objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

	}

	public static <T> T fromJSON(String json, Class<T> clazz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			return objectMapper.readValue(json, clazz);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

	}
}
