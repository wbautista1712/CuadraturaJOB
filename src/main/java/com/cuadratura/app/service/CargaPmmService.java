package com.cuadratura.app.service;

import java.util.List;

import com.cuadratura.app.mysql.entity.CargaPmm;
import com.cuadratura.app.oracle.dto.FotoPmmDto;

public interface CargaPmmService  extends GenericService<CargaPmm, Integer> {
	public Long saveCargaPmm(CargaPmm cargaPmm);
	
	public List<FotoPmmDto> getAllFindFotoPmmExcel(Integer idCentroDistribucion, String fechaDesde, String fechaHasta);
	
	public List<FotoPmmDto> getAllFindFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta, Integer start, Integer end);
	
	public Integer countFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception;
	

}
