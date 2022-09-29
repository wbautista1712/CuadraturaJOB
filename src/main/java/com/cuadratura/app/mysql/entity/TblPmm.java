/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuadratura.app.mysql.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ARANGO
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_pmm", schema = "cuadratura")

public class TblPmm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idTbl_PMM")
	private Integer idTblPMM;
	
	@Basic(optional = false)
	@Column(name = "org_lvl_child")
	private Integer orgLvlChild;
	@Basic(optional = false)
	@Column(name = "trans_lote")
	private String transLote;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "on_hand_qty")
	private BigDecimal onHandQty;
	@Column(name = "on_hand_retl")
	private BigDecimal onHandRetl;
	@Column(name = "on_hand_cost")
	private BigDecimal onHandCost;
	@Column(name = "po_ord_qty")
	private BigDecimal poOrdQty;
	@Column(name = "po_ord_retl")
	private BigDecimal poOrdRetl;
	@Column(name = "po_ord_cost")
	private BigDecimal poOrdCost;
	@Column(name = "po_intrn_qty")
	private BigDecimal poIntrnQty;
	@Column(name = "po_intrn_retl")
	private BigDecimal poIntrnRetl;
	@Column(name = "po_intrn_cost")
	private BigDecimal poIntrnCost;
	@Column(name = "to_ord_qty")
	private BigDecimal toOrdQty;
	@Column(name = "to_ord_retl")
	private BigDecimal toOrdRetl;
	@Column(name = "to_ord_cost")
	private BigDecimal toOrdCost;
	@Column(name = "to_intrn_qty")
	private BigDecimal toIntrnQty;
	@Column(name = "to_intrn_retl")
	private BigDecimal toIntrnRetl;
	@Column(name = "to_intrn_cost")
	private BigDecimal toIntrnCost;
	@Column(name = "first_pis_date")
	private Date firstPisDate;
	@Column(name = "last_pis_date")
	private Date lastPisDate;
	@Column(name = "ltd_qty")
	private BigDecimal ltdQty;
	@Column(name = "ltd_retl")
	private BigDecimal ltdRetl;
	@Column(name = "ltd_cost")
	private BigDecimal ltdCost;
	@Column(name = "last_chg_date")
	private Date lastChgDate;
	@Column(name = "on_hand_weight")
	private BigDecimal onHandWeight;
	@Column(name = "weight_uom")
	private String weightUom;
	@Column(name = "po_ord_weight")
	private BigDecimal poOrdWeight;
	@Column(name = "po_intrn_weight")
	private BigDecimal poIntrnWeight;
	@Column(name = "to_ord_weight")
	private BigDecimal toOrdWeight;
	@Column(name = "to_intrn_weight")
	private BigDecimal toIntrnWeight;
	@Column(name = "ltd_weight")
	private BigDecimal ltdWeight;
	@Column(name = "prd_sll_uom")
	private String prdSllUom;
	@Column(name = "curr_code")
	private String currCode;
	@Column(name = "on_hand_eaches")
	private BigDecimal onHandEaches;
	@Column(name = "first_shipped_date")
	@Temporal(TemporalType.DATE)
	private Date firstShippedDate;
	@Column(name = "first_sales_date")
	@Temporal(TemporalType.DATE)
	private Date firstSalesDate;
	@Column(name = "on_hand_cost_hm")
	private BigDecimal onHandCostHm;
	@Column(name = "on_hand_retl_hm")
	private BigDecimal onHandRetlHm;
	@Column(name = "to_intrn_cost_hm")
	private BigDecimal toIntrnCostHm;
	@Column(name = "to_intrn_retl_hm")
	private BigDecimal toIntrnRetlHm;
	@Column(name = "trans_vcto_lote")
	@Temporal(TemporalType.DATE)
	private Date transVctoLote;
	
	@Column(name = "prd_lvl_child")
	private Integer prdLvlChild;
	
	@Column(name = "inv_type_code")
	private String invTypeCode;

	@Column(name = "idCarga_PMM")	
	private Integer idCargaPMM;

}
