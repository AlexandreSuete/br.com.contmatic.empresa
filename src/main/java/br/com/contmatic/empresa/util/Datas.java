package br.com.contmatic.empresa.util;


import java.util.Date;

public final class Datas {
	private Datas() {}

	public static void validarIntervalo(Date data) {
		Date hoje = new Date();
		if (data.getTime() > hoje.getTime()) {
			throw new IllegalStateException("A data de informada não deve ser futura");
		}
	}
}
