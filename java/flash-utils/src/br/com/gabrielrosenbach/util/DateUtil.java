package br.com.gabrielrosenbach.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

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
		return calendar.getTime();
	}
}
