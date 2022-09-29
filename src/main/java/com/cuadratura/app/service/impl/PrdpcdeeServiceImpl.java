package com.cuadratura.app.service.impl;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.oracle.entity.Prdpcdee;
import com.cuadratura.app.oracle.repository.PrdpcdeeRepository;
import com.cuadratura.app.service.PrdpcdeeService;

@Service
public class PrdpcdeeServiceImpl extends GenericServiceImpl<Prdpcdee, Long> implements PrdpcdeeService {

	private static final Logger LOGGER = LogManager.getLogger(PrdpcdeeServiceImpl.class);

	@Autowired
	private PrdpcdeeRepository prdpcdeeRepository;

	@Override
	public CrudRepository<Prdpcdee, Long> getDao() {
		// TODO Auto-generated method stub
		LOGGER.info("prdpcdeeRepository");
		return prdpcdeeRepository;
	}
	@Override
	public Integer findPrdpcdee(String numeroProd)throws SQLException {
		// TODO Auto-generated method stub
		Integer lista = prdpcdeeRepository.findPrdpcdee(numeroProd);
		LOGGER.info("get oooo " );
		LOGGER.info("get getInnerPackId " + lista);
		
		return lista;
	}

}
