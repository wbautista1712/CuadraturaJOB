package com.cuadratura.app.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadratura.app.oracle.dto.WmsCinsCDDto;
import com.cuadratura.app.oracle.dto.WmsCinsDto;
import com.cuadratura.app.oracle.repository.WmsCinsRepository;
import com.cuadratura.app.service.WmsCinsService;

@Service
public class WmsCinsServiceImpl implements WmsCinsService {
	
	private static final Logger LOGGER = LogManager.getLogger(WmsCinsServiceImpl.class);

	@Autowired
	private WmsCinsRepository wmsCinsRepository;

	@Override
	public List<WmsCinsDto> findAllWMSWmsCins(String fechaHora) throws Exception {
		// TODO Auto-generated method stub
		WmsCinsDto wmsCinsDto = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		LOGGER.info(" inicio fechaHora "+fechaHora);
		List<Object[]> list = wmsCinsRepository.findAllWMSWmsCins( fechaHora);
		
		List<WmsCinsDto> listConciliaPf = new ArrayList<WmsCinsDto>();
		
		Date date  = null;
		
		for (Object[] fila : list) {
			wmsCinsDto = new WmsCinsDto();
			LOGGER.info(" inicio list "+list.size());
		
			wmsCinsDto.setNroCarga(((BigDecimal) fila[0] == null ? 0 : ((BigDecimal) fila[0])).longValue());
			wmsCinsDto.setCreateDate((String) fila[1]);
			wmsCinsDto.setFacilityCode((String) fila[2]);
			wmsCinsDto.setCompanyCode((String) fila[3]);
			wmsCinsDto.setItemAlternate((String) fila[4]);
			wmsCinsDto.setItemPartA((String) fila[5]);
			wmsCinsDto.setItemPartB((String) fila[6]);
			wmsCinsDto.setItemPartC((String) fila[7]);
			wmsCinsDto.setItemPartD((String) fila[8]);
			wmsCinsDto.setItemPartE((String) fila[9]);
			wmsCinsDto.setItemPartF((String) fila[10]);
			wmsCinsDto.setHierarchy1Code((String) fila[11]);
			wmsCinsDto.setHierarchy2Code((String) fila[12]);
			wmsCinsDto.setHierarchy3Code((String) fila[13]);
			wmsCinsDto.setHierarchy4Code((String) fila[14]);

			wmsCinsDto.setHierarchy5Code((String) fila[15]);
			wmsCinsDto.setBatchNbr((String) fila[16]);
			wmsCinsDto.setPrePackCode((String) fila[17]);
			wmsCinsDto.setPrePackRatio(((BigDecimal) fila[18] == null ? 0 : ((BigDecimal) fila[18])).intValue());
			wmsCinsDto.setPrePackUnits(((BigDecimal) fila[19] == null ? 0 : ((BigDecimal) fila[19])).intValue());
			wmsCinsDto.setOblpnTotal(((BigDecimal) fila[20] == null ? 0 : ((BigDecimal) fila[20])).intValue());
			wmsCinsDto.setActiveTotal(((BigDecimal) fila[21] == null ? 0 : ((BigDecimal) fila[21])).intValue());
			wmsCinsDto.setActiveAllocated(((BigDecimal) fila[22] == null ? 0 : ((BigDecimal) fila[22])).intValue());
			wmsCinsDto.setActiveAllocatedLockcode(
					((BigDecimal) fila[23] == null ? 0 : ((BigDecimal) fila[23])).intValue());
			wmsCinsDto.setActiveAvailable(((BigDecimal) fila[24] == null ? 0 : ((BigDecimal) fila[24])).intValue());
			wmsCinsDto.setActiveLockcode(((BigDecimal) fila[25] == null ? 0 : ((BigDecimal) fila[25])).intValue());
			wmsCinsDto.setIblpnTotal(((BigDecimal) fila[26] == null ? 0 : ((BigDecimal) fila[26])).intValue());
			wmsCinsDto.setIblpnAllocated(((BigDecimal) fila[27] == null ? 0 : ((BigDecimal) fila[27])).intValue());
			wmsCinsDto.setIblpnAllocatedLockcode(
					((BigDecimal) fila[28] == null ? 0 : ((BigDecimal) fila[28])).intValue());

			wmsCinsDto.setIblpnAvailable(((BigDecimal) fila[29] == null ? 0 : ((BigDecimal) fila[29])).intValue());
			wmsCinsDto.setIblpnNotverified(((BigDecimal) fila[30] == null ? 0 : ((BigDecimal) fila[30])).intValue());
			wmsCinsDto.setIblpnLockcode(((BigDecimal) fila[31] == null ? 0 : ((BigDecimal) fila[31])).intValue());
			wmsCinsDto.setIblpnLost(((BigDecimal) fila[32] == null ? 0 : ((BigDecimal) fila[32])).intValue());
			wmsCinsDto.setTotalAllocated(((BigDecimal) fila[33] == null ? 0 : ((BigDecimal) fila[33])).intValue());
			wmsCinsDto.setTotalAvailable(((BigDecimal) fila[34] == null ? 0 : ((BigDecimal) fila[34])).intValue());
			wmsCinsDto.setTotalInventory(((BigDecimal) fila[35] == null ? 0 : ((BigDecimal) fila[35])).intValue());
			wmsCinsDto.setFourWallInventory(((BigDecimal) fila[36] == null ? 0 : ((BigDecimal) fila[36])).intValue());
			wmsCinsDto.setOpenOrderQty(((BigDecimal) fila[37] == null ? 0 : ((BigDecimal) fila[37])).intValue());

			wmsCinsDto.setLockCode1((String) fila[38]);

			wmsCinsDto.setLockCodeQty1(((BigDecimal) fila[39] == null ? 0 : ((BigDecimal) fila[39])).intValue());
			wmsCinsDto.setLockCode2((String) fila[40]);

			wmsCinsDto.setLockCodeQty2(((BigDecimal) fila[41] == null ? 0 : ((BigDecimal) fila[41])).intValue());
			wmsCinsDto.setLockCode3((String) fila[42]);

			wmsCinsDto.setLockCodeQty3(((BigDecimal) fila[43] == null ? 0 : ((BigDecimal) fila[43])).intValue());
			wmsCinsDto.setLockCode4((String) fila[44]);

			wmsCinsDto.setLockCodeQty4(((BigDecimal) fila[45] == null ? 0 : ((BigDecimal) fila[45])).intValue());
			wmsCinsDto.setLockCode5((String) fila[46]);

			wmsCinsDto.setLockCodeQty5(((BigDecimal) fila[47] == null ? 0 : ((BigDecimal) fila[47])).intValue());

			wmsCinsDto.setLockCode6((String) fila[48]);
			wmsCinsDto.setLockCodeQty6(((BigDecimal) fila[49] == null ? 0 : ((BigDecimal) fila[49])).intValue());

			wmsCinsDto.setLockCode7((String) fila[50]);
			wmsCinsDto.setLockCodeQty7(((BigDecimal) fila[51] == null ? 0 : ((BigDecimal) fila[51])).intValue());

			wmsCinsDto.setLockCode8((String) fila[52]);
			wmsCinsDto.setLockCodeQty8(((BigDecimal) fila[53] == null ? 0 : ((BigDecimal) fila[53])).intValue());

			wmsCinsDto.setLockCode9((String) fila[54]);
			wmsCinsDto.setLockCodeQty9(((BigDecimal) fila[55] == null ? 0 : ((BigDecimal) fila[55])).intValue());

			wmsCinsDto.setLockCode10((String) fila[56]);
			wmsCinsDto.setLockCodeQty10(((BigDecimal) fila[57] == null ? 0 : ((BigDecimal) fila[57])).intValue());
			
		
			if (fila[58] != null) {
				 date = formatter.parse( fila[58].toString());
			}			
			wmsCinsDto.setDownloadDate1(date);

			wmsCinsDto.setErrorCode(((BigDecimal) fila[59] == null ? 0 : ((BigDecimal) fila[59])).intValue());
	
			wmsCinsDto.setObservacionError((String) fila[60]);
			
			
			if (fila[61] != null ) {
				 //  BigDecimal b = new BigDecimal(fila[61].toString());				   
				wmsCinsDto.setFlgTipo(Integer.valueOf(fila[61].toString()));
			}else {
				wmsCinsDto.setFlgTipo(null);
			}
			
					
	
			listConciliaPf.add(wmsCinsDto);
		}
		LOGGER.info(" fin wmsCinsRepository "+listConciliaPf.size());
		return listConciliaPf;
	}
	
