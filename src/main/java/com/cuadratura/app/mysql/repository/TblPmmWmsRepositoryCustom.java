package com.cuadratura.app.mysql.repository;

import java.util.List;

public interface TblPmmWmsRepositoryCustom {
	public void saveCrucePmmWms(int idCargaPMM, int idCargaWMS, String idCD, int idUsuario, int idCrucePmmWms);
	
	List<Object[]> getAllResultadoPmmWms( String idCD_org_name_short, String fechaDesde, String fechaHasta, Integer start, Integer end);
	
	public Integer countResultadoPmmWms(String idCD_org_name_short, String fechaDesde, String fechaHasta) throws Exception;
}
