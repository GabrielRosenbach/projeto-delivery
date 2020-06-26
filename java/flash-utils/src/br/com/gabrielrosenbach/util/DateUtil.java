package br.com.gabrielrosenbach.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	public static final String FORMATO_DD_MM_YYYY = "dd/MM/yyyy";

	public static Integer getDia(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Integer getMes(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	public static Date criarData(Integer dia, Integer mes, Integer ano) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(ano, mes - 1, dia);
		calendar.setTimeZone(TimeZone.getDefault());
		return calendar.getTime();
	}
	
	public static String format(Date data, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(data);
	}
}
