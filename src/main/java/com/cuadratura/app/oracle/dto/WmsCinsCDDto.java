package com.cuadratura.app.oracle.dto;

public class WmsCinsCDDto {
	private String idCD; 

	private Integer numRegistros ;	
	private String fechaHora ;
	private Integer nroCarga;
	public String getIdCD() {
		return idCD;
	}
	public void setIdCD(String idCD) {
		this.idCD = idCD;
	}
	public Integer getNumRegistros() {
		return numRegistros;
	}
	public void setNumRegistros(Integer numRegistros) {
		this.numRegistros = numRegistros;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Integer getNroCarga() {
		return nroCarga;
	}
	public void setNroCarga(Integer nroCarga) {
		this.nroCarga = nroCarga;
	}

	
}
