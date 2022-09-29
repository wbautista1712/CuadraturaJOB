package com.cuadratura.app.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.entity.TblWms;
import com.cuadratura.app.mysql.repository.TblWmsRepository;
import com.cuadratura.app.oracle.dto.WmsCinsDto;
import com.cuadratura.app.service.TblWmsService;

@Service
public class TblWmsServiceImpl extends GenericServiceImpl<TblWms, Integer> implements TblWmsService {
	private static final Logger LOGGER = LogManager.getLogger(TblWmsServiceImpl.class);

	@Autowired
	private TblWmsRepository tblWmsRepository;

	@Override
	public CrudRepository<TblWms, Integer> getDao() {
		// TODO Auto-generated method stub
		return tblWmsRepository;
	}

	public void saveTblWms(List<WmsCinsDto> listaTblPmmForm, int idCargaWMS) throws SQLException {

		LOGGER.info("idCargaWMS " + idCargaWMS);
		WmsCinsDto statement = null;
		for (WmsCinsDto obj : listaTblPmmForm) {
			statement = new WmsCinsDto();
			// item_part_a,
			statement.setNroCarga(obj.getNroCarga());
			statement.setCreateDate(obj.getCreateDate().trim());
			statement.setFacilityCode(obj.getFacilityCode().trim());
			statement.setCompanyCode(obj.getCompanyCode().trim());
			statement.setItemAlternate(obj.getItemAlternate().trim());
			statement.setItemPartA(obj.getItemPartA().trim());

			// item_part_b, item_part_c, item_part_d, item_part_e, item_part_f,
			// hierarchy1_code,
			statement.setItemPartB(obj.getItemPartB().trim());
			statement.setItemPartC(obj.getItemPartC().trim());
			statement.setItemPartD(obj.getItemPartD().trim());
			statement.setItemPartE(obj.getItemPartE().trim());
			statement.setItemPartF(obj.getItemPartF().trim());
			statement.setHierarchy1Code(obj.getHierarchy1Code().trim());

			// hierarchy2_code, hierarchy3_code, hierarchy4_code, hierarchy5_code,
			// batch_nbr,
			statement.setHierarchy2Code(obj.getHierarchy2Code().trim());
			statement.setHierarchy3Code(obj.getHierarchy3Code().trim());
			statement.setHierarchy4Code(obj.getHierarchy4Code().trim());
			statement.setHierarchy5Code(obj.getHierarchy5Code().trim());
			statement.setBatchNbr(obj.getBatchNbr().trim());

			// pre_pack_code, tbl_wmscol, pre_pack_ratio, pre_pack_units, oblpn_total,
			// active_total,
			statement.setPrePackCode(obj.getPrePackCode().trim());
			statement.setTblWmscol(obj.getTblWmscol().trim());
			statement.setPrePackRatio(obj.getPrePackRatio());
			statement.setPrePackUnits(obj.getPrePackUnits());
			statement.setOblpnTotal(obj.getOblpnTotal());
			statement.setActiveTotal(obj.getActiveTotal());

			// active_allocated, active_allocated_lockcode, active_available,
			// active_lockcode, iblpn_total,
			statement.setActiveAllocated(obj.getActiveAllocated());
			statement.setActiveAllocatedLockcode(obj.getActiveAllocatedLockcode());
			statement.setActiveAvailable(obj.getActiveAvailable());
			statement.setActiveLockcode(obj.getActiveLockcode());
			statement.setIblpnTotal(obj.getIblpnTotal());

			// iblpn_allocated, iblpn_allocated_lockcode, iblpn_available,
			// iblpn_notverified, iblpn_lockcode,
			statement.setIblpnAllocated(obj.getIblpnAllocated());
			statement.setIblpnAllocatedLockcode(obj.getIblpnAllocatedLockcode());
			statement.setIblpnAvailable(obj.getIblpnAvailable());
			statement.setIblpnNotverified(obj.getIblpnNotverified());
			statement.setIblpnLockcode(obj.getIblpnLockcode());

			// iblpn_lost, total_allocated, total_available, total_inventory,
			// four_wall_inventory, open_order_qty,
			statement.setIblpnLost(obj.getIblpnLost());
			statement.setTotalAllocated(obj.getTotalAllocated());
			statement.setTotalAvailable(obj.getTotalAvailable());
			statement.setTotalInventory(obj.getTotalInventory());
			statement.setFourWallInventory(obj.getFourWallInventory());
			statement.setOpenOrderQty(obj.getOpenOrderQty());

			// lock_code_1, lock_code_qty_1, lock_code_2, lock_code_qty_2, lock_code_3,
			// lock_code_qty_3, lock_code_4,
			statement.setLockCode1(obj.getLockCode1().trim());
			statement.setLockCodeQty1(obj.getLockCodeQty1());
			statement.setLockCode2(obj.getLockCode2().trim());
			statement.setLockCodeQty2(obj.getLockCodeQty2());
			statement.setLockCode3(obj.getLockCode3().trim());
			statement.setLockCodeQty3(obj.getLockCodeQty3());
			statement.setLockCode4(obj.getLockCode4().trim());

			// lock_code_qty_4, lock_code_5, lock_code_qty_5, lock_code_6, lock_code_qty_6,
			// lock_code_7, lock_code_qty_7,
			statement.setLockCodeQty4(obj.getLockCodeQty4());
			statement.setLockCode5(obj.getLockCode5().trim());
			statement.setLockCodeQty5(obj.getLockCodeQty5());
			statement.setLockCode6(obj.getLockCode6().trim());
			statement.setLockCodeQty6(obj.getLockCodeQty6());
			statement.setLockCode7(obj.getLockCode7().trim());
			statement.setLockCodeQty7(obj.getLockCodeQty7());

			// lock_code_8, lock_code_qty_8, lock_code_9, lock_code_qty_9, lock_code_10,
			// lock_code_qty_10, download_date1,
			statement.setLockCode8(obj.getLockCode8().trim());
			statement.setLockCodeQty8(obj.getLockCodeQty8());
			statement.setLockCode9(obj.getLockCode9().trim());
			statement.setLockCodeQty9(obj.getLockCodeQty9());
			statement.setLockCode10(obj.getLockCode10().trim());
			statement.setLockCodeQty10(obj.getLockCodeQty10());

			if (obj.getDownloadDate1() != null) {
				Date downloadDate1 = new java.sql.Date(obj.getDownloadDate1().getTime());
				statement.setDownloadDate1((java.sql.Date) downloadDate1);
			} else {
				statement.setDownloadDate1(null);
			}

			/*
			 * error_code, observacion_error, flg_tipo, idCarga_WMS)
			 * 
			 */
			statement.setErrorCode(obj.getErrorCode());
			statement.setObservacionError(obj.getObservacionError().trim());

			if (obj.getFlgTipo() != null) {
				statement.setFlgTipo(obj.getFlgTipo().intValue());
			} else {
				statement.setFlgTipo(0);
			}

			// statement.setInt(64, idCargaWMS);// reecupera id

			this.tblWmsRepository.saveTblWms(statement, idCargaWMS);
		}
	}
	
	public void uploadTblWms(TblWms tblWms) throws SQLException {
		this.tblWmsRepository.uploadTblWms(tblWms);
	}
}
