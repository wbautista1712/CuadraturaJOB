package com.cuadratura.app.oracle.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cuadratura.app.oracle.entity.pk.InvbaleePK;

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
@Table(name = "INVBALEE", schema="PMM")
public class Invbalee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvbaleePK invbaleePK;
  
    @Column(name = "ON_HAND_QTY")
    private BigDecimal onHandQty;
    @Column(name = "ON_HAND_RETL")
    private BigDecimal onHandRetl;
    @Column(name = "ON_HAND_COST")
    private BigDecimal onHandCost;
    @Column(name = "PO_ORD_QTY")
    private BigDecimal poOrdQty;
    @Column(name = "PO_ORD_RETL")
    private BigDecimal poOrdRetl;
    @Column(name = "PO_ORD_COST")
    private BigDecimal poOrdCost;
    @Column(name = "PO_INTRN_QTY")
    private BigDecimal poIntrnQty;
    @Column(name = "PO_INTRN_RETL")
    private BigDecimal poIntrnRetl;
    @Column(name = "PO_INTRN_COST")
    private BigDecimal poIntrnCost;
    @Column(name = "TO_ORD_QTY")
    private BigDecimal toOrdQty;
    @Column(name = "TO_ORD_RETL")
    private BigDecimal toOrdRetl;
    @Column(name = "TO_ORD_COST")
    private BigDecimal toOrdCost;
    @Column(name = "TO_INTRN_QTY")
    private BigDecimal toIntrnQty;
    @Column(name = "TO_INTRN_RETL")
    private BigDecimal toIntrnRetl;
    @Column(name = "TO_INTRN_COST")
    private BigDecimal toIntrnCost;
    @Column(name = "FIRST_PIS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstPisDate;
    @Column(name = "LAST_PIS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPisDate;
    @Column(name = "LTD_QTY")
    private BigDecimal ltdQty;
    @Column(name = "LTD_RETL")
    private BigDecimal ltdRetl;
    @Column(name = "LTD_COST")
    private BigDecimal ltdCost;
    @Column(name = "LAST_CHG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChgDate;
    @Column(name = "ON_HAND_WEIGHT")
    private BigDecimal onHandWeight;
   
    @Column(name = "WEIGHT_UOM")
    private String weightUom;
    @Column(name = "PO_ORD_WEIGHT")
    private BigDecimal poOrdWeight;
    @Column(name = "PO_INTRN_WEIGHT")
    private BigDecimal poIntrnWeight;
    @Column(name = "TO_ORD_WEIGHT")
    private BigDecimal toOrdWeight;
    @Column(name = "TO_INTRN_WEIGHT")
    private BigDecimal toIntrnWeight;
    @Column(name = "LTD_WEIGHT")
    private BigDecimal ltdWeight;

    @Column(name = "PRD_SLL_UOM")
    private String prdSllUom;

    @Column(name = "CURR_CODE")
    private String currCode;
    @Column(name = "ON_HAND_EACHES")
    private BigDecimal onHandEaches;
    @Column(name = "FIRST_SHIPPED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstShippedDate;
    @Column(name = "FIRST_SALES_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstSalesDate;
    @Column(name = "ON_HAND_COST_HM")
    private BigDecimal onHandCostHm;
    @Column(name = "ON_HAND_RETL_HM")
    private BigDecimal onHandRetlHm;
    @Column(name = "TO_INTRN_COST_HM")
    private BigDecimal toIntrnCostHm;
    @Column(name = "TO_INTRN_RETL_HM")
    private BigDecimal toIntrnRetlHm;

    
    
}
