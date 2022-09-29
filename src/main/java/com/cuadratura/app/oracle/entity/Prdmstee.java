package com.cuadratura.app.oracle.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "PRDMSTEE", schema = "PMM")

public class Prdmstee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_LVL_CHILD")
    private Long prdLvlChild;
    @Column(name = "PRD_LVL_PARENT")
    private Long prdLvlParent;
    @Column(name = "PRD_LVL_ID")
    private Integer prdLvlId;
    @Column(name = "PRD_NAME_FULL")
    private String prdNameFull;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRD_TARGETGM")
    private BigDecimal prdTargetgm;
    @Column(name = "PRD_LVL_NUMBER")
    private String prdLvlNumber;
    @Column(name = "PRD_LVL_ACTIVE")
    private Character prdLvlActive;
    @Column(name = "PRD_STYLE_IND")
    private Character prdStyleInd;
    @Column(name = "PRD_STATUS")
    private Short prdStatus;
    @Column(name = "PRD_ACT_VAL")
    private Integer prdActVal;
    @Column(name = "PRD_INH_VAL")
    private Integer prdInhVal;
    @Column(name = "PRD_UOM_SIZE")
    private BigDecimal prdUomSize;
    @Column(name = "PRD_SLL_UOM")
    private String prdSllUom;
    @Column(name = "PRD_COMP_UOM")
    private String prdCompUom;
    @Column(name = "PRD_CONV_QTY")
    private BigDecimal prdConvQty;
    @Column(name = "PRD_CROSS_DOCK")
    private Character prdCrossDock;
    @Column(name = "PRD_VPC_TECH_KEY")
    private Long prdVpcTechKey;
    @Column(name = "SPP_SET_PRD_CHILD")
    private Long sppSetPrdChild;
    @Column(name = "ALT_SLL_UOM_1")
    private String altSllUom1;
    @Column(name = "ALT_SLL_UOM_2")
    private String altSllUom2;
    @Column(name = "VAR_WEIGHT_ITEM")
    private Character varWeightItem;
    @Column(name = "VAR_WEIGHT_TYPE")
    private Character varWeightType;
    @Column(name = "PRD_SKU_TYPE")
    private String prdSkuType;
    @Column(name = "PRD_SHRINK_RATE")
    private BigDecimal prdShrinkRate;
    @Column(name = "PRD_WASTE_CODE")
    private String prdWasteCode;
    @Column(name = "PRD_TRNFRM_IND")
    private Character prdTrnfrmInd;
    @Column(name = "PRD_RECIPE_IND")
    private Character prdRecipeInd;
    @Column(name = "PRD_SIZE_UOM")
    private String prdSizeUom;
    @Column(name = "MANDATORY_PLU")
    private Character mandatoryPlu;
    @Column(name = "MANDATORY_PRD_GTIN")
    private Character mandatoryPrdGtin;
    @Column(name = "MANDATORY_CP_GTIN")
    private Character mandatoryCpGtin;

  
}
