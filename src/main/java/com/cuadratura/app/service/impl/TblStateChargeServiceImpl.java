package com.cuadratura.app.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.oracle.dto.TblStateChargeDto;
import com.cuadratura.app.oracle.entity.TblStateCharge;
import com.cuadratura.app.oracle.repository.TblStateChargeRepository;
import com.cuadratura.app.service.TblStateChargeService;

@Service
public class TblStateChargeServiceImpl extends GenericServiceImpl<TblStateCharge, BigDecimal>
		implements TblStateChargeService {
	private static final Logger LOGGER = LogManager.getLogger(TblStateChargeServiceImpl.class);

	@Autowired
	private TblStateChargeRepository tblStateChargeRepository;

	@Override
	public CrudRepository<TblStateCharge, BigDecimal> getDao() {
		// TODO Auto-generated method stub
		return tblStateChargeRepository;
	}

	@Override
	public List<TblStateChargeDto> getFindAllTblStateCharge() {
		// TODO Auto-generated method stub
		LOGGER.info("getFindAllTblStateCharge");
		return this.tblStateChargeRepository.getFindAllTblStateCharge();
	}
	
	@Override
	public void updateTblStateCharge(Integer idStateCharge) {
		LOGGER.info("idStateCharge "+idStateCharge);
		this.tblStateChargeRepository.updateTblStateCharge(idStateCharge);
	}
}
