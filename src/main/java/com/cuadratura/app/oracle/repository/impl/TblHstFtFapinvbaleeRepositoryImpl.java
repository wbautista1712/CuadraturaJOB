package com.cuadratura.app.oracle.repository.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.dto.TblHstFtFapinvbaleeDto;
import com.cuadratura.app.oracle.repository.TblHstFtFapinvbaleeRepositoryCustom;

@Repository
public class TblHstFtFapinvbaleeRepositoryImpl implements TblHstFtFapinvbaleeRepositoryCustom {

	private static final Logger LOGGER = LogManager.getLogger(TblStateChargeRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbctemplateOne")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TblHstFtFapinvbaleeDto> listTblHstFtFapinvbalee(Integer idStateCharge) {
		// TODO Auto-generated method stub
		String sql = "SELECT /*+ ALL_ROWS */ * FROM CUADRATURAWYP.TBL_HST_FT_FAPINVBALEE  x WHERE x.audit_number = "+idStateCharge;
		LOGGER.info(sql);
		return jdbcTemplate.query(sql, (rs, rowNum) -> new TblHstFtFapinvbaleeDto(

				rs.getLong("audit_number"), rs.getLong("org_lvl_child"), rs.getLong("org_lvl_number"),

				rs.getString("org_name_full"), rs.getLong("prd_lvl_child"), rs.getString("prd_lvl_number"),
				rs.getString("prd_name_full"), rs.getString("inv_type_code"),

				rs.getString("inv_type_desc"), rs.getString("trans_lote"), rs.getBigDecimal("on_hand_qty"),
				rs.getBigDecimal("on_hand_retl"), rs.getBigDecimal("on_hand_cost"),

				rs.getBigDecimal("po_ord_qty"), rs.getBigDecimal("po_ord_retl"), rs.getBigDecimal("po_ord_cost"),
				rs.getBigDecimal("po_intrn_qty"),

				rs.getBigDecimal("po_intrn_retl"), rs.getBigDecimal("po_intrn_cost"), rs.getBigDecimal("to_ord_qty"),
				rs.getBigDecimal("to_ord_retl"),

				rs.getBigDecimal("to_ord_cost"), rs.getBigDecimal("to_intrn_qty"), rs.getBigDecimal("to_intrn_retl"),
				rs.getBigDecimal("to_intrn_cost"),

				rs.getDate("first_pis_date"), rs.getDate("last_pis_date"), rs.getBigDecimal("ltd_qty"),
				rs.getBigDecimal("ltd_retl"), rs.getBigDecimal("ltd_cost"),

				rs.getDate("last_chg_date"), rs.getBigDecimal("on_hand_weight"), rs.getString("weight_uom"),
				rs.getBigDecimal("po_ord_weight"),

				rs.getBigDecimal("po_intrn_weight"), rs.getBigDecimal("to_ord_weight"),
				rs.getBigDecimal("to_intrn_weight"), rs.getBigDecimal("ltd_weight"),

				rs.getString("prd_sll_uom"), rs.getString("curr_code"), rs.getBigDecimal("on_hand_eaches"),
				rs.getDate("first_shipped_date"), rs.getDate("first_sales_date"),

				rs.getBigDecimal("on_hand_cost_hm"), rs.getBigDecimal("on_hand_retl_hm"),
				rs.getBigDecimal("to_intrn_cost_hm"), rs.getBigDecimal("to_intrn_retl_hm"),

				rs.getDate("trans_vcto_lote"), rs.getDate("date_load"), rs.getDate("date_create"),
				rs.getString("status")

		));
	}

}
