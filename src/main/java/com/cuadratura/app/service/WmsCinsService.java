package com.cuadratura.app.service;

import java.util.List;

import com.cuadratura.app.oracle.dto.WmsCinsCDDto;
import com.cuadratura.app.oracle.dto.WmsCinsDto;

public interface WmsCinsService {

	List<WmsCinsDto> findAllWMSWmsCins(String fechaHora) throws Exception;

	public List<WmsCinsCDDto> getCDFotoWms();

	public List<WmsCinsCDDto> getFechaHoraFotoWms(String idCD);

	public List<WmsCinsCDDto> getCDXFechaHoraFotoWms();

	public List<WmsCinsCDDto> getNroCargaFotoWms(String idCD);
	
	List<WmsCinsDto> findAllxNroCargaWMSWmsCins(Integer nroCarga) throws Exception;
}
