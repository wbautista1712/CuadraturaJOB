package com.cuadratura.app.oracle.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.repository.WmsCinsRepository;

@Repository
public class WmsCinsRepositoryImpl implements WmsCinsRepository {

	private static final Logger LOGGER = LogManager.getLogger(WmsCinsRepositoryImpl.class);

	@PersistenceContext(unitName = "jpa_oracle")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findAllWMSWmsCins(String fechaHora) throws Exception {
		// TODO Auto-generated method stub
		// LOGGER.info("idCD "+idCD);
		LOGGER.info("fechaHora " + fechaHora);
		String sql = "SELECT NRO_CARGA,CREATE_DATE,FACILITY_CODE,COMPANY_CODE,ITEM_ALTERNATE,ITEM_PART_A,ITEM_PART_B,ITEM_PART_C,ITEM_PART_D,ITEM_PART_E, "
				+ "ITEM_PART_F,HIERARCHY1_CODE,HIERARCHY2_CODE,HIERARCHY3_CODE,HIERARCHY4_CODE,HIERARCHY5_CODE,BATCH_NBR,PRE_PACK_CODE, "
				+ "PRE_PACK_RATIO,PRE_PACK_UNITS,OBLPN_TOTAL,ACTIVE_TOTAL,ACTIVE_ALLOCATED,ACTIVE_ALLOCATED_LOCKCODE,ACTIVE_AVAILABLE,ACTIVE_LOCKCODE, "
				+ "IBLPN_TOTAL,IBLPN_ALLOCATED,IBLPN_ALLOCATED_LOCKCODE,IBLPN_AVAILABLE,IBLPN_NOTVERIFIED,IBLPN_LOCKCODE,IBLPN_LOST,TOTAL_ALLOCATED, "
				+ "TOTAL_AVAILABLE,TOTAL_INVENTORY,FOUR_WALL_INVENTORY,OPEN_ORDER_QTY,LOCK_CODE_1,LOCK_CODE_QTY_1,LOCK_CODE_2,LOCK_CODE_QTY_2,LOCK_CODE_3, "
				+ "LOCK_CODE_QTY_3,LOCK_CODE_4,LOCK_CODE_QTY_4,LOCK_CODE_5,LOCK_CODE_QTY_5,LOCK_CODE_6,LOCK_CODE_QTY_6,LOCK_CODE_7,LOCK_CODE_QTY_7,LOCK_CODE_8, "
				+ "LOCK_CODE_QTY_8,LOCK_CODE_9,LOCK_CODE_QTY_9,LOCK_CODE_10,LOCK_CODE_QTY_10,TO_CHAR(DOWNLOAD_DATE1, 'YYYY-MM-DD') DOWNLOAD_DATE1,ERROR_CODE,OBSERVACION_ERROR,FLG_TIPO "
				+ "FROM INTEGRACION.WMS_CINS WHERE CREATE_DATE=:fechaHora "; // FACILITY_CODE=:idCD AND
		Query query = entityManager.createNativeQuery(sql);

	
		query.setParameter("fechaHora", fechaHora);
		List<Object[]> customerList = query.getResultList();
		LOGGER.info("WMS_CINS_List " + customerList.size());
		return customerList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findAllxNroCargaWMSWmsCins(Integer nroCarga) throws Exception{
		// TODO Auto-generated method stub
		// LOGGER.info("idCD "+idCD);
		LOGGER.info("nroCarga " + nroCarga);
		String sql = "SELECT NRO_CARGA,CREATE_DATE,FACILITY_CODE,COMPANY_CODE,ITEM_ALTERNATE,ITEM_PART_A,ITEM_PART_B,ITEM_PART_C,ITEM_PART_D,ITEM_PART_E, "
				+ "ITEM_PART_F,HIERARCHY1_CODE,HIERARCHY2_CODE,HIERARCHY3_CODE,HIERARCHY4_CODE,HIERARCHY5_CODE,BATCH_NBR,PRE_PACK_CODE, "
				+ "PRE_PACK_RATIO,PRE_PACK_UNITS,OBLPN_TOTAL,ACTIVE_TOTAL,ACTIVE_ALLOCATED,ACTIVE_ALLOCATED_LOCKCODE,ACTIVE_AVAILABLE,ACTIVE_LOCKCODE, "
				+ "IBLPN_TOTAL,IBLPN_ALLOCATED,IBLPN_ALLOCATED_LOCKCODE,IBLPN_AVAILABLE,IBLPN_NOTVERIFIED,IBLPN_LOCKCODE,IBLPN_LOST,TOTAL_ALLOCATED, "
				+ "TOTAL_AVAILABLE,TOTAL_INVENTORY,FOUR_WALL_INVENTORY,OPEN_ORDER_QTY,LOCK_CODE_1,LOCK_CODE_QTY_1,LOCK_CODE_2,LOCK_CODE_QTY_2,LOCK_CODE_3, "
				+ "LOCK_CODE_QTY_3,LOCK_CODE_4,LOCK_CODE_QTY_4,LOCK_CODE_5,LOCK_CODE_QTY_5,LOCK_CODE_6,LOCK_CODE_QTY_6,LOCK_CODE_7,LOCK_CODE_QTY_7,LOCK_CODE_8, "
				+ "LOCK_CODE_QTY_8,LOCK_CODE_9,LOCK_CODE_QTY_9,LOCK_CODE_10,LOCK_CODE_QTY_10,TO_CHAR(DOWNLOAD_DATE1, 'YYYY-MM-DD') DOWNLOAD_DATE1,ERROR_CODE,OBSERVACION_ERROR,FLG_TIPO "
				+ "FROM INTEGRACION.WMS_CINS WHERE nro_carga=:nroCarga ";
		Query query = entityManager.createNativeQuery(sql);

	
		query.setParameter("nroCarga", nroCarga);
		List<Object[]> customerList = query.getResultList();
		LOGGER.info("WMS_CINS_List " + customerList.size());
		return customerList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getCDFotoWms() {
		String sql = "SELECT facility_code idcd, COUNT (*) num_registros " + "  FROM integracion.wms_cins "
				+ " WHERE facility_code IN ('CD04', 'CD06', 'CD11', 'CD12', 'CD15') " + "GROUP BY facility_code ";

		Query query = this.entityManager.createNativeQuery(sql);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getFechaHoraFotoWms(String idCD) {
		String sql = "SELECT DISTINCT CREATE_DATE " + "FROM INTEGRACION.WMS_CINS " + "WHERE FACILITY_CODE = :idCD AND "
				+ "(SUBSTR(CREATE_DATE,1,4)||'-'||SUBSTR(CREATE_DATE,5,2)||'-'||SUBSTR(CREATE_DATE,7,2))= TO_CHAR(SYSDATE, 'YYYY-MM-DD') ORDER BY 1";

		Query query = this.entityManager.createNativeQuery(sql);
		query.setParameter("idCD", idCD);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getCDXFechaHoraFotoWms() {
		String sql = "             SELECT DISTINCT FACILITY_CODE idcd, CREATE_DATE  FROM INTEGRACION.WMS_CINS "
				+ "				WHERE FACILITY_CODE IN ('CD04', 'CD06', 'CD11', 'CD12', 'CD15')   AND "
				+ "(SUBSTR(CREATE_DATE,1,4)||'-'||SUBSTR(CREATE_DATE,5,2)||'-'||SUBSTR(CREATE_DATE,7,2))= TO_CHAR(SYSDATE-1, 'YYYY-MM-DD') ORDER BY 1";

		Query query = this.entityManager.createNativeQuery(sql);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getNroCargaFotoWms(String idCD) {
		String sql = "SELECT DISTINCT nro_carga " + "FROM INTEGRACION.WMS_CINS " + "WHERE FACILITY_CODE = :idCD AND "
				+ "(SUBSTR(CREATE_DATE,1,4)||'-'||SUBSTR(CREATE_DATE,5,2)||'-'||SUBSTR(CREATE_DATE,7,2))= TO_CHAR(SYSDATE, 'YYYY-MM-DD') ORDER BY 1";

		Query query = this.entityManager.createNativeQuery(sql);
		query.setParameter("idCD", idCD);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}

}
