package com.cuadratura.app.mysql.repository.impl;

import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.CargaWms;
import com.cuadratura.app.mysql.repository.CargaWmsRepositoryCustom;

@Repository
@Transactional
public class CargaWmsRepositoryImpl implements CargaWmsRepositoryCustom {

	private static final Logger LOGGER = LogManager.getLogger(CargaWmsRepositoryImpl.class);


	@Autowired
	@Qualifier("jdbctemplateTwo")
	private JdbcTemplate jdbcTemplate;
	
	

	@PersistenceContext(unitName = "jpa_mysql")
	private EntityManager em;

	@Override
	public Long saveCargaWms(CargaWms cargaWms) {		

		String INSERT_MESSAGE_SQL = "INSERT INTO cuadratura.carga_wms "
				+ "(fechaCarga,horaCarga,num_registros,usuario_carga,id_m_TipoImportacion,id_m_estadoCuadratura,estado, org_name_short) "
				+ "VALUES (?,?,?,?,?,?,?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(INSERT_MESSAGE_SQL, new String[] { "idCarga_WMS" });

			java.util.Date utilDate = cargaWms.getFechaCarga();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			ps.setDate(1, sqlDate);
			ps.setString(2, cargaWms.getHoraCarga());
			ps.setInt(3, cargaWms.getNumRegistros());
			ps.setString(4, cargaWms.getUsuarioCarga());
			ps.setInt(5, cargaWms.getIdmTipoImportacion());
			ps.setInt(6, cargaWms.getIdmestadoCuadratura());
			ps.setBoolean(7, cargaWms.isEstado());
			ps.setString(8, cargaWms.getOrgNameShort());
			return ps;
		}, keyHolder);
		LOGGER.info("recupera");

		return keyHolder.getKey().longValue();

	}
		
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllFindFotoWms(String idCentroDistribucion, String fechaDesde, String fechaHasta, Integer start, Integer end){
		LOGGER.info("::: getAllFindFotoWms:::start "+start);
		LOGGER.info("::: getAllFindFotoWms:::end "+end);
	String sql = "SELECT distinct CD.org_lvl_child,  C.idCarga_WMS, "
			+ "date_format(CONCAT(SUBSTR(WMS.CREATE_DATE,1,4),'-',SUBSTR(WMS.CREATE_DATE,5,2),'-',SUBSTR(WMS.CREATE_DATE,7,2)),'%d/%m/%Y') AS FECHA_FOTO,  " 
			+ "MAX(CONCAT(SUBSTR(WMS.CREATE_DATE,9,2),':',SUBSTR(WMS.CREATE_DATE,11,2),':',SUBSTR(WMS.CREATE_DATE,13,2))) AS HORA_FOTO,  "
			+ "date_format(C.fechaCarga, '%d/%m/%Y') AS FECHA_CARGA, C.horaCarga AS HORA_CARGA,  "
			+ "C.num_Registros AS REGISTROS, C.usuario_Carga as USUARIO, EC.nombreEC AS ESTADO, WMS.NRO_CARGA FROM cuadratura.carga_wms C "  
			+ "INNER JOIN cuadratura.tbl_wms WMS ON C.idCarga_WMS=WMS.idCarga_WMS INNER JOIN cuadratura.m_estado_cuadratura EC ON  "
			+ "C.id_m_estadoCuadratura=EC.id_m_estadoCuadratura INNER JOIN cuadratura.m_orgmstee CD ON C.org_name_short=CD.org_name_short " 
			+ "WHERE CD.org_lvl_child=:idCentroDistribucion "
			+ "AND date_format(CONCAT(SUBSTR(WMS.CREATE_DATE,1,4),'-',SUBSTR(WMS.CREATE_DATE,5,2),'-',SUBSTR(WMS.CREATE_DATE,7,2)),'%Y-%m-%d') "  
			+ "BETWEEN :fechaDesde AND :fechaHasta "
			+ "GROUP BY CD.org_lvl_child,  C.idCarga_WMS, date_format(CONCAT(SUBSTR(WMS.CREATE_DATE,1,4),'-',SUBSTR(WMS.CREATE_DATE,5,2),'-',SUBSTR(WMS.CREATE_DATE,7,2)),'%d/%m/%Y'), "
			 + "C.horaCarga, C.num_Registros, C.usuario_Carga, EC.nombreEC, WMS.NRO_CARGA";		
	
		Query query = this.em.createNativeQuery(sql);
		query.setParameter("idCentroDistribucion", idCentroDistribucion);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta",fechaHasta);
	
		query.setFirstResult(start);
		query.setMaxResults(end);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	    
	}	
	
	public Integer countFotoWms(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception{
		String sql = "SELECT COUNT(*) FROM (SELECT distinct CD.org_lvl_child,  C.idCarga_WMS,  \r\n"
				+ "date_format(CONCAT(SUBSTR(WMS.CREATE_DATE,1,4),'-',SUBSTR(WMS.CREATE_DATE,5,2),'-',SUBSTR(WMS.CREATE_DATE,7,2)),'%d/%m/%Y') AS FECHA_FOTO, "
				+ "MAX(CONCAT(SUBSTR(WMS.CREATE_DATE,9,2),':',SUBSTR(WMS.CREATE_DATE,11,2),':',SUBSTR(WMS.CREATE_DATE,13,2))) AS HORA_FOTO, "
				+ "date_format(C.fechaCarga, '%d/%m/%Y') AS FECHA_CARGA, C.horaCarga AS HORA_CARGA, "
				+ "C.num_Registros AS REGISTROS, C.usuario_Carga as USUARIO, EC.nombreEC AS ESTADO, WMS.NRO_CARGA FROM cuadratura.carga_wms C "
				+ "INNER JOIN cuadratura.tbl_wms WMS ON C.idCarga_WMS=WMS.idCarga_WMS INNER JOIN cuadratura.m_estado_cuadratura EC ON "
				+ "C.id_m_estadoCuadratura=EC.id_m_estadoCuadratura INNER JOIN cuadratura.m_orgmstee CD ON C.org_name_short=CD.org_name_short "
				+ "WHERE CD.org_lvl_child=:idCentroDistribucion "
				+ "AND date_format(CONCAT(SUBSTR(WMS.CREATE_DATE,1,4),'-',SUBSTR(WMS.CREATE_DATE,5,2),'-',SUBSTR(WMS.CREATE_DATE,7,2)),'%Y-%m-%d') "
				+ "BETWEEN :fechaDesde AND :fechaHasta "
				+ "GROUP BY CD.org_lvl_child,  C.idCarga_WMS, date_format(CONCAT(SUBSTR(WMS.CREATE_DATE,1,4),'-',SUBSTR(WMS.CREATE_DATE,5,2),'-',SUBSTR(WMS.CREATE_DATE,7,2)),'%d/%m/%Y'), "
				+ " C.horaCarga, C.num_Registros, C.usuario_Carga, EC.nombreEC, WMS.NRO_CARGA )   tt ";
		
		Query query = em.createNativeQuery(sql.toString());
		query.setParameter("idCentroDistribucion", idCentroDistribucion);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta",fechaHasta);	
		
		return Integer.valueOf(query.getSingleResult().toString());
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getExportFotoWms(Integer idCarga_WMS){
		String sql = "SELECT C.idCarga_WMS, CD.org_lvl_child, "
				+ "date_format(C.fechaCarga, '%d/%m/%Y') AS FECHA_CARGA, C.horaCarga AS HORA_CARGA, "
				+ "WMS.nro_carga, WMS.create_date, WMS.facility_code, WMS.company_code, WMS.item_alternate, WMS.item_part_a, WMS.item_part_b,item_part_c, "
				+ "WMS.item_part_d, WMS.item_part_e, WMS.item_part_f, WMS.hierarchy1_code, WMS.hierarchy2_code, WMS.hierarchy3_code, WMS.hierarchy4_code, WMS.hierarchy5_code, "
				+ "WMS.batch_nbr, WMS.pre_pack_code, WMS.tbl_wmscol, WMS.pre_pack_ratio, WMS.pre_pack_units, WMS.oblpn_total, WMS.active_total, WMS.active_allocated, "
				+ "WMS.active_allocated_lockcode, WMS.active_available,active_lockcode,iblpn_total,iblpn_allocated,iblpn_allocated_lockcode, "
				+ "WMS.iblpn_available, WMS.iblpn_notverified, WMS.iblpn_lockcode, WMS.iblpn_lost, WMS.total_allocated, WMS.total_available, WMS.total_inventory, "
				+ "WMS.four_wall_inventory, WMS.open_order_qty, WMS.lock_code_1, WMS.lock_code_qty_1, WMS.lock_code_2, WMS.lock_code_qty_2, WMS.lock_code_3, WMS.lock_code_qty_3, "
				+ "WMS.lock_code_4, WMS.lock_code_qty_4, WMS.lock_code_5, WMS.lock_code_qty_5, WMS.lock_code_6, WMS.lock_code_qty_6, WMS.lock_code_7, WMS.lock_code_qty_7, WMS.lock_code_8, "
				+ "WMS.lock_code_qty_8, WMS.lock_code_9, WMS.lock_code_qty_9, WMS.lock_code_10, WMS.lock_code_qty_10, WMS.download_date1, WMS.error_code, WMS.observacion_error, WMS.flg_tipo "
				+ "FROM cuadratura.carga_wms C "
				+ "INNER JOIN cuadratura.tbl_wms WMS ON C.idCarga_WMS=WMS.idCarga_WMS "
				+ "INNER JOIN cuadratura.m_orgmstee CD ON C.org_name_short=CD.org_name_short "
				+ "WHERE C.idCarga_WMS=:idCarga_WMS;";

		Query query = this.em.createNativeQuery(sql);
		query.setParameter("idCentroDistribucion", idCarga_WMS);	
		
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}
	
	
}
