package com.cuadratura.app.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.oracle.dto.FapinvbaleeDto;
import com.cuadratura.app.oracle.entity.Fapinvbalee;
import com.cuadratura.app.oracle.entity.pk.FapinvbaleePK;
import com.cuadratura.app.oracle.repository.FapinvbaleeRepository;
import com.cuadratura.app.service.FapinvbaleeService;

@Service
public class FapinvbaleeServiceImpl extends GenericServiceImpl<Fapinvbalee, FapinvbaleePK> implements FapinvbaleeService {
	private static final Logger LOGGER = LogManager.getLogger(FapinvbaleeServiceImpl.class);
	
	@Autowired
	private FapinvbaleeRepository fapinvbaleeRepository;

	@Override
	public CrudRepository<Fapinvbalee, FapinvbaleePK> getDao() {
		// TODO Auto-generated method stub
		return fapinvbaleeRepository;
	}

	@Override
	public List<Fapinvbalee> findAllPMMFapinvbalee(Integer idCD) {
		// TODO Auto-generated method stub
		LOGGER.info("findAllFapinvbalee idCD "+idCD);
		return (List<Fapinvbalee>) fapinvbaleeRepository.findAllPMMFapinvbalee(idCD);
	}
	
	
	@Override
	public List<FapinvbaleeDto> getLoteFotoPmm(){
		List<Object[]> listObject = fapinvbaleeRepository.getLoteFotoPmm();

		FapinvbaleeDto comboDTO;
		List<FapinvbaleeDto> listReturn = new ArrayList<FapinvbaleeDto>();
		for (Object[] row : listObject) {
			LOGGER.info("cast tamaño ");
			comboDTO = new FapinvbaleeDto();
			comboDTO.setIdCD( (row[0]== null ? BigDecimal.ZERO: (BigDecimal)row[0]).intValue()  );
			comboDTO.setNumRegistros((row[1]== null ? BigDecimal.ZERO: (BigDecimal)row[1]).intValue());
			listReturn.add(comboDTO);
		}
		return listReturn;
		

	}
	
}
