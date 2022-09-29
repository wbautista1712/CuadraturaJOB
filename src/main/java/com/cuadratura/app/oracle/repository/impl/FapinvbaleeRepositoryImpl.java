package com.cuadratura.app.oracle.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.repository.FapinvbaleeRepositoryCustom;

@Repository
@Transactional
public class FapinvbaleeRepositoryImpl implements FapinvbaleeRepositoryCustom{

	private static final Logger LOGGER = LogManager.getLogger(FapinvbaleeRepositoryImpl.class);
	
	@PersistenceContext(unitName = "jpa_oracle")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getLoteFotoPmm(){
		String sql =  "SELECT org_lvl_child idCD, COUNT (*) num_registros "
				+ "  FROM pmm.fapinvbalee  "
				+ " GROUP BY org_lvl_child ";
		
		Query query = this.entityManager.createNativeQuery(sql);		
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		return query.getResultList();
	}	

}
