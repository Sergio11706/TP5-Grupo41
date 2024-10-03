package ar.edu.unju.escmi.tp5.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {
	public static LocalDate convertirStringLocalDate(String fechaStr) throws DateTimeParseException {
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return LocalDate.parse(fechaStr,formatoFecha);
		
	}
}
