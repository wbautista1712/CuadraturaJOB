package com.cuadratura.app.mysql.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.repository.TblPmmWmsRepositoryCustom;

@Repository
public class TblPmmWmsRepositoryImpl implements TblPmmWmsRepositoryCustom {
	private static final Logger LOGGER = LogManager.getLogger(TblPmmWmsRepositoryImpl.class);

	@PersistenceContext(unitName = "jpa_mysql")
	private EntityManager em;

	public void saveCrucePmmWms(int idCargaPMM, int idCargaWMS, String idCD, int idUsuario, int idCrucePmmWms) {
		LOGGER.info("idCargaPMM " + idCargaPMM);
		LOGGER.info("idCargaWMS " + idCargaWMS);
		LOGGER.info("idCD " + idCD);
		LOGGER.info("idUsuario " + idUsuario);
		LOGGER.info("idCrucePmmWms " + idCrucePmmWms);
		StoredProcedureQuery query = em.createStoredProcedureQuery("cuadratura.sp_carga_pmm_wms")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN).setParameter(1, idCargaPMM)
				.setParameter(2, idCargaWMS).setParameter(3, idCD).setParameter(4, idUsuario)
				.setParameter(5, idCrucePmmWms);
		query.execute();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllResultadoPmmWms(String idCD_org_name_short, String fechaDesde, String fechaHasta, Integer start, Integer end) {
		LOGGER.info("idCD_org_name_short ===>> " + idCD_org_name_short);
		LOGGER.info("start  ===>> " + start);
		LOGGER.info("end  ===>> " + end);
		
		LOGGER.info("Fechas  ===>> " + fechaDesde + " - " + fechaHasta);
		
		// MODIFICAR SCRIPT CON DISTINCT
		/*
		String sql = "SELECT C.idCruce_pmm_wms, date_format(C.fechaMatch, '%d/%m/%Y') AS fechaMatch, C.horaMatch, concat(PMM.usuarioCarga,'/',WMS.usuario_carga) as USUARIO, "
				+ "date_format(PMM.fechaFoto, '%d/%m/%Y') AS fechaFotoPMM, cuadratura.horaFoto AS horaFotoPMM, date_format(WMS.fechaCarga, '%d/%m/%Y') AS fechaCargaWMS, WMS.horaCarga AS horaCargaWMS,"
				+ "PMM.idCarga_PMM, WMS.idCarga_WMS, EC.nombreEC AS estado " + "FROM cuadratura.cruce_pmm_wms C "
				+ "INNER JOIN cuadratura.carga_pmm PMM ON C.idCarga_PMM=PMM.idCarga_PMM "
				+ "INNER JOIN cuadratura.carga_wms WMS on C.idCarga_WMS=WMS.idCarga_WMS "
				+ "INNER JOIN cuadratura.m_estado_cuadratura EC ON C.idEstadoCuadratura=EC.id_m_estadoCuadratura "
				+ "WHERE C.fechaMatch BETWEEN :fechaDesde AND :fechaHasta AND "
				+ "WMS.org_name_short=:idCD_org_name_short " + "ORDER BY C.fechaMatch DESC	"; */

		String sql="SELECT DISTINCT ATE.idCruce_pmm_wms,  ATE.fechaMatch, ATE.horaMatch, ATE.USUARIO, ATE.fechaFotoPMM, ATE.horaFotoPMM, "
				+ "ATE.fechaFotoWMS, ATE.horaFotoWMS, ATE.idCarga_PMM, ATE.idCarga_WMS, ATE.estado "
				+ "FROM ("
				+ "SELECT  C.idCruce_pmm_wms, date_format(C.fechaMatch, '%d/%m/%Y') AS fechaMatch, C.horaMatch, concat(PMM.usuarioCarga,'/',WMS.usuario_carga) as USUARIO, "
				+ "date_format(PMM.fechaFoto, '%d/%m/%Y') AS fechaFotoPMM, PMM.horaFoto AS horaFotoPMM, "
				+ "date_format(CONCAT(SUBSTR(tWMS.create_date,1,4),'-',SUBSTR(tWMS.create_date,5,2),'-',SUBSTR(tWMS.create_date,7,2)),'%d/%m/%Y') AS fechaFotoWMS, "
				+ "CONCAT(SUBSTR(tWMS.create_date,9,2),':',SUBSTR(tWMS.create_date,11,2),':',SUBSTR(tWMS.create_date,13,2)) AS horaFotoWMS, "
				+ "PMM.idCarga_PMM, WMS.idCarga_WMS, EC.nombreEC AS estado "
				+ "FROM cuadratura.cruce_pmm_wms C "
				+ "INNER JOIN cuadratura.carga_pmm PMM ON C.idCarga_PMM=PMM.idCarga_PMM "
				+ "INNER JOIN cuadratura.carga_wms WMS on C.idCarga_WMS=WMS.idCarga_WMS "
				+ "INNER JOIN cuadratura.m_estado_cuadratura EC ON C.idEstadoCuadratura=EC.id_m_estadoCuadratura "
				+ "inner join cuadratura.tbl_wms tWMS on WMS.idCarga_WMS=tWMS.idCarga_WMS "
				+ "WHERE C.fechaMatch BETWEEN :fechaDesde AND :fechaHasta AND WMS.org_name_short=:idCD_org_name_short "
				+ ")ATE ORDER BY ATE.fechaMatch DESC";
		
		
		Query query = this.em.createNativeQuery(sql);
		query.setParameter("idCD_org_name_short", idCD_org_name_short);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);

