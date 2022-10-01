package com.cuadratura.app.service;

import java.util.List;

import com.cuadratura.app.oracle.dto.TblStateChargeDto;

public interface TblStateChargeService {
	public List<TblStateChargeDto> getFindAllTblStateCharge();

	public void updateTblStateCharge(Integer idStateCharge);
}