	@Override
	public List<WmsCinsDto> findAllxNroCargaWMSWmsCins(Integer nroCarga) throws Exception {
		// TODO Auto-generated method stub
		WmsCinsDto wmsCinsDto = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		LOGGER.info(" inicio nroCarga "+nroCarga);
		List<Object[]> list = wmsCinsRepository.findAllxNroCargaWMSWmsCins(nroCarga);
		
		List<WmsCinsDto> listConciliaPf = new ArrayList<WmsCinsDto>();
		
		Date date  = null;
		
		for (Object[] fila : list) {
			wmsCinsDto = new WmsCinsDto();
			LOGGER.info(" inicio list "+list.size());
		
			wmsCinsDto.setNroCarga(((BigDecimal) fila[0] == null ? 0 : ((BigDecimal) fila[0])).longValue());
			wmsCinsDto.setCreateDate((String) fila[1]);
			wmsCinsDto.setFacilityCode((String) fila[2]);
			wmsCinsDto.setCompanyCode((String) fila[3]);
			wmsCinsDto.setItemAlternate((String) fila[4]);
			wmsCinsDto.setItemPartA((String) fila[5]);
			wmsCinsDto.setItemPartB((String) fila[6]);
			wmsCinsDto.setItemPartC((String) fila[7]);
			wmsCinsDto.setItemPartD((String) fila[8]);
			wmsCinsDto.setItemPartE((String) fila[9]);
			wmsCinsDto.setItemPartF((String) fila[10]);
			wmsCinsDto.setHierarchy1Code((String) fila[11]);
			wmsCinsDto.setHierarchy2Code((String) fila[12]);
			wmsCinsDto.setHierarchy3Code((String) fila[13]);
			wmsCinsDto.setHierarchy4Code((String) fila[14]);

			wmsCinsDto.setHierarchy5Code((String) fila[15]);
			wmsCinsDto.setBatchNbr((String) fila[16]);
			wmsCinsDto.setPrePackCode((String) fila[17]);
			wmsCinsDto.setPrePackRatio(((BigDecimal) fila[18] == null ? 0 : ((BigDecimal) fila[18])).intValue());
			wmsCinsDto.setPrePackUnits(((BigDecimal) fila[19] == null ? 0 : ((BigDecimal) fila[19])).intValue());
			wmsCinsDto.setOblpnTotal(((BigDecimal) fila[20] == null ? 0 : ((BigDecimal) fila[20])).intValue());
			wmsCinsDto.setActiveTotal(((BigDecimal) fila[21] == null ? 0 : ((BigDecimal) fila[21])).intValue());
			wmsCinsDto.setActiveAllocated(((BigDecimal) fila[22] == null ? 0 : ((BigDecimal) fila[22])).intValue());
			wmsCinsDto.setActiveAllocatedLockcode(
					((BigDecimal) fila[23] == null ? 0 : ((BigDecimal) fila[23])).intValue());
			wmsCinsDto.setActiveAvailable(((BigDecimal) fila[24] == null ? 0 : ((BigDecimal) fila[24])).intValue());
			wmsCinsDto.setActiveLockcode(((BigDecimal) fila[25] == null ? 0 : ((BigDecimal) fila[25])).intValue());
			wmsCinsDto.setIblpnTotal(((BigDecimal) fila[26] == null ? 0 : ((BigDecimal) fila[26])).intValue());
			wmsCinsDto.setIblpnAllocated(((BigDecimal) fila[27] == null ? 0 : ((BigDecimal) fila[27])).intValue());
			wmsCinsDto.setIblpnAllocatedLockcode(
					((BigDecimal) fila[28] == null ? 0 : ((BigDecimal) fila[28])).intValue());

			wmsCinsDto.setIblpnAvailable(((BigDecimal) fila[29] == null ? 0 : ((BigDecimal) fila[29])).intValue());
			wmsCinsDto.setIblpnNotverified(((BigDecimal) fila[30] == null ? 0 : ((BigDecimal) fila[30])).intValue());
			wmsCinsDto.setIblpnLockcode(((BigDecimal) fila[31] == null ? 0 : ((BigDecimal) fila[31])).intValue());
			wmsCinsDto.setIblpnLost(((BigDecimal) fila[32] == null ? 0 : ((BigDecimal) fila[32])).intValue());
			wmsCinsDto.setTotalAllocated(((BigDecimal) fila[33] == null ? 0 : ((BigDecimal) fila[33])).intValue());
			wmsCinsDto.setTotalAvailable(((BigDecimal) fila[34] == null ? 0 : ((BigDecimal) fila[34])).intValue());
			wmsCinsDto.setTotalInventory(((BigDecimal) fila[35] == null ? 0 : ((BigDecimal) fila[35])).intValue());
			wmsCinsDto.setFourWallInventory(((BigDecimal) fila[36] == null ? 0 : ((BigDecimal) fila[36])).intValue());
			wmsCinsDto.setOpenOrderQty(((BigDecimal) fila[37] == null ? 0 : ((BigDecimal) fila[37])).intValue());

			wmsCinsDto.setLockCode1((String) fila[38]);

			wmsCinsDto.setLockCodeQty1(((BigDecimal) fila[39] == null ? 0 : ((BigDecimal) fila[39])).intValue());
			wmsCinsDto.setLockCode2((String) fila[40]);

			wmsCinsDto.setLockCodeQty2(((BigDecimal) fila[41] == null ? 0 : ((BigDecimal) fila[41])).intValue());
			wmsCinsDto.setLockCode3((String) fila[42]);

			wmsCinsDto.setLockCodeQty3(((BigDecimal) fila[43] == null ? 0 : ((BigDecimal) fila[43])).intValue());
			wmsCinsDto.setLockCode4((String) fila[44]);

			wmsCinsDto.setLockCodeQty4(((BigDecimal) fila[45] == null ? 0 : ((BigDecimal) fila[45])).intValue());
			wmsCinsDto.setLockCode5((String) fila[46]);

			wmsCinsDto.setLockCodeQty5(((BigDecimal) fila[47] == null ? 0 : ((BigDecimal) fila[47])).intValue());

			wmsCinsDto.setLockCode6((String) fila[48]);
			wmsCinsDto.setLockCodeQty6(((BigDecimal) fila[49] == null ? 0 : ((BigDecimal) fila[49])).intValue());

			wmsCinsDto.setLockCode7((String) fila[50]);
			wmsCinsDto.setLockCodeQty7(((BigDecimal) fila[51] == null ? 0 : ((BigDecimal) fila[51])).intValue());

			wmsCinsDto.setLockCode8((String) fila[52]);
			wmsCinsDto.setLockCodeQty8(((BigDecimal) fila[53] == null ? 0 : ((BigDecimal) fila[53])).intValue());

			wmsCinsDto.setLockCode9((String) fila[54]);
			wmsCinsDto.setLockCodeQty9(((BigDecimal) fila[55] == null ? 0 : ((BigDecimal) fila[55])).intValue());

			wmsCinsDto.setLockCode10((String) fila[56]);
			wmsCinsDto.setLockCodeQty10(((BigDecimal) fila[57] == null ? 0 : ((BigDecimal) fila[57])).intValue());
			
		
			if (fila[58] != null) {
				 date = formatter.parse( fila[58].toString());
			}			
			wmsCinsDto.setDownloadDate1(date);

			wmsCinsDto.setErrorCode(((BigDecimal) fila[59] == null ? 0 : ((BigDecimal) fila[59])).intValue());
	
			wmsCinsDto.setObservacionError((String) fila[60]);
			
			
			if (fila[61] != null ) {
				 //  BigDecimal b = new BigDecimal(fila[61].toString());				   
				wmsCinsDto.setFlgTipo(Integer.valueOf(fila[61].toString()));
			}else {
				wmsCinsDto.setFlgTipo(null);
			}
			
					
	
			listConciliaPf.add(wmsCinsDto);
		}
		LOGGER.info(" fin wmsCinsRepository "+listConciliaPf.size());
		return listConciliaPf;
	}
	
