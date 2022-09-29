package com.cuadratura.app.mysql.repository;

import java.sql.SQLException;
import java.util.Map;

import com.cuadratura.app.mysql.entity.CrucePmmWms;


public interface CrucePmmWmsRepositoryCustom {
	public Long saveCrucePmmWms(CrucePmmWms crucePmmWms);
	
	public Map<String, Object> listarAjusteBolsaDiscrepancia(Integer idCrucePmmWms, String idCDOrgNameShort);
	
	public  Map<String, Object>  listAnalisisAjustePmmWms(int idCrucePmmWms, String idCDOrgNameShort);
	
	public void spActualizarEstadoWMSPMMTotal(int pidCrucePmmWms , int idEstado )  throws SQLException;

}
