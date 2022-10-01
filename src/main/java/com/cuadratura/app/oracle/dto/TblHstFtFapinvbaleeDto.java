package com.cuadratura.app.oracle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;

public class TblHstFtFapinvbaleeDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long auditNumber;
	private Long orgLvlChild;
	private Long orgLvlNumber;
	private String orgNameFull;
	private Long prdLvlChild;
	private String prdLvlNumber;
	private String prdNameFull;
	private String invTypeCode;
	private String invTypeDesc;
	private String transLote;
	private BigDecimal onHandQty;
	private BigDecimal onHandRetl;
	private BigDecimal onHandCost;
	private BigDecimal poOrdQty;

	private BigDecimal poOrdRetl;
	private BigDecimal poOrdCost;

	private BigDecimal poIntrnQty;
	private BigDecimal poIntrnRetl;
	private BigDecimal poIntrnCost;
	private BigDecimal toOrdQty;
	private BigDecimal toOrdRetl;
	private BigDecimal toOrdCost;
	private BigDecimal toIntrnQty;
	private BigDecimal toIntrnRetl;
	private BigDecimal toIntrnCost;

	private Date firstPisDate;

	private Date lastPisDate;
	private BigDecimal ltdQty;
	private BigDecimal ltdRetl;
	private BigDecimal ltdCost;

	private Date lastChgDate;

	private BigDecimal onHandWeight;
	private String weightUom;
	private BigDecimal poOrdWeight;
	private BigDecimal poIntrnWeight;

	private BigDecimal toOrdWeight;
	private BigDecimal toIntrnWeight;
	private BigDecimal ltdWeight;

	private String prdSllUom;
	private String currCode;
	private BigDecimal onHandEaches;
	private Date firstShippedDate;
	private Date firstSalesDate;
	private BigDecimal onHandCostHm;
	private BigDecimal onHandRetlHm;

	private BigDecimal toIntrnCostHm;

	private BigDecimal toIntrnRetlHm;
	private Date transVctoLote;
	private Date dateLoad;
	private Date dateCreate;
	private String status;

	public TblHstFtFapinvbaleeDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public TblHstFtFapinvbaleeDto(Long auditNumber, Long orgLvlChild, Long orgLvlNumber,
			String orgNameFull, Long prdLvlChild, String prdLvlNumber, String prdNameFull, String invTypeCode,
			String invTypeDesc, String transLote, BigDecimal onHandQty, BigDecimal onHandRetl, BigDecimal onHandCost,
			
			BigDecimal poOrdQty, BigDecimal poOrdRetl, BigDecimal poOrdCost, BigDecimal poIntrnQty,
			BigDecimal poIntrnRetl, BigDecimal poIntrnCost, BigDecimal toOrdQty, BigDecimal toOrdRetl,			
			BigDecimal toOrdCost, BigDecimal toIntrnQty, BigDecimal toIntrnRetl, BigDecimal toIntrnCost,
			
			Date firstPisDate, Date lastPisDate, BigDecimal ltdQty, BigDecimal ltdRetl, BigDecimal ltdCost,
			
			Date lastChgDate, BigDecimal onHandWeight, String weightUom, BigDecimal poOrdWeight,
			
			BigDecimal poIntrnWeight, BigDecimal toOrdWeight, BigDecimal toIntrnWeight, BigDecimal ltdWeight,
			
			String prdSllUom, String currCode, BigDecimal onHandEaches, Date firstShippedDate, Date firstSalesDate,
			
			BigDecimal onHandCostHm, BigDecimal onHandRetlHm, BigDecimal toIntrnCostHm, BigDecimal toIntrnRetlHm,
			Date transVctoLote, Date dateLoad, Date dateCreate, String status) {
		super();
		this.auditNumber = auditNumber;
		this.orgLvlChild = orgLvlChild;
		this.orgLvlNumber = orgLvlNumber;
		this.orgNameFull = orgNameFull;
		this.prdLvlChild = prdLvlChild;
		this.prdLvlNumber = prdLvlNumber;
		this.prdNameFull = prdNameFull;
		this.invTypeCode = invTypeCode;
		this.invTypeDesc = invTypeDesc;
		this.transLote = transLote;
		this.onHandQty = onHandQty;
		this.onHandRetl = onHandRetl;
		this.onHandCost = onHandCost;
		this.poOrdQty = poOrdQty;
		this.poOrdRetl = poOrdRetl;
		this.poOrdCost = poOrdCost;
		this.poIntrnQty = poIntrnQty;
		this.poIntrnRetl = poIntrnRetl;
		this.poIntrnCost = poIntrnCost;
		this.toOrdQty = toOrdQty;
		this.toOrdRetl = toOrdRetl;
		this.toOrdCost = toOrdCost;
		this.toIntrnQty = toIntrnQty;
		this.toIntrnRetl = toIntrnRetl;
		this.toIntrnCost = toIntrnCost;
		this.firstPisDate = firstPisDate;
		this.lastPisDate = lastPisDate;
		this.ltdQty = ltdQty;
		this.ltdRetl = ltdRetl;
		this.ltdCost = ltdCost;
		this.lastChgDate = lastChgDate;
		this.onHandWeight = onHandWeight;
		this.weightUom = weightUom;
		this.poOrdWeight = poOrdWeight;
		this.poIntrnWeight = poIntrnWeight;
		this.toOrdWeight = toOrdWeight;
		this.toIntrnWeight = toIntrnWeight;
		this.ltdWeight = ltdWeight;
		this.prdSllUom = prdSllUom;
		this.currCode = currCode;
		this.onHandEaches = onHandEaches;
		this.firstShippedDate = firstShippedDate;
		this.firstSalesDate = firstSalesDate;
		this.onHandCostHm = onHandCostHm;
		this.onHandRetlHm = onHandRetlHm;
		this.toIntrnCostHm = toIntrnCostHm;
		this.toIntrnRetlHm = toIntrnRetlHm;
		this.transVctoLote = transVctoLote;
		this.dateLoad = dateLoad;
		this.dateCreate = dateCreate;
		this.status = status;
	}




	public Long getAuditNumber() {
		return auditNumber;
	}

	public void setAuditNumber(Long auditNumber) {
		this.auditNumber = auditNumber;
	}

	public Long getOrgLvlChild() {
		return orgLvlChild;
	}

	public void setOrgLvlChild(Long orgLvlChild) {
		this.orgLvlChild = orgLvlChild;
	}

	public Long getOrgLvlNumber() {
		return orgLvlNumber;
	}

	public void setOrgLvlNumber(Long orgLvlNumber) {
		this.orgLvlNumber = orgLvlNumber;
	}

	public String getOrgNameFull() {
		return orgNameFull;
	}

	public void setOrgNameFull(String orgNameFull) {
		this.orgNameFull = orgNameFull;
	}

	public Long getPrdLvlChild() {
		return prdLvlChild;
	}

	public void setPrdLvlChild(Long prdLvlChild) {
		this.prdLvlChild = prdLvlChild;
	}

	public String getPrdLvlNumber() {
		return prdLvlNumber;
	}

	public void setPrdLvlNumber(String prdLvlNumber) {
		this.prdLvlNumber = prdLvlNumber;
	}

	public String getPrdNameFull() {
		return prdNameFull;
	}

	public void setPrdNameFull(String prdNameFull) {
		this.prdNameFull = prdNameFull;
	}

	public String getInvTypeCode() {
		return invTypeCode;
	}

	public void setInvTypeCode(String invTypeCode) {
		this.invTypeCode = invTypeCode;
	}

	public String getInvTypeDesc() {
		return invTypeDesc;
	}

	public void setInvTypeDesc(String invTypeDesc) {
		this.invTypeDesc = invTypeDesc;
	}

	public String getTransLote() {
		return transLote;
	}

	public void setTransLote(String transLote) {
		this.transLote = transLote;
	}

	public BigDecimal getOnHandQty() {
		return onHandQty;
	}

	public void setOnHandQty(BigDecimal onHandQty) {
		this.onHandQty = onHandQty;
	}

	public BigDecimal getOnHandRetl() {
		return onHandRetl;
	}

	public void setOnHandRetl(BigDecimal onHandRetl) {
		this.onHandRetl = onHandRetl;
	}

	public BigDecimal getOnHandCost() {
		return onHandCost;
	}

	public void setOnHandCost(BigDecimal onHandCost) {
		this.onHandCost = onHandCost;
	}

	public BigDecimal getPoOrdQty() {
		return poOrdQty;
	}

	public void setPoOrdQty(BigDecimal poOrdQty) {
		this.poOrdQty = poOrdQty;
	}

	public BigDecimal getPoOrdRetl() {
		return poOrdRetl;
	}

	public void setPoOrdRetl(BigDecimal poOrdRetl) {
		this.poOrdRetl = poOrdRetl;
	}

	public BigDecimal getPoOrdCost() {
		return poOrdCost;
	}

	public void setPoOrdCost(BigDecimal poOrdCost) {
		this.poOrdCost = poOrdCost;
	}

	public BigDecimal getPoIntrnQty() {
		return poIntrnQty;
	}

	public void setPoIntrnQty(BigDecimal poIntrnQty) {
		this.poIntrnQty = poIntrnQty;
	}

	public BigDecimal getPoIntrnRetl() {
		return poIntrnRetl;
	}

	public void setPoIntrnRetl(BigDecimal poIntrnRetl) {
		this.poIntrnRetl = poIntrnRetl;
	}

	public BigDecimal getPoIntrnCost() {
		return poIntrnCost;
	}

	public void setPoIntrnCost(BigDecimal poIntrnCost) {
		this.poIntrnCost = poIntrnCost;
	}

	public BigDecimal getToOrdQty() {
		return toOrdQty;
	}

	public void setToOrdQty(BigDecimal toOrdQty) {
		this.toOrdQty = toOrdQty;
	}

	public BigDecimal getToOrdRetl() {
		return toOrdRetl;
	}

	public void setToOrdRetl(BigDecimal toOrdRetl) {
		this.toOrdRetl = toOrdRetl;
	}

	public BigDecimal getToOrdCost() {
		return toOrdCost;
	}

	public void setToOrdCost(BigDecimal toOrdCost) {
		this.toOrdCost = toOrdCost;
	}

	public BigDecimal getToIntrnQty() {
		return toIntrnQty;
	}

	public void setToIntrnQty(BigDecimal toIntrnQty) {
		this.toIntrnQty = toIntrnQty;
	}

	public BigDecimal getToIntrnRetl() {
		return toIntrnRetl;
	}

	public void setToIntrnRetl(BigDecimal toIntrnRetl) {
		this.toIntrnRetl = toIntrnRetl;
	}

	public BigDecimal getToIntrnCost() {
		return toIntrnCost;
	}

	public void setToIntrnCost(BigDecimal toIntrnCost) {
		this.toIntrnCost = toIntrnCost;
	}

	public Date getFirstPisDate() {
		return firstPisDate;
	}

	public void setFirstPisDate(Date firstPisDate) {
		this.firstPisDate = firstPisDate;
	}

	public Date getLastPisDate() {
		return lastPisDate;
	}

	public void setLastPisDate(Date lastPisDate) {
		this.lastPisDate = lastPisDate;
	}

	public BigDecimal getLtdQty() {
		return ltdQty;
	}

	public void setLtdQty(BigDecimal ltdQty) {
		this.ltdQty = ltdQty;
	}

	public BigDecimal getLtdRetl() {
		return ltdRetl;
	}

	public void setLtdRetl(BigDecimal ltdRetl) {
		this.ltdRetl = ltdRetl;
	}

	public BigDecimal getLtdCost() {
		return ltdCost;
	}

	public void setLtdCost(BigDecimal ltdCost) {
		this.ltdCost = ltdCost;
	}

	public Date getLastChgDate() {
		return lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	public BigDecimal getOnHandWeight() {
		return onHandWeight;
	}

	public void setOnHandWeight(BigDecimal onHandWeight) {
		this.onHandWeight = onHandWeight;
	}

	public String getWeightUom() {
		return weightUom;
	}

	public void setWeightUom(String weightUom) {
		this.weightUom = weightUom;
	}

	public BigDecimal getPoOrdWeight() {
		return poOrdWeight;
	}

	public void setPoOrdWeight(BigDecimal poOrdWeight) {
		this.poOrdWeight = poOrdWeight;
	}

	public BigDecimal getPoIntrnWeight() {
		return poIntrnWeight;
	}

	public void setPoIntrnWeight(BigDecimal poIntrnWeight) {
		this.poIntrnWeight = poIntrnWeight;
	}

	public BigDecimal getToOrdWeight() {
		return toOrdWeight;
	}

	public void setToOrdWeight(BigDecimal toOrdWeight) {
		this.toOrdWeight = toOrdWeight;
	}

	public BigDecimal getToIntrnWeight() {
		return toIntrnWeight;
	}

	public void setToIntrnWeight(BigDecimal toIntrnWeight) {
		this.toIntrnWeight = toIntrnWeight;
	}

	public BigDecimal getLtdWeight() {
		return ltdWeight;
	}

	public void setLtdWeight(BigDecimal ltdWeight) {
		this.ltdWeight = ltdWeight;
	}

	public String getPrdSllUom() {
		return prdSllUom;
	}

	public void setPrdSllUom(String prdSllUom) {
		this.prdSllUom = prdSllUom;
	}

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	public BigDecimal getOnHandEaches() {
		return onHandEaches;
	}

	public void setOnHandEaches(BigDecimal onHandEaches) {
		this.onHandEaches = onHandEaches;
	}

	public Date getFirstShippedDate() {
		return firstShippedDate;
	}

	public void setFirstShippedDate(Date firstShippedDate) {
		this.firstShippedDate = firstShippedDate;
	}

	public Date getFirstSalesDate() {
		return firstSalesDate;
	}

	public void setFirstSalesDate(Date firstSalesDate) {
		this.firstSalesDate = firstSalesDate;
	}

	public BigDecimal getOnHandCostHm() {
		return onHandCostHm;
	}

	public void setOnHandCostHm(BigDecimal onHandCostHm) {
		this.onHandCostHm = onHandCostHm;
	}

	public BigDecimal getOnHandRetlHm() {
		return onHandRetlHm;
	}

	public void setOnHandRetlHm(BigDecimal onHandRetlHm) {
		this.onHandRetlHm = onHandRetlHm;
	}

	public BigDecimal getToIntrnCostHm() {
		return toIntrnCostHm;
	}

	public void setToIntrnCostHm(BigDecimal toIntrnCostHm) {
		this.toIntrnCostHm = toIntrnCostHm;
	}

	public BigDecimal getToIntrnRetlHm() {
		return toIntrnRetlHm;
	}

	public void setToIntrnRetlHm(BigDecimal toIntrnRetlHm) {
		this.toIntrnRetlHm = toIntrnRetlHm;
	}

	public Date getTransVctoLote() {
		return transVctoLote;
	}

	public void setTransVctoLote(Date transVctoLote) {
		this.transVctoLote = transVctoLote;
	}

	public Date getDateLoad() {
		return dateLoad;
	}

	public void setDateLoad(Date dateLoad) {
		this.dateLoad = dateLoad;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
