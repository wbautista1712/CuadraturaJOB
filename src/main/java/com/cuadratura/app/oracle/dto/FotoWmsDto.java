package com.cuadratura.app.oracle.dto;

public class FotoWmsDto {

	public Integer idCD;//org_lvl_child
	public Integer idCarga_Wms;

	public String fecha_Foto;
	public String hora_Foto;
	public String fecha_Carga;
	public String hora_Carga;
	public Integer registros;
	public String usuario;
	public String estado;
	public int nroCarga;
	
	public int getNroCarga() {
		return nroCarga;
	}
	public void setNroCarga(int nroCarga) {
		this.nroCarga = nroCarga;
	}
	public Integer getIdCD() {
		return idCD;
	}
	public void setIdCD(Integer idCD) {
		this.idCD = idCD;
	}
	public Integer getIdCarga_Wms() {
		return idCarga_Wms;
	}
	public void setIdCarga_Wms(Integer idCarga_Wms) {
		this.idCarga_Wms = idCarga_Wms;
	}
	public String getFecha_Foto() {
		return fecha_Foto;
	}
	public void setFecha_Foto(String fecha_Foto) {
		this.fecha_Foto = fecha_Foto;
	}
	public String getHora_Foto() {
		return hora_Foto;
	}
	public void setHora_Foto(String hora_Foto) {
		this.hora_Foto = hora_Foto;
	}
	public String getFecha_Carga() {
		return fecha_Carga;
	}
	public void setFecha_Carga(String fecha_Carga) {
		this.fecha_Carga = fecha_Carga;
	}
	public String getHora_Carga() {
		return hora_Carga;
	}
	public void setHora_Carga(String hora_Carga) {
		this.hora_Carga = hora_Carga;
	}
	public Integer getRegistros() {
		return registros;
	}
	public void setRegistros(Integer registros) {
		this.registros = registros;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
