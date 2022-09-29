package com.cuadratura.app.service;

import java.sql.SQLException;
import java.util.List;

import com.cuadratura.app.mysql.entity.TblPmm;
import com.cuadratura.app.oracle.entity.Fapinvbalee;

public interface TblPmmService  extends GenericService<TblPmm, Integer> {
	void saveTblPmm(List<Fapinvbalee> listaTblPmmForm, int idCargaPMM) throws SQLException ;
}
