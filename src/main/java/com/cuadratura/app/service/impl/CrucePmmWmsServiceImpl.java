package com.cuadratura.app.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.entity.CrucePmmWms;
import com.cuadratura.app.mysql.repository.CargaWmsRepository;
import com.cuadratura.app.mysql.repository.CrucePmmWmsRepository;
import com.cuadratura.app.mysql.repository.MTipoInventarioRepository;
import com.cuadratura.app.oracle.dto.AjustePmmWmsDto;
import com.cuadratura.app.oracle.dto.CrucePmmWmsDto;
import com.cuadratura.app.service.CrucePmmWmsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class CrucePmmWmsServiceImpl extends GenericServiceImpl<CrucePmmWms, Integer> implements CrucePmmWmsService {

	private static final Logger LOGGER = LogManager.getLogger(CrucePmmWmsServiceImpl.class);

	@Autowired
	private CrucePmmWmsRepository crucePmmWmsRepository;

	@Autowired
	private CargaWmsRepository cargaWmsRepository;
	
	@Autowired
	private MTipoInventarioRepository mTipoInventarioRepository;

	@Override
	public CrudRepository<CrucePmmWms, Integer> getDao() {
		return crucePmmWmsRepository;
	}

	public Long saveCrucePmmWms(CrucePmmWms cargaPmm) {
		LOGGER.info("insert saveCrucePmmWms");
		return crucePmmWmsRepository.saveCrucePmmWms(cargaPmm);
	}

	@Override
	public List<CrucePmmWmsDto> listarAjusteBolsaDiscrepancia(Integer idCrucePmmWms) {
		// TODO Auto-generated method stub
		LOGGER.info("idCrucePmmWms: " + idCrucePmmWms);
		
	    String idCDOrgNameShort = cargaWmsRepository.getCDCrucePmmWms(idCrucePmmWms);
		
	    // LOGGER.info("...:::listarAjusteBolsaDiscrepancia:::..."+idCDOrgNameShort);
		
		Map<String, Object> mapList = crucePmmWmsRepository.listarAjusteBolsaDiscrepancia(idCrucePmmWms,idCDOrgNameShort);

		List<CrucePmmWmsDto> list = new ArrayList<CrucePmmWmsDto>();
		
		CrucePmmWmsDto crucePmmWmsDto = null;

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		
		/*
		LOGGER.info("\nPretty toString ==> " + mapList.toString());
		LOGGER.info("\nPretty toString ==> " + mapList.get("#result-set-1"));
		*/
		
		String prettyJson = prettyGson.toJson(mapList.get("#result-set-1"));

		LOGGER.info("\nPretty JSONObject ==> " + prettyJson);
		LOGGER.info("mapList mapList ==> " + mapList.size());

	
		try {
			
			JSONArray jsonarr = new JSONArray(prettyJson);// prettyJson.getJSONArray("#result-set-1");
			LOGGER.info("tamaño ==> " + jsonarr.length());
			
			
	
			
			// list = jsonarr.toList().stream().map(CrucePmmWmsDto.class::cast).collect(Collectors.toList());
			// LOGGER.info("list ==> " + list.size());
			/*
			List<CrucePmmWmsDto> result = jsonarr.toList().stream()
			        .filter(Map.class::isInstance)
			        .map(Map.class::cast)
			        .map(o -> o.get("name"))
			        .filter(CrucePmmWmsDto.class::isInstance)
			        .map(CrucePmmWmsDto.class::cast)
			        .collect(Collectors.toList());*/
			

			for (int i = 0; i < jsonarr.length(); i++) {
				crucePmmWmsDto = new CrucePmmWmsDto();
				
				
				
				if (jsonarr.getJSONObject(i).has("idCruce_pmm_wms")) {
				
					crucePmmWmsDto.setIdcrucePmmWms(jsonarr.getJSONObject(i).getInt("idCruce_pmm_wms"));
				}

				if (jsonarr.getJSONObject(i).has("id_tbl_pmm_wms")) {
					crucePmmWmsDto.setIdTblPmmWms(jsonarr.getJSONObject(i).getInt("id_tbl_pmm_wms"));

				}

				if (jsonarr.getJSONObject(i).has("CD")) {
					crucePmmWmsDto.setCd(jsonarr.getJSONObject(i).getString("CD").toString());
				}
				
				
				if (jsonarr.getJSONObject(i).has("desc_CD")) {
					crucePmmWmsDto.setDescCD(jsonarr.getJSONObject(i).getString("desc_CD").toString());
				}

				if (jsonarr.getJSONObject(i).has("COD_MAT")) {
					crucePmmWmsDto.setCodMat(jsonarr.getJSONObject(i).getInt("COD_MAT"));
				}
				
				if (jsonarr.getJSONObject(i).has("desc_Material")) {
					crucePmmWmsDto.setDescMaterial(jsonarr.getJSONObject(i).getString("desc_Material"));
				}

				if (jsonarr.getJSONObject(i).has("LOTE")) {
					crucePmmWmsDto.setLote(jsonarr.getJSONObject(i).getString("LOTE").toString());
				}

				if (jsonarr.getJSONObject(i).has("CRUCE_HOMOLOGADO")) {
					crucePmmWmsDto.setIdTipoInventario(jsonarr.getJSONObject(i).getInt("CRUCE_HOMOLOGADO"));
				}
				if (jsonarr.getJSONObject(i).has("Nombre_Inventario")) {
					crucePmmWmsDto.setCruceHomologado(jsonarr.getJSONObject(i).getString("Nombre_Inventario").toString());
				}
				
				

				if (jsonarr.getJSONObject(i).has("PMM")) {
					crucePmmWmsDto.setPmm(jsonarr.getJSONObject(i).getInt("PMM"));
				}
				if (jsonarr.getJSONObject(i).has("WMS")) {
					crucePmmWmsDto.setWms(jsonarr.getJSONObject(i).getInt("WMS"));
				}
				if (jsonarr.getJSONObject(i).has("SUGERENCIA_AJUSTE")) {
					crucePmmWmsDto.setSugerenciaAjuste(jsonarr.getJSONObject(i).getInt("SUGERENCIA_AJUSTE"));
				}
				if (jsonarr.getJSONObject(i).has("SCTOCK_BOLSA_DISCREPANCIA")) {
					crucePmmWmsDto.setSctockBolsaDiscrepancia(jsonarr.getJSONObject(i).getInt("SCTOCK_BOLSA_DISCREPANCIA"));
				}


				list.add(crucePmmWmsDto);

			}
		
			
			

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<AjustePmmWmsDto> listAnalisisAjustePmmWms(int idCrucePmmWms) {
		// TODO Auto-generated method stub
		AjustePmmWmsDto ajustePmmWmsDto = null;

		String cd = cargaWmsRepository.getCDCrucePmmWms(idCrucePmmWms);

		Map<String, Object> mapList = this.crucePmmWmsRepository.listAnalisisAjustePmmWms(idCrucePmmWms, cd);

		List<AjustePmmWmsDto> list = new ArrayList<AjustePmmWmsDto>();

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		LOGGER.info("\nPretty toString ==> " + mapList.toString());
		LOGGER.info("\nPretty toString ==> " + mapList.get("#result-set-1"));
		String prettyJson = prettyGson.toJson(mapList.get("#result-set-1"));

		LOGGER.info("\nPretty JSONObject ==> " + prettyJson);
		LOGGER.info("mapList mapList ==> " + mapList.size());
		try {
			JSONArray jsonarr = new JSONArray(prettyJson);// prettyJson.getJSONArray("#result-set-1");
			LOGGER.info("tamaño ==> " + jsonarr.length());

			for (int i = 0; i < jsonarr.length(); i++) {

				ajustePmmWmsDto = new AjustePmmWmsDto();
				
				LOGGER.info("idcruce_pmm_wms ==> " + jsonarr.getJSONObject(i).getInt("idCruce_pmm_wms"));
				
				LOGGER.info("Material ===> " +jsonarr.getJSONObject(i).getString("Desc_Material").toString());
				
				if (jsonarr.getJSONObject(i).has("idCruce_pmm_wms")) {
					ajustePmmWmsDto.setIdcrucePmmWms(jsonarr.getJSONObject(i).getInt("idCruce_pmm_wms"));
				}

				if (jsonarr.getJSONObject(i).has("id_tbl_pmm_wms")) {
					ajustePmmWmsDto.setIdTblPmmWms(jsonarr.getJSONObject(i).getInt("id_tbl_pmm_wms"));
				}
				
				if (jsonarr.getJSONObject(i).has("fechaMatch")) {
					ajustePmmWmsDto.setFechaMatch(jsonarr.getJSONObject(i).getString("fechaMatch").toString());
				}
				
				if (jsonarr.getJSONObject(i).has("horaMatch")) {
					ajustePmmWmsDto.setHoraMatch(jsonarr.getJSONObject(i).getString("horaMatch").toString());
				}

				
				if (jsonarr.getJSONObject(i).has("desc_CD")) {
					ajustePmmWmsDto.setDescCD(jsonarr.getJSONObject(i).getString("desc_CD").toString());
				}
				
				if (jsonarr.getJSONObject(i).has("CD")) {
					ajustePmmWmsDto.setCd(jsonarr.getJSONObject(i).getString("CD").toString());
				}

				if (jsonarr.getJSONObject(i).has("COD_MAT")) {
					ajustePmmWmsDto.setCodMat(jsonarr.getJSONObject(i).getInt("COD_MAT"));
				}
			
				if (jsonarr.getJSONObject(i).has("Desc_Material")) {
					
					ajustePmmWmsDto.setDescMaterial(jsonarr.getJSONObject(i).getString("Desc_Material").toString());
					
				}


				if (jsonarr.getJSONObject(i).has("LOTE")) {
					ajustePmmWmsDto.setLote(jsonarr.getJSONObject(i).getString("LOTE").toString());
				}

				if (jsonarr.getJSONObject(i).has("pmm_disponible")) {
					ajustePmmWmsDto.setPmmDisponible(jsonarr.getJSONObject(i).getInt("pmm_disponible"));
				}

				if (jsonarr.getJSONObject(i).has("wms_disponible")) {
					ajustePmmWmsDto.setWmsDisponible(jsonarr.getJSONObject(i).getInt("wms_disponible"));
				}

				if (jsonarr.getJSONObject(i).has("Dif_DISPON")) {
					ajustePmmWmsDto.setDifDispon(jsonarr.getJSONObject(i).getInt("Dif_DISPON"));
				}

				if (jsonarr.getJSONObject(i).has("pmm_en_puerta")) {
					ajustePmmWmsDto.setPmmEnPuerta(jsonarr.getJSONObject(i).getInt("pmm_en_puerta"));
				}

				if (jsonarr.getJSONObject(i).has("wms_pu")) {
					ajustePmmWmsDto.setWmsPu(jsonarr.getJSONObject(i).getInt("wms_pu"));
				}

				if (jsonarr.getJSONObject(i).has("Dif_ENPUERTA")) {
					ajustePmmWmsDto.setDifEnpuerta(jsonarr.getJSONObject(i).getInt("Dif_ENPUERTA"));
				}

				if (jsonarr.getJSONObject(i).has("pmm_perdido_no_disponible")) {
					ajustePmmWmsDto.setPmmPerdidoNoDisponible(
							jsonarr.getJSONObject(i).getInt("pmm_perdido_no_disponible"));
				}

				if (jsonarr.getJSONObject(i).has("wms_pa_pd")) {
					ajustePmmWmsDto.setWmsPaPd(jsonarr.getJSONObject(i).getInt("wms_pa_pd"));
				}
				if (jsonarr.getJSONObject(i).has("Dif_PERDIDO")) {
					ajustePmmWmsDto.setDifPerdido(jsonarr.getJSONObject(i).getInt("Dif_PERDIDO"));
				}

				if (jsonarr.getJSONObject(i).has("pmm_acondiciona_cuarentena")) {
					ajustePmmWmsDto.setPmmAcondicionaCuarentena(
							jsonarr.getJSONObject(i).getInt("pmm_acondiciona_cuarentena"));
				}
				if (jsonarr.getJSONObject(i).has("wms_ac_qc")) {
					ajustePmmWmsDto.setWmsAcQc(jsonarr.getJSONObject(i).getInt("wms_ac_qc"));
				}

				if (jsonarr.getJSONObject(i).has("dif_acond_ac_qc")) {
					ajustePmmWmsDto.setDifAcondAcQc(jsonarr.getJSONObject(i).getInt("dif_acond_ac_qc"));
				}
				if (jsonarr.getJSONObject(i).has("pmm_canje_mercaderia")) {
					ajustePmmWmsDto.setPmmCanjeMercaderia(
							jsonarr.getJSONObject(i).getInt("pmm_canje_mercaderia"));
				}
				if (jsonarr.getJSONObject(i).has("wms_cj")) {
					ajustePmmWmsDto.setWmsCj(jsonarr.getJSONObject(i).getInt("wms_cj"));
				}

				if (jsonarr.getJSONObject(i).has("Dif_MERCADERIA_CJ")) {
					ajustePmmWmsDto
							.setDifMercaderiaCj(jsonarr.getJSONObject(i).getInt("Dif_MERCADERIA_CJ"));
				}

				if (jsonarr.getJSONObject(i).has("pmm_mermas")) {
					ajustePmmWmsDto.setPmmMermas(jsonarr.getJSONObject(i).getInt("pmm_mermas"));
				}

				if (jsonarr.getJSONObject(i).has("wms_bj")) {
					ajustePmmWmsDto.setWmsBj(jsonarr.getJSONObject(i).getInt("wms_bj"));
				}
				if (jsonarr.getJSONObject(i).has("Dif_MERMAS_BJ")) {
					ajustePmmWmsDto.setDifMermasBj(jsonarr.getJSONObject(i).getInt("Dif_MERMAS_BJ"));
				}

				if (!cd.equalsIgnoreCase("CD12")) {
					if (jsonarr.getJSONObject(i).has("bolsa_discrepancia")) {

						ajustePmmWmsDto.setBolsaDiscrepancia(
								jsonarr.getJSONObject(i).getInt("bolsa_discrepancia"));
					}
				}

				if (cd.equalsIgnoreCase("CD12")) {

					if (jsonarr.getJSONObject(i).has("pmm_economato_disponible")) {
						ajustePmmWmsDto.setPmmEconomatoDisponible(
								jsonarr.getJSONObject(i).getInt("pmm_economato_disponible"));
					}

					if (jsonarr.getJSONObject(i).has("wms_ec")) {
						ajustePmmWmsDto.setWmsEc(jsonarr.getJSONObject(i).getInt("wms_ec"));
					}
					if (jsonarr.getJSONObject(i).has("dif_econo_disponible")) {
						ajustePmmWmsDto.setDifEconoDisponible(
								jsonarr.getJSONObject(i).getInt("dif_econo_disponible"));
					}

					if (jsonarr.getJSONObject(i).has("pmm_economato_bloqueado")) {
						ajustePmmWmsDto.setPmmEconomatoBloqueado(
								jsonarr.getJSONObject(i).getInt("pmm_economato_bloqueado"));
					}

					if (jsonarr.getJSONObject(i).has("wms_eb")) {
						ajustePmmWmsDto.setWmsEb(jsonarr.getJSONObject(i).getInt("wms_eb"));
					}
					if (jsonarr.getJSONObject(i).has("dif_econo_bloqueado")) {
						ajustePmmWmsDto.setDifEconoBloqueado(
								jsonarr.getJSONObject(i).getInt("dif_econo_bloqueado"));
					}
					if (jsonarr.getJSONObject(i).has("bolsa_discrepancia_econo")) {
						ajustePmmWmsDto.setBolsaDiscrepanciaEcono(
								jsonarr.getJSONObject(i).getInt("bolsa_discrepancia_econo"));
					}
				}

				list.add(ajustePmmWmsDto);

			}

		}

		catch (JSONException e) {
			e.printStackTrace();
		}
		LOGGER.info(" fin listAnalisisAjustePmmWms " + list.size());
		return list;
	}
	
	@Override
	public void spActualizarEstadoWMSPMMTotal(int pidCrucePmmWms , int idEstado ) throws SQLException {
		crucePmmWmsRepository.spActualizarEstadoWMSPMMTotal(pidCrucePmmWms, idEstado);
	}

}
