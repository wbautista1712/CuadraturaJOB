package com.cuadratura.app.service;

import java.sql.SQLException;
import java.util.List;

import com.cuadratura.app.mysql.entity.CrucePmmWms;
import com.cuadratura.app.oracle.dto.AjustePmmWmsDto;
import com.cuadratura.app.oracle.dto.CrucePmmWmsDto;


public interface CrucePmmWmsService {
	public Long saveCrucePmmWms(CrucePmmWms crucePmmWms);
	public List<CrucePmmWmsDto> listarAjusteBolsaDiscrepancia(Integer idCrucePmmWms);
	
	public List<AjustePmmWmsDto> listAnalisisAjustePmmWms(int idCrucePmmWms);
	
	public void spActualizarEstadoWMSPMMTotal(int pidCrucePmmWms , int idEstado ) throws SQLException ;
}