	@Override
	public List<WmsCinsCDDto> getCDFotoWms(){
		List<Object[]> listObject = wmsCinsRepository.getCDFotoWms();
		WmsCinsCDDto comboDTO;
		List<WmsCinsCDDto> listReturn = new ArrayList<WmsCinsCDDto>();
		for (Object[] row : listObject) {
			LOGGER.info("cast tamaño ");
			comboDTO = new WmsCinsCDDto();
			comboDTO.setIdCD( row[0]== null ? "": row[0].toString()  );
			comboDTO.setNumRegistros((row[1]== null ? BigDecimal.ZERO: (BigDecimal)row[1]).intValue());
			listReturn.add(comboDTO);
		}
		return listReturn;
	}
	
	@Override
	public List<WmsCinsCDDto> getFechaHoraFotoWms(String idCD){
		List<Object[]> listObject = wmsCinsRepository.getFechaHoraFotoWms(idCD);
		WmsCinsCDDto comboDTO;
		List<WmsCinsCDDto> listReturn = new ArrayList<WmsCinsCDDto>();
		for (Object[] row : listObject) {
			LOGGER.info("cast tamaño fecha hora ");
			comboDTO = new WmsCinsCDDto();
			comboDTO.setFechaHora( row[0]== null ? "" :row[0].toString()  );
		
			listReturn.add(comboDTO);
		}
		return listReturn;
	}
	
