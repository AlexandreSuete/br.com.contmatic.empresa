package br.com.contmatic.empresa.util;

import static br.com.contmatic.empresa.util.Constantes.DAY_MAX;
import static br.com.contmatic.empresa.util.Constantes.MONTH_MAX;
import static br.com.contmatic.empresa.util.Constantes.YEAR_MAX;
import static br.com.contmatic.empresa.util.Constantes.YEAR_MIN;

public final class Datas {
	
	private Datas() {};
	
	public static void validarIntervalo(int dia, int mes, int ano) {
		if (dia > DAY_MAX || mes > MONTH_MAX || ano > YEAR_MAX || ano < YEAR_MIN) {
			throw new IllegalStateException("A data de informada deve ser valida");
		}
	}

}
