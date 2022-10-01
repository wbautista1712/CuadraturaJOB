package com.cuadratura.app.oracle.repository.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.dto.TblStateChargeDto;
import com.cuadratura.app.oracle.repository.TblStateChargeRepositoryCustom;

@Repository
public class TblStateChargeRepositoryImpl implements TblStateChargeRepositoryCustom {
	private static final Logger LOGGER = LogManager.getLogger(TblStateChargeRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbctemplateOne")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TblStateChargeDto> getFindAllTblStateCharge() {

		String sql = "	SELECT  /*+ ALL_ROWS */  DISTINCT id_state_charge,		"
				+ "	                load_table,		" + "	                state_charge,		"
				+ "	                state_send,		" + "	                init_count_source,		"
				+ "	                init_sum_source,		" + "	                end_count_target,		"
				+ "	                end_count_source,		" + "	                end_sum_target,		"
				+ "	                error_des,		" + "	                load_date,		"
				+ "	                init_load,		" + "	                end_load,		"
				+ "	                y.org_lvl_child		" + "	  FROM cuadraturawyp.tbl_state_charge x,		"
				+ "	       cuadraturawyp.tbl_hst_ft_fapinvbalee y		"
				+ "	 WHERE     x.id_state_charge = y.audit_number		" + "	       AND x.load_table = 'HS'		"
				+ "	       AND x.state_send = 1		";

		LOGGER.info(sql);

		return jdbcTemplate.query(sql, (rs, rowNum) -> new TblStateChargeDto(rs.getBigDecimal("id_state_charge"),
				rs.getString("load_table"), rs.getString("state_charge"), rs.getString("state_send"),
				rs.getInt("init_count_source"), rs.getBigDecimal("init_sum_source"), rs.getInt("end_count_target"),
				rs.getInt("end_count_source"), rs.getBigDecimal("end_sum_target"), rs.getString("error_des"),
				rs.getDate("load_date"), rs.getDate("init_load"), rs.getDate("end_load"), rs.getLong("org_lvl_child")));
	}

	public void updateTblStateCharge(Integer idStateCharge) {
		String updateQuery = "UPDATE cuadraturawyp.tbl_state_charge x " + "   SET x.state_send = 0 "
				+ " WHERE x.id_state_charge = ? ";

		this.jdbcTemplate.update(updateQuery, idStateCharge);
	}
}
