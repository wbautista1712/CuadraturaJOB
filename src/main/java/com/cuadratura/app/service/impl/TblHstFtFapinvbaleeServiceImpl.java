package com.cuadratura.app.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadratura.app.oracle.dto.TblHstFtFapinvbaleeDto;
import com.cuadratura.app.oracle.repository.TblHstFtFapinvbaleeRepositoryCustom;
import com.cuadratura.app.service.TblHstFtFapinvbaleeService;

@Service
public class TblHstFtFapinvbaleeServiceImpl implements TblHstFtFapinvbaleeService {
	
	private static final Logger LOGGER = LogManager.getLogger(TblHstFtFapinvbaleeServiceImpl.class);

	@Autowired
	private TblHstFtFapinvbaleeRepositoryCustom tblHstFtFapinvbaleeRepository;
	
	public List<TblHstFtFapinvbaleeDto> listTblHstFtFapinvbalee(Integer idStateCharge){
		LOGGER.info("listTblHstFtFapinvbalee "+idStateCharge);
		return this.tblHstFtFapinvbaleeRepository.listTblHstFtFapinvbalee(idStateCharge);
	}
	
}
