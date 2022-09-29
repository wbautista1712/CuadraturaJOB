package com.cuadratura.app.service;

import java.sql.SQLException;

import com.cuadratura.app.oracle.entity.CuadraturaTransfer;

public interface CuadraturaTransferService {
	public Long getSequence();

	public void saveCuadraturaTransferService(CuadraturaTransfer cuadraturaTransfer)throws SQLException;

	public void spCuadraturaTransfer(int idSesion) throws SQLException;
}
