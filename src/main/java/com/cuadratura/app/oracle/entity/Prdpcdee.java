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

/**
 *
 * @author Arango
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "PRDPCDEE", schema = "PMM")

public class Prdpcdee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INNER_PK_TECH_KEY")
    private Long innerPkTechKey;
    @Column(name = "INNER_PACK_ID")
    private Long innerPackId;
    @Column(name = "PRD_LVL_CHILD")
    private Long prdLvlChild;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INV_UNITS_PER_INNER")
    private BigDecimal invUnitsPerInner;
    @Column(name = "INV_UOM")
    private String invUom;
    @Column(name = "GRADE_CODE")
    private String gradeCode;
    @Column(name = "SLL_UNITS_PER_INNER")
    private BigDecimal sllUnitsPerInner;
    @Column(name = "EACHES_PER_INNER")
    private Integer eachesPerInner;
    @Column(name = "INNER_PACK_DESC")
    private String innerPackDesc;
    @Column(name = "GROSS_WEIGHT")
    private BigDecimal grossWeight;
    @Column(name = "NET_WEIGHT")
    private BigDecimal netWeight;
    @Column(name = "WEIGHT_UOM")
    private String weightUom;
    @Column(name = "VPC_CASE_WIDTH")
    private BigDecimal vpcCaseWidth;
    @Column(name = "VPC_CASE_LEN")
    private BigDecimal vpcCaseLen;
    @Column(name = "VPC_CASE_HEIGHT")
    private BigDecimal vpcCaseHeight;
    @Column(name = "VPC_CASE_CUBE")
    private BigDecimal vpcCaseCube;
    @Column(name = "DIMENSION_UOM")
    private String dimensionUom;
    @Column(name = "VPC_PALLET_HI")
    private Short vpcPalletHi;
    @Column(name = "VPC_PALLET_TIER")
    private BigDecimal vpcPalletTier;
    @Column(name = "PACK_LVL_PARENT")
    private Long packLvlParent;
    @Column(name = "CASE_CUBE_UOM")
    private String caseCubeUom;
    @Column(name = "LOOSE_PACK_FLAG")
    private Character loosePackFlag;
    @Column(name = "VPC_CUBE_ORD_FCT")
    private BigDecimal vpcCubeOrdFct;

   
}
