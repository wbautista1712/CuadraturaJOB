package com.cuadratura.app.oracle.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.repository.PrdpcdeeRepositoryCustom;

@Repository
@Transactional
public class PrdpcdeeRepositoryImpl implements PrdpcdeeRepositoryCustom {
	private static final Logger LOGGER = LogManager.getLogger(PrdpcdeeRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbctemplateOne")
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer findPrdpcdee(String numeroProd)  throws SQLException {
		LOGGER.info("findPrdpcdee numeroProd=== " + numeroProd);

		/*
		 * String sql = "SELECT i.Inner_Pack_Id   " +
		 * "  FROM pmm.prdpcdee i, pmm.prdmstee p " +
		 * " WHERE     i.prd_lvl_child = p.prd_lvl_child " +
		 * "       AND i.loose_pack_flag = 'F'  " +
		 * "       AND i.sll_units_per_inner = 1  " +
		 * "       AND i.inv_units_per_inner = 1 " + "       AND p.prd_lvl_number =  " +
		 * numeroProd+ "       AND ROWNUM = 1 "; return jdbcTemplate.query(sql, new
		 * ResultSetExtractor<Long>() {
		 * 
		 * @Override public Long extractData(ResultSet rs) throws SQLException,
		 * DataAccessException { return rs.next() ? rs.getLong("INNER_PACK_ID") : null;
		 * } });
		 */

		DataSource ds = jdbcTemplate.getDataSource();
		Connection conn = null;
		CallableStatement csmt = null;
		// TODO Auto-generated method stub
		LOGGER.info(this.getClass().getName() + "." + new Exception().getStackTrace()[0].getMethodName());

		Integer resultado = null;
		try {
			conn = ds.getConnection();
			csmt = conn.prepareCall("{? = call cuadraturawyp.pkg_cuadratura.get_inner_pack_id(?)}");
			csmt.registerOutParameter(1, java.sql.Types.NUMERIC);
			csmt.setString(2, numeroProd);

			csmt.execute();
			
			resultado = csmt.getInt(1);
			
			LOGGER.info("findPrdpcdee: innerPackId resultado=== " + resultado);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.error("Error: ", ex);
		
		} finally {
			if (csmt != null) {
				csmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return resultado;

	}
}
