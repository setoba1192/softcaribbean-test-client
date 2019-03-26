package com.prueba.softcaribbean.util;

import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.prueba.softcaribbean.exception.ValidacionDominioException;

public class Utils {

	public static boolean emptyString(final String s) {

		return s == null || s.trim().isEmpty();
	}

	public static void validateEmptyStringAndLength(final String s, int length, String field, Container container) {

		if (s == null || s.trim().isEmpty()) {

			throw new ValidacionDominioException("Complete el campo " + field, container);
		}
		if (s.length() > length) {

			throw new ValidacionDominioException(
					"El campo " + field + " supera el máximo de carácteres permitidos: " + length, container);

		}

	}

	public static boolean validateDateFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {

		}
		return date != null;
	}

}