	@Override
	public List<WmsCinsCDDto> getCDXFechaHoraFotoWms() {
		List<Object[]> listObject = wmsCinsRepository.getCDXFechaHoraFotoWms();
		WmsCinsCDDto comboDTO;
		List<WmsCinsCDDto> listReturn = new ArrayList<WmsCinsCDDto>();
		for (Object[] row : listObject) {
			LOGGER.info("cast tamaño fecha hora ");
			comboDTO = new WmsCinsCDDto();
			comboDTO.setIdCD(row[0]== null ? "": row[0].toString()  );
			comboDTO.setFechaHora( row[1]== null ? "" :row[1].toString()  );
		
			listReturn.add(comboDTO);
		}
		return listReturn;
	}
	
	@Override
	public List<WmsCinsCDDto> getNroCargaFotoWms(String idCD){
		List<Object[]> listObject = wmsCinsRepository.getNroCargaFotoWms(idCD);
		WmsCinsCDDto comboDTO;
		List<WmsCinsCDDto> listReturn = new ArrayList<WmsCinsCDDto>();
		for (Object[] row : listObject) {
			LOGGER.info("cast tamaño fecha hora ");
			comboDTO = new WmsCinsCDDto();
			comboDTO.setNroCarga( row[0]== null ? null :Integer.parseInt( row[0].toString()  ));
		
			listReturn.add(comboDTO);
		}
		return listReturn;
	}

}
