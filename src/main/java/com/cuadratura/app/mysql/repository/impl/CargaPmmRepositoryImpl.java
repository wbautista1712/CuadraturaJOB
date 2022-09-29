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

import com.cuadratura.app.mysql.entity.CargaPmm;
import com.cuadratura.app.mysql.repository.CargaPmmRepositoryCustom;

@Repository
@Transactional
public class CargaPmmRepositoryImpl implements CargaPmmRepositoryCustom{
	
	private static final Logger LOGGER = LogManager.getLogger(CargaPmmRepositoryImpl.class);
	
	@Autowired
	@Qualifier("jdbctemplateTwo")
	private JdbcTemplate jdbcTemplate;	

	@PersistenceContext(unitName = "jpa_mysql")
	private EntityManager em;
	
	@Override
	public Long saveCargaPmm(CargaPmm cargaPmm) {
		//prd_lvl_child
		String INSERT_MESSAGE_SQL = "INSERT INTO cuadratura.carga_pmm "
				+ "(estado, fechaFoto, horaFoto, id_m_TipoImportacion, id_m_estadoCuadratura, nombreArchivo, numRegistros, org_lvl_child, usuarioCarga) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(INSERT_MESSAGE_SQL, new String[] { "idCarga_PMM" });

			java.util.Date utilDate = cargaPmm.getFechaFoto();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			ps.setBoolean(1, cargaPmm.isEstado());
			ps.setDate(2, sqlDate);
			ps.setString(3, cargaPmm.getHoraFoto());
			ps.setInt(4, cargaPmm.getIdmTipoImportacion());
			ps.setInt(5, cargaPmm.getIdmestadoCuadratura());
			ps.setString(6,  cargaPmm.getNombreArchivo());
			ps.setInt(7, cargaPmm.getNumRegistros());
			ps.setInt(8, cargaPmm.getOrgLvlChild());
			ps.setString(9, cargaPmm.getUsuarioCarga());
	
			return ps;
		}, keyHolder);
		LOGGER.info("id recupera");

		return keyHolder.getKey().longValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllFindFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta, Integer start, Integer end){
		
		LOGGER.info("id idCentroDistribucion==>>> "+idCentroDistribucion);
		LOGGER.info("id fechaDesde ==>>> "+fechaDesde);
		LOGGER.info("id fechaHasta==>> "+fechaHasta);
		String sql =  "SELECT C.idCarga_PMM, date_format(C.fechaFoto, '%d/%m/%Y') AS FECHA_FOTO, C.horaFoto AS HORA_FOTO, date_format(now(), '%d/%m/%Y') AS FECHA_CARGA,  date_format(now(), '%H:%i:%s') AS HORA_CARGA, "
				+ "C.numRegistros AS REGISTROS, C.usuarioCarga as USUARIO, C.nombreArchivo AS NOMBRE_ARCHIVO, EC.nombreEC AS ESTADO "
				+ "FROM cuadratura.carga_pmm C "
				+ "INNER JOIN cuadratura.m_estado_cuadratura EC ON C.id_m_estadoCuadratura=EC.id_m_estadoCuadratura "		
				+ "WHERE C.org_lvl_child=:idCentroDistribucion AND C.fechaFoto BETWEEN :fechaDesde AND :fechaHasta ";
		
		
		Query query = this.em.createNativeQuery(sql);
		query.setParameter("idCentroDistribucion", idCentroDistribucion);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta",fechaHasta);
	
		query.setFirstResult(start);
		query.setMaxResults(end);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
		
	}
	
	@Override
	public Integer countFotoPmm(String idCentroDistribucion, String fechaDesde, String fechaHasta) throws Exception{
		String sql ="SELECT COUNT(*) FROM (SELECT C.idCarga_PMM, date_format(C.fechaFoto, '%d/%m/%Y') AS FECHA_FOTO, C.horaFoto AS HORA_FOTO, date_format(now(), '%d/%m/%Y') AS FECHA_CARGA,  date_format(now(), '%H:%i:%s') AS HORA_CARGA, "
				+ "C.numRegistros AS REGISTROS, C.usuarioCarga as USUARIO, C.nombreArchivo AS NOMBRE_ARCHIVO, EC.nombreEC AS ESTADO "
				+ "FROM cuadratura.carga_pmm C "
				+ "INNER JOIN cuadratura.m_estado_cuadratura EC ON C.id_m_estadoCuadratura=EC.id_m_estadoCuadratura "		
				+ "WHERE C.org_lvl_child=:idCentroDistribucion AND C.fechaFoto BETWEEN :fechaDesde AND :fechaHasta  ) tt ";
		
		Query query = em.createNativeQuery(sql.toString());
		query.setParameter("idCentroDistribucion", idCentroDistribucion);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta",fechaHasta);
		
		return Integer.valueOf(query.getSingleResult().toString());
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getExportFotoPmm(Integer idCentroDistribucion, String fechaDesde, String fechaHasta){
		String sql = "SELECT DISTINCT C.idCarga_PMM, date_format(C.fechaFoto, '%d/%m/%Y') AS FECHA_FOTO, C.horaFoto AS HORA_FOTO, date_format(now(), '%d/%m/%Y') AS FECHA_CARGA,  date_format(now(), '%H:%i:%s') AS HORA_CARGA, "
				+ "C.numRegistros AS REGISTROS, C.usuarioCarga as USUARIO, C.nombreArchivo AS NOMBRE_ARCHIVO, EC.nombreEC AS ESTADO "
				+ "FROM cuadratura.carga_pmm C "
				+ "INNER JOIN cuadratura.m_estado_cuadratura EC ON C.id_m_estadoCuadratura=EC.id_m_estadoCuadratura "		
				+ "WHERE C.org_lvl_child=:idCentroDistribucion AND date_format(C.fechaFoto, '%Y-%m-%d') BETWEEN :fechaDesde AND :fechaHasta ";
		
		Query query = this.em.createNativeQuery(sql);
		query.setParameter("idCentroDistribucion", idCentroDistribucion);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta",fechaHasta);
	
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}

	
}
