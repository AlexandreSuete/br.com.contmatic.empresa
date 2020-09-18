package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

public class SituacaoEspecial {
	
	public SituacaoEspecial() {}
	
	public SituacaoEspecial(String sitEspecial, String dataSitEspecial) {
		super();
		this.sitEspecial = sitEspecial;
		this.dataSitEspecial = dataSitEspecial;
	}

	private String sitEspecial;
	
	private String dataSitEspecial;
	
	public String getSitEspecial() {
		return sitEspecial;
	}

	public void setSitEspecial(String sitEspecial) {
		this.sitEspecial = sitEspecial;
	}

	public String getDataSitEspecial() {
		return dataSitEspecial;
	}

	public void setDataSitEspecial(int dia, int mes, int ano) {
		validarIntervalo(dia, mes, ano);
		String dataSitEspecial = dia + "/" + mes + "/" + ano;
		this.dataSitEspecial = dataSitEspecial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSitEspecial == null) ? 0 : dataSitEspecial.hashCode());
		result = prime * result + ((sitEspecial == null) ? 0 : sitEspecial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoEspecial other = (SituacaoEspecial) obj;
		if (dataSitEspecial == null) {
			if (other.dataSitEspecial != null)
				return false;
		} else if (!dataSitEspecial.equals(other.dataSitEspecial))
			return false;
		if (sitEspecial == null) {
			if (other.sitEspecial != null)
				return false;
		} else if (!sitEspecial.equals(other.sitEspecial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SituacaoEspecial [sitEspecial=" + sitEspecial + ", dataSitEspecial=" + dataSitEspecial + "]";
	}
	
}
