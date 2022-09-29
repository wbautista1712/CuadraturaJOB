package com.cuadratura.app.oracle.repository;

import java.sql.SQLException;

public interface FapprdloteeRepositoryCustom {
	public String findFapprdlotee(Integer cd, String numeroLote) throws SQLException;
}
