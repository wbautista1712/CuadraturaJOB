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

import com.cuadratura.app.oracle.repository.FapprdloteeRepositoryCustom;
import com.cuadratura.app.util.Constantes;

@Repository
@Transactional
public class FapprdloteeRepositoryImpl implements FapprdloteeRepositoryCustom {
	private static final Logger LOGGER = LogManager.getLogger(FapprdloteeRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbctemplateOne")
	private JdbcTemplate jdbcTemplate;

	@Override
	public String findFapprdlotee(Integer cd, String numeroLote) throws SQLException {
		LOGGER.info("cd " + cd);
		LOGGER.info("numeroLote " + numeroLote);

		DataSource ds = jdbcTemplate.getDataSource();
		Connection conn = null;
		CallableStatement csmt = null;
		// TODO Auto-generated method stub
		LOGGER.info(this.getClass().getName() + "." + new Exception().getStackTrace()[0].getMethodName());

		String resultado = "";
		try {
			conn = ds.getConnection();
			csmt = conn.prepareCall("{? = call cuadraturawyp.pkg_cuadratura.get_lote_fecha_vcto(?,?)}");
			csmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			csmt.setInt(2, cd);
			csmt.setString(3, numeroLote);

			csmt.execute();
			resultado = csmt.getString(1);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.error("Error: ", ex);
			resultado = Constantes.MENSAJE_ERROR_STORE_FUNCTION;
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
