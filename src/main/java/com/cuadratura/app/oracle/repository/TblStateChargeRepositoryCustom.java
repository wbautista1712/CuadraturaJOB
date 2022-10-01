package com.cuadratura.app.oracle.repository;

import java.util.List;

import com.cuadratura.app.oracle.dto.TblStateChargeDto;
import com.cuadratura.app.oracle.entity.TblStateCharge;

public interface TblStateChargeRepositoryCustom {
	public List<TblStateChargeDto> getFindAllTblStateCharge();
	
	public void  updateTblStateCharge(Integer idStateCharge);
}
