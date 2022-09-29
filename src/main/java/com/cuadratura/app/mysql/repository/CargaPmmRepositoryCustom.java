package com.cuadratura.app.mysql.repository;

import java.util.List;

import com.cuadratura.app.mysql.entity.CargaPmm;

public interface CargaPmmRepositoryCustom {
	public Long saveCargaPmm(CargaPmm cargaPmm);

	public List<Object[]> getAllFindFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta, Integer start, Integer end);
	
	public Integer countFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception;
	
	public List<Object[]> getExportFotoPmm(Integer idCentroDistribucion, String fechaDesde, String fechaHasta);
	
}
