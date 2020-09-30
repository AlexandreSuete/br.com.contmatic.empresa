package br.com.contmatic.empresa.util;

import java.util.Calendar;
import java.util.Date;

public final class Datas {
	
	static Calendar c = Calendar.getInstance();
	
	public static void validarIntervalo(Date data) {
		Date hoje = new Date();
		if (data.getTime() > hoje.getTime()) {
			throw new IllegalStateException("A data de informada não deve ser futura");
		}
	}
	
	public static Date definirData(int year, int month, int date) {
		Date data;
		c.set(year, month, date);
		data = c.getTime();
		return data;
	}

}
