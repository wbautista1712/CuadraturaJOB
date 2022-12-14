package com.cuadratura.app.mysql.repository;

import java.sql.SQLException;
import java.util.List;

import com.cuadratura.app.mysql.entity.TblPmm;
import com.cuadratura.app.oracle.dto.TblHstFtFapinvbaleeDto;
import com.cuadratura.app.oracle.entity.Fapinvbalee;

public interface TblPmmRepositoryCustom {
	public void saveTblPmm(Fapinvbalee obj, int idCargaPMM) throws SQLException;
	public void saveTblPmmBatch(List<Fapinvbalee> listaTblPmmForm, int numeroLotes, int idCargaPMM) throws SQLException;
	
	public void saveTblPmmJob(TblPmm obj, int idCargaPMM) throws SQLException;
}
