package com.cuadratura.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.entity.CargaWms;
import com.cuadratura.app.mysql.repository.CargaWmsRepository;
import com.cuadratura.app.oracle.dto.FotoWmsDto;
import com.cuadratura.app.service.CargaWmsService;

@Service
public class CargaWmsServiceImpl extends GenericServiceImpl<CargaWms, Integer> implements CargaWmsService {
	private static final Logger LOGGER = LogManager.getLogger(CargaWmsServiceImpl.class);

	@Autowired
	private CargaWmsRepository cargaWmsRepository;

	@Override
	public CrudRepository<CargaWms, Integer> getDao() {
		// TODO Auto-generated method stub
		return cargaWmsRepository;
	}

	public Long saveCargaWms(CargaWms cargaWms) {
		LOGGER.info("insert");
		return cargaWmsRepository.saveCargaWms(cargaWms);
	}

	public List<FotoWmsDto> getAllFindFotoWms(String idCentroDistribucion, String fechaDesde, String fechaHasta,
			Integer start, Integer end) {
		LOGGER.info("get getAllFindFotoWms");
		// return cargaWmsRepository.getAllFindFotoWms(idCentroDistribucion, fechaDesde,
		// fechaHasta, start, end);
		LOGGER.info("get start " + start);
		LOGGER.info("get end " + end);
		List<FotoWmsDto> listaClasificadores = new ArrayList<FotoWmsDto>();

		List<Object[]> lista = cargaWmsRepository.getAllFindFotoWms(idCentroDistribucion, fechaDesde, fechaHasta, start,
				end);
		LOGGER.info("get lista " + lista.size());
		FotoWmsDto fotoWms;
		for (Object[] filaObj : lista) {
			fotoWms = new FotoWmsDto();

			fotoWms.setIdCD(filaObj[0] == null ? 0 : (Integer) filaObj[0]);
			fotoWms.setIdCarga_Wms(filaObj[1] == null ? 0 : (Integer) filaObj[1]);
			fotoWms.setFecha_Foto(filaObj[2] == null ? "" : filaObj[2].toString());
			fotoWms.setHora_Foto(filaObj[3] == null ? "" : filaObj[3].toString());
			fotoWms.setFecha_Carga(filaObj[4] == null ? "" : filaObj[4].toString());
			fotoWms.setHora_Carga(filaObj[5] == null ? "" : filaObj[5].toString());
			fotoWms.setRegistros(filaObj[6] == null ? 0 : (Integer) filaObj[6]);
			fotoWms.setUsuario(filaObj[7] == null ? "" : filaObj[7].toString());
			fotoWms.setEstado(filaObj[8] == null ? "" : filaObj[8].toString());
			fotoWms.setNroCarga(filaObj[9] == null ? null : Integer.parseInt(filaObj[9].toString()));

			listaClasificadores.add(fotoWms);
		}
		return listaClasificadores;
	}

	public List<FotoWmsDto> getAllFindFotoWmsExcel(Integer idCarga_WMS) {
		
		List<FotoWmsDto> listaClasificadores = new ArrayList<FotoWmsDto>();
		FotoWmsDto fotoWms;
		List<Object[]> lista = cargaWmsRepository.getExportFotoWms(idCarga_WMS);
		for (Object[] filaObj : lista) {
			fotoWms = new FotoWmsDto();

			fotoWms.setIdCD(filaObj[0] == null ? 0 : (Integer) filaObj[0]);
			fotoWms.setIdCarga_Wms(filaObj[1] == null ? 0 : (Integer) filaObj[1]);
			fotoWms.setFecha_Foto(filaObj[2] == null ? "" : filaObj[2].toString());
			fotoWms.setHora_Foto(filaObj[3] == null ? "" : filaObj[3].toString());
			fotoWms.setFecha_Carga(filaObj[4] == null ? "" : filaObj[4].toString());
			fotoWms.setHora_Carga(filaObj[5] == null ? "" : filaObj[5].toString());
			fotoWms.setRegistros(filaObj[6] == null ? 0 : (Integer) filaObj[6]);
			fotoWms.setUsuario(filaObj[7] == null ? "" : filaObj[7].toString());
			fotoWms.setEstado(filaObj[8] == null ? "" : filaObj[8].toString());

			listaClasificadores.add(fotoWms);
		}
		return listaClasificadores;
	}

	public Integer countFotoWms(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception {
		return cargaWmsRepository.countFotoWms(idCentroDistribucion, fechaDesde, fechaHasta);
	}
}
