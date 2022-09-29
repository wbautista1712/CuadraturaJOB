package com.cuadratura.app.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.entity.TblPmm;
import com.cuadratura.app.mysql.repository.TblPmmRepository;
import com.cuadratura.app.oracle.entity.Fapinvbalee;
import com.cuadratura.app.oracle.entity.pk.FapinvbaleePK;
import com.cuadratura.app.service.TblPmmService;

@Service
public class TblPmmServiceImpl extends GenericServiceImpl<TblPmm, Integer> implements TblPmmService {
	private static final Logger LOGGER = LogManager.getLogger(TblPmmServiceImpl.class);

	@Autowired
	private TblPmmRepository tblPmmRepository;

	@Override
	public CrudRepository<TblPmm, Integer> getDao() {
		// TODO Auto-generated method stub
		return tblPmmRepository;
	}

	@Override
	public void saveTblPmm(List<Fapinvbalee> listaTblPmmForm, int idCargaPMM) throws SQLException {
		LOGGER.info("> listaTblPmmForm", listaTblPmmForm.size());
		Fapinvbalee statement = null;
		FapinvbaleePK id = null;
		for (Fapinvbalee obj : listaTblPmmForm) {
			statement = new Fapinvbalee();
			id = new FapinvbaleePK();
			// org_lvl_child, prd_lvl_child, inv_type_code, trans_lote, on_hand_qty,
			id.setOrgLvlChild(obj.getFapinvbaleePK().getOrgLvlChild());
			id.setPrdLvlChild((obj.getFapinvbaleePK().getPrdLvlChild()));
			id.setInvTypeCode(obj.getFapinvbaleePK().getInvTypeCode().trim());
			id.setTransLote(obj.getFapinvbaleePK().getTransLote().trim());

			statement.setFapinvbaleePK(id);
			statement.setOnHandQty(obj.getOnHandQty() == null ? BigDecimal.ZERO : obj.getOnHandQty());

			// on_hand_retl, on_hand_cost, po_ord_qty, po_ord_retl, po_ord_cost,
			statement.setOnHandRetl(obj.getOnHandRetl());
			statement.setOnHandCost(obj.getOnHandCost());
			statement.setPoOrdQty(obj.getPoOrdQty());
			statement.setPoOrdRetl(obj.getPoOrdRetl());
			statement.setPoOrdCost(obj.getPoOrdCost());

			// po_intrn_qty, po_intrn_retl, po_intrn_cost, to_ord_qty, to_ord_retl,
			statement.setPoIntrnQty(obj.getPoIntrnQty());
			statement.setPoIntrnRetl(obj.getPoIntrnRetl());
			statement.setPoIntrnCost(obj.getPoIntrnCost());
			statement.setToOrdQty(obj.getToOrdQty());
			statement.setToOrdRetl(obj.getToOrdRetl());

			// to_ord_cost, to_intrn_qty, to_intrn_retl, to_intrn_cost, first_pis_date,
			statement.setToOrdCost(obj.getToOrdCost());
			statement.setToIntrnQty(obj.getToIntrnQty());
			statement.setToIntrnRetl(obj.getToIntrnRetl());
			statement.setToIntrnCost(obj.getToIntrnCost());

			if (obj.getFirstPisDate() != null) {
				Date firstPisDate = new java.sql.Date(obj.getFirstPisDate().getTime());
				statement.setFirstPisDate((java.sql.Date) firstPisDate);
			} else {
				statement.setFirstPisDate(null);
			}

			// last_pis_date, ltd_qty, ltd_retl, ltd_cost, last_chg_date, on_hand_weight,

			if (obj.getLastPisDate() != null) {
				Date lastPisDate = new java.sql.Date(obj.getLastPisDate().getTime());
				statement.setLastPisDate((java.sql.Date) lastPisDate);
			} else {
				statement.setLastPisDate(null);
			}

			statement.setLtdQty(obj.getLtdQty());
			statement.setLtdRetl(obj.getLtdRetl());
			statement.setLtdCost(obj.getLtdCost());

			if (obj.getLastChgDate() != null) {
				Date lastChgDate = new java.sql.Date(obj.getLastChgDate().getTime());
				statement.setLastChgDate((java.sql.Date) lastChgDate);
			} else {
				statement.setLastChgDate(null);
			}

			statement.setOnHandWeight(obj.getOnHandWeight());

			// weight_uom, po_ord_weight, po_intrn_weight, to_ord_weight, to_intrn_weight,
			statement.setWeightUom(obj.getWeightUom().trim());
			statement.setPoOrdWeight(obj.getPoOrdWeight());
			statement.setPoIntrnWeight(obj.getPoIntrnWeight());
			statement.setToOrdWeight(obj.getToOrdWeight());
			statement.setToIntrnWeight(obj.getToIntrnWeight());

			// ltd_weight, prd_sll_uom, curr_code, on_hand_eaches, first_shipped_date,
			// first_sales_date,
			statement.setLtdWeight(obj.getLtdWeight());
			statement.setPrdSllUom(obj.getPrdSllUom().trim());
			statement.setCurrCode(obj.getCurrCode().trim());
			statement.setOnHandEaches(obj.getOnHandEaches());

			if (obj.getFirstShippedDate() != null) {
				Date firstShippedDate = new java.sql.Date(obj.getFirstShippedDate().getTime());
				statement.setFirstShippedDate((java.sql.Date) firstShippedDate);
			} else {
				statement.setFirstShippedDate(null);
			}

			if (obj.getFirstSalesDate() != null) {
				Date firstSalesDate = new java.sql.Date(obj.getFirstSalesDate().getTime());
				statement.setFirstSalesDate((java.sql.Date) firstSalesDate);
			} else {
				statement.setFirstSalesDate(null);
			}
			// on_hand_cost_hm, on_hand_retl_hm, to_intrn_cost_hm, to_intrn_retl_hm,
			// trans_vcto_lote, idCarga_PMM
			statement.setOnHandCostHm(obj.getOnHandCostHm());
			statement.setOnHandRetlHm(obj.getOnHandRetlHm());
			statement.setToIntrnCostHm(obj.getToIntrnCostHm());
			statement.setToIntrnRetlHm(obj.getToIntrnRetlHm());

			if (obj.getTransVctoLote() != null) {
				Date transVctoLote = new java.sql.Date(obj.getTransVctoLote().getTime());
				statement.setTransVctoLote((java.sql.Date) transVctoLote);
			} else {
				statement.setTransVctoLote(null);
			}

			this.tblPmmRepository.saveTblPmm(statement, idCargaPMM);
		}

	}

}
