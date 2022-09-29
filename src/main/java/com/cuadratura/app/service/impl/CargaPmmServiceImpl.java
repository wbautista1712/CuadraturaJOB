package com.cuadratura.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.entity.CargaPmm;
import com.cuadratura.app.mysql.repository.CargaPmmRepository;
import com.cuadratura.app.oracle.dto.FotoPmmDto;
import com.cuadratura.app.service.CargaPmmService;

@Service
public class CargaPmmServiceImpl extends GenericServiceImpl<CargaPmm, Integer> implements CargaPmmService {

	private static final Logger LOGGER = LogManager.getLogger(CargaPmmServiceImpl.class);

	@Autowired
	private CargaPmmRepository cargaPmmRepository;

	@Override
	public CrudRepository<CargaPmm, Integer> getDao() {
		return cargaPmmRepository;
	}

	@Override
	public Long saveCargaPmm(CargaPmm cargaPmm) {
		LOGGER.info("insert saveCargaPmm");
		return cargaPmmRepository.saveCargaPmm(cargaPmm);
	}

	@Override
	public List<FotoPmmDto> getAllFindFotoPmmExcel(Integer idCentroDistribucion, String fechaDesde, String fechaHasta) {
		LOGGER.info("get getAllFindFotoPmm");
		List<FotoPmmDto> listaClasificadores = new ArrayList<FotoPmmDto>();
		List<Object[]> lista = cargaPmmRepository.getExportFotoPmm(idCentroDistribucion, fechaDesde, fechaHasta);
		FotoPmmDto fotoWms;
		for (Object[] filaObj : lista) {
			fotoWms = new FotoPmmDto();

			fotoWms.setIdCarga_Pmm(filaObj[0] == null ? 0 : (Integer) filaObj[0]);
			fotoWms.setFecha_Foto(filaObj[1] == null ? "" : filaObj[1].toString());
			fotoWms.setHora_Foto(filaObj[2] == null ? "" : filaObj[2].toString());
			fotoWms.setFecha_Carga(filaObj[3] == null ? "" : filaObj[3].toString());
			fotoWms.setHora_Carga(filaObj[4] == null ? "" : filaObj[4].toString());
			fotoWms.setRegistros(filaObj[5] == null ? 0 : (Integer) filaObj[5]);
			fotoWms.setUsuario(filaObj[6] == null ? "" : filaObj[6].toString());
			fotoWms.setNombre_Archivo(filaObj[7] == null ? "" : filaObj[7].toString());
			fotoWms.setEstado(filaObj[8] == null ? "" : filaObj[8].toString());

			listaClasificadores.add(fotoWms);

		}
		return listaClasificadores;
	}

	@Override
	public List<FotoPmmDto> getAllFindFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta,
			Integer start, Integer end) {
		List<FotoPmmDto> listaClasificadores = new ArrayList<FotoPmmDto>();
		List<Object[]> lista = cargaPmmRepository.getAllFindFotoPmm(idCentroDistribucion, fechaDesde, fechaHasta, start,
				end);
		LOGGER.info("get lista " + lista.size());
		FotoPmmDto fotoWms;
		for (Object[] filaObj : lista) {
			fotoWms = new FotoPmmDto();

			fotoWms.setIdCarga_Pmm(filaObj[0] == null ? 0 : (Integer) filaObj[0]);
			fotoWms.setFecha_Foto(filaObj[1] == null ? "" : filaObj[1].toString());
			fotoWms.setHora_Foto(filaObj[2] == null ? "" : filaObj[2].toString());
			fotoWms.setFecha_Carga(filaObj[3] == null ? "" : filaObj[3].toString());
			fotoWms.setHora_Carga(filaObj[4] == null ? "" : filaObj[4].toString());
			fotoWms.setRegistros(filaObj[5] == null ? 0 : (Integer) filaObj[5]);
			fotoWms.setUsuario(filaObj[6] == null ? "" : filaObj[6].toString());
			fotoWms.setNombre_Archivo(filaObj[7] == null ? "" : filaObj[7].toString());
			fotoWms.setEstado(filaObj[8] == null ? "" : filaObj[8].toString());

			listaClasificadores.add(fotoWms);

		}
		return listaClasificadores;
	}

	@Override
	public Integer countFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception {
		return cargaPmmRepository.countFotoPmm(idCentroDistribucion, fechaDesde, fechaHasta);
	}

	
}
