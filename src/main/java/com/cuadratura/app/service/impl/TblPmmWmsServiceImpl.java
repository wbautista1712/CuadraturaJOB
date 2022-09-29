package com.cuadratura.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.repository.TblPmmWmsRepository;
import com.cuadratura.app.oracle.dto.ConsolidadoPmmWmsDto;
import com.cuadratura.app.oracle.dto.ResultadoPmmWmsDto;
import com.cuadratura.app.service.TblPmmWmsService;

@Service
public class TblPmmWmsServiceImpl implements TblPmmWmsService {

	private static final Logger LOGGER = LogManager.getLogger(TblPmmWmsServiceImpl.class);

	@Autowired
	private TblPmmWmsRepository tblPmmWmsRepository;

	@Override
	public List<ConsolidadoPmmWmsDto> getAllConsolidadoPmmWms(Integer idCargaWms, Integer idCargaPmm, String idCD) {

		LOGGER.info("paso");
		return tblPmmWmsRepository.getAllConsolidadoPmmWms(idCargaWms, idCargaPmm, idCD);
	}

	@Override
	public List<ResultadoPmmWmsDto> getAllResultadoPmmWms(String idCD_org_name_short, String fechaDesde, String fechaHasta, Integer start, Integer end) {

		List<ResultadoPmmWmsDto> listaClasificadores = new ArrayList<ResultadoPmmWmsDto>();
		List<Object[]> lista = tblPmmWmsRepository.getAllResultadoPmmWms(idCD_org_name_short, fechaDesde, fechaHasta, start, end);
		LOGGER.info("get lista " + lista.size());
		ResultadoPmmWmsDto fotoWms;
		for (Object[] filaObj : lista) {
			fotoWms = new ResultadoPmmWmsDto();

			fotoWms.setIdcruce_Pmm_Wms(filaObj[0] == null ? 0 : (Integer) filaObj[0]);
			fotoWms.setFechamatch(filaObj[1] == null ? "" : filaObj[1].toString());
			fotoWms.setHoramatch(filaObj[2] == null ? "" : filaObj[2].toString());
			fotoWms.setUsuario(filaObj[3] == null ? "" : filaObj[3].toString());
			fotoWms.setFechafotopmm(filaObj[4] == null ? "" : filaObj[4].toString());
			fotoWms.setHorafotopmm(filaObj[5] == null ? "" : filaObj[5].toString());
			
			fotoWms.setFechafotowms(filaObj[6] == null ? "" : filaObj[6].toString());
			fotoWms.setHorafotowms(filaObj[7] == null ? "" : filaObj[7].toString());
			
			fotoWms.setIdcarga_Pmm(filaObj[8] == null ? 0 : (Integer) filaObj[8]);
			fotoWms.setIdcarga_Wms(filaObj[9] == null ? 0 : (Integer) filaObj[9]);
			fotoWms.setEstado(filaObj[10] == null ? "" : filaObj[10].toString());

			listaClasificadores.add(fotoWms);
		}
		return listaClasificadores;
	}

	@Override
	public void saveCrucePmmWms(int idCargaPMM, int idCargaWMS, String idCD, int idUsuario, int idCrucePmmWms) {
		this.tblPmmWmsRepository.saveCrucePmmWms(idCargaPMM, idCargaWMS, idCD, idUsuario, idCrucePmmWms);
	}

	@Override
	public Integer countResultadoPmmWms(String idCD_org_name_short, String fechaDesde, String fechaHasta) throws Exception {
		return this.tblPmmWmsRepository.countResultadoPmmWms(idCD_org_name_short, fechaDesde, fechaHasta);

	}
}
