package com.cuadratura.app.mysql.repository;

import java.util.List;

import com.cuadratura.app.mysql.entity.CargaWms;

public interface CargaWmsRepositoryCustom {

	public Long saveCargaWms(CargaWms cargaWms);
	
	public List<Object[]> getAllFindFotoWms(String idCentroDistribucion, String fechaDesde, String fechaHasta , Integer start, Integer end);
	
	public Integer countFotoWms(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception;
	
	
	public List<Object[]> getExportFotoWms(Integer idCarga_WMS);

}
