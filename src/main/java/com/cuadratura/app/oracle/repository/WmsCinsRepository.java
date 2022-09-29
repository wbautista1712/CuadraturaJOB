package com.cuadratura.app.oracle.repository;

import java.util.List;

public interface WmsCinsRepository {
	List<Object[]> findAllWMSWmsCins(String fechaHora) throws Exception;
	
	public List<Object[]> getCDFotoWms();
	
	public List<Object[]> getFechaHoraFotoWms(String idCD);
	
	public List<Object[]> getCDXFechaHoraFotoWms();
	
	public List<Object[]> getNroCargaFotoWms(String idCD);
	
	List<Object[]> findAllxNroCargaWMSWmsCins(Integer nroCarga) throws Exception;
}
