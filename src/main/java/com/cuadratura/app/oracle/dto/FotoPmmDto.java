package com.cuadratura.app.oracle.dto;

public class FotoPmmDto {

	public Integer idCarga_Pmm;

	public String fecha_Foto;

	public String hora_Foto;

	public String fecha_Carga;

	public String hora_Carga;

	public Integer registros;

	public String usuario;

	public String nombre_Archivo;

	public String estado;

	public Integer getIdCarga_Pmm() {
		return idCarga_Pmm;
	}

	public void setIdCarga_Pmm(Integer idCarga_Pmm) {
		this.idCarga_Pmm = idCarga_Pmm;
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

	public String getNombre_Archivo() {
		return nombre_Archivo;
	}

	public void setNombre_Archivo(String nombre_Archivo) {
		this.nombre_Archivo = nombre_Archivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