		query.setFirstResult(start);
		query.setMaxResults(end);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();

	}
	
	@Override
	public Integer countResultadoPmmWms(String idCD_org_name_short, String fechaDesde, String fechaHasta) throws Exception{
		String sql =  "SELECT COUNT(*) FROM (SELECT DISTINCT ATE.idCruce_pmm_wms,  ATE.fechaMatch, ATE.horaMatch, ATE.USUARIO, ATE.fechaFotoPMM, ATE.horaFotoPMM, "
				+ "ATE.fechaFotoWMS, ATE.horaFotoWMS, ATE.idCarga_PMM, ATE.idCarga_WMS, ATE.estado "
				+ "FROM ("
				+ "SELECT  C.idCruce_pmm_wms, date_format(C.fechaMatch, '%d/%m/%Y') AS fechaMatch, C.horaMatch, concat(PMM.usuarioCarga,'/',WMS.usuario_carga) as USUARIO, "
				+ "date_format(PMM.fechaFoto, '%d/%m/%Y') AS fechaFotoPMM, PMM.horaFoto AS horaFotoPMM, "
				+ "date_format(CONCAT(SUBSTR(tWMS.create_date,1,4),'-',SUBSTR(tWMS.create_date,5,2),'-',SUBSTR(tWMS.create_date,7,2)),'%d/%m/%Y') AS fechaFotoWMS, "
				+ "CONCAT(SUBSTR(tWMS.create_date,9,2),':',SUBSTR(tWMS.create_date,11,2),':',SUBSTR(tWMS.create_date,13,2)) AS horaFotoWMS, "
				+ "PMM.idCarga_PMM, WMS.idCarga_WMS, EC.nombreEC AS estado "
				+ "FROM cuadratura.cruce_pmm_wms C "
				+ "INNER JOIN cuadratura.carga_pmm PMM ON C.idCarga_PMM=PMM.idCarga_PMM "
				+ "INNER JOIN cuadratura.carga_wms WMS on C.idCarga_WMS=WMS.idCarga_WMS "
				+ "INNER JOIN cuadratura.m_estado_cuadratura EC ON C.idEstadoCuadratura=EC.id_m_estadoCuadratura "
				+ "inner join cuadratura.tbl_wms tWMS on WMS.idCarga_WMS=tWMS.idCarga_WMS "
				+ "WHERE C.fechaMatch BETWEEN :fechaDesde AND :fechaHasta AND WMS.org_name_short=:idCD_org_name_short "
				+ ")ATE ORDER BY ATE.fechaMatch DESC) tt";	
		
		Query query = em.createNativeQuery(sql.toString());
		query.setParameter("idCD_org_name_short", idCD_org_name_short);	
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		return Integer.valueOf(query.getSingleResult().toString());
	}
}
